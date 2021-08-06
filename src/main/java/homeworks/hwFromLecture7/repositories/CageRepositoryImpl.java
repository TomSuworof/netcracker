package homeworks.hwFromLecture7.repositories;

import homeworks.hwFromLecture7.database.ConnectionManager;
import homeworks.hwFromLecture7.model.Animal;
import homeworks.hwFromLecture7.model.Cage;
import homeworks.hwFromLecture7.model.Species;
import homeworks.hwFromLecture7.model.cages.MyCage;

import java.sql.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CageRepositoryImpl implements CageRepository {
    private static final String CAGE_DUPLICATE = "There are two cages with the same number";

    private final ConnectionManager connectionManager;

    public CageRepositoryImpl(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    private Cage getCageFromSet(ResultSet set) throws SQLException {
        int cageNumber = set.getInt("cage_number");
        double cageArea = set.getDouble("cage_area");
        String[] cageConditionArray = (String[]) set.getArray("cage_condition").getArray();

        List<Species> cageSpecies = Arrays.stream(cageConditionArray)
                .map(Species::valueOf)
                .collect(Collectors.toList());

        return new MyCage(cageNumber, cageArea, cageSpecies);
    }

    @Override
    public Optional<Cage> findCageByNumber(int number) throws SQLException {
        Cage cage = null;

        Connection conn = connectionManager.getConnection();

        PreparedStatement statement = conn.prepareStatement("SELECT * FROM cages WHERE cage_number = ?;");
        statement.setInt(1, number);
        ResultSet set = statement.executeQuery();

        if (set.next()) {
            cage = this.getCageFromSet(set);

            if (set.next()) {
                throw new SQLException(CAGE_DUPLICATE);
            }
        }

        return Optional.ofNullable(cage);
    }

    @Override
    public List<Cage> findAll() throws SQLException {
        List<Cage> cages = new LinkedList<>();

        Connection conn = connectionManager.getConnection();

        PreparedStatement statement = conn.prepareStatement("SELECT * FROM cages");
        ResultSet set = statement.executeQuery();

        while (set.next()) {
            Cage cage = this.getCageFromSet(set);
            cages.add(cage);
        }

        return cages;
    }

    @Override
    public void saveCageWithAnimal(Cage cage, Animal animalInCage) throws SQLException {
        Connection conn = connectionManager.getConnection();

        conn.setAutoCommit(false);

        // insert cage with new animal or update animal
        PreparedStatement statement = conn.prepareStatement(
                "INSERT INTO cages(cage_number, cage_area, animal_name, cage_condition) VALUES (?, ?, ?, ?)" +
                "ON CONFLICT (cage_number) DO UPDATE SET animal_name = excluded.animal_name;"
        );

        statement.setInt(1, cage.getNumber());
        statement.setDouble(2, cage.getArea());
        if (animalInCage != null) {
            statement.setString(3, animalInCage.getName());
        }

        // take species' names from cage's condition
        String[] species = cage.getCondition().isAvailableFor().stream().map(Enum::name).toArray(String[]::new);
        Array speciesArray = conn.createArrayOf("varchar", species);

        statement.setArray(4, speciesArray);
        statement.execute();
        conn.commit();
    }

    @Override
    public void remove(Cage cage) throws SQLException {
        Connection conn = connectionManager.getConnection();

        conn.setAutoCommit(false);
        PreparedStatement statement = conn.prepareStatement("DELETE FROM cages WHERE cage_number = ?;");
        statement.setInt(1, cage.getNumber());
        statement.execute();
        conn.commit();
    }
}
