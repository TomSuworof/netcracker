package homeworks.hwFromLecture7.repositories;

import homeworks.hwFromLecture7.database.ConnectionManager;
import homeworks.hwFromLecture7.model.Animal;
import homeworks.hwFromLecture7.model.Cage;
import homeworks.hwFromLecture7.model.Species;
import homeworks.hwFromLecture7.model.animals.MyAnimal;
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
        // required fields for cage: cage_number, cage_area, cage_condition
        // cage needs animal
        // required fields for animal: animal_name, animal_species

        int cageNumber = set.getInt("cage_number");
        double cageArea = set.getDouble("cage_area");
        String[] cageConditionArray = (String[]) set.getArray("cage_condition").getArray();

        List<Species> cageSpecies = Arrays.stream(cageConditionArray)
                .map(Species::valueOf)
                .collect(Collectors.toList());

        Cage cage = new MyCage(cageNumber, cageArea, cageSpecies);

        String animalName = set.getString("animal_name");

        if (animalName == null) {
            cage.setAnimal(null);
        } else {
            String animalSpecies = set.getString("animal_species");
            Animal animal = new MyAnimal.AnimalBuilder().getAnimal(animalSpecies, animalName);
            cage.setAnimal(animal);
        }

        return cage;
    }

    @Override
    public Optional<Cage> findCageByAnimalName(String animalName) throws SQLException {
        Cage cage = null;

        Connection conn = connectionManager.getConnection();

        PreparedStatement statement = conn.prepareStatement(
                "SELECT cage_number, cage_area, cage_condition, a.animal_name, a.animal_species" +
                        " FROM cages LEFT JOIN animals a on cages.animal_name = a.animal_name WHERE a.animal_name = ?;"
        );
        statement.setString(1, animalName);
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
    public Optional<Cage> findEmptyCageAvailTo(String species) throws SQLException {
        Cage cage = null;

        Connection conn = connectionManager.getConnection();

        PreparedStatement statement = conn.prepareStatement(
                "SELECT cage_number, cage_area, cage_condition, a.animal_name, a.animal_species" +
                        " FROM cages LEFT JOIN animals a on cages.animal_name = a.animal_name" +
                        " WHERE a.animal_name IS NULL AND ? = ANY(cage_condition);"
        );
        statement.setString(1, species);
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

        PreparedStatement statement = conn.prepareStatement(
                "SELECT cage_number, cage_area, cage_condition, a.animal_name, a.animal_species" +
                        " FROM cages LEFT JOIN animals a on cages.animal_name = a.animal_name;"
        );
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
        if (animalInCage == null) {
            statement.setNull(3, Types.VARCHAR);
        } else {
            statement.setString(3, animalInCage.getName());
        }

        // take species' names from cage's condition
        String[] species = cage.getCondition().isAvailableFor().stream().map(Enum::name).toArray(String[]::new);
        Array speciesArray = conn.createArrayOf("varchar", species);

        statement.setArray(4, speciesArray);
        statement.execute();
        conn.commit();
    }
}
