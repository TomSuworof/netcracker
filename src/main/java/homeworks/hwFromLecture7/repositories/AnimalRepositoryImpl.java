package homeworks.hwFromLecture7.repositories;

import homeworks.hwFromLecture7.database.ConnectionManager;
import homeworks.hwFromLecture7.model.Animal;
import homeworks.hwFromLecture7.model.Cage;
import homeworks.hwFromLecture7.model.animals.MyAnimal;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class AnimalRepositoryImpl implements AnimalRepository {
    private static final String ANIMAL_DUPLICATE = "There are two animals with the same name";

    private static final String FIND_ANIMAL_BY_NAME = "SELECT * FROM animals WHERE animal_name = ?;";
    private static final String FIND_ALL_ANIMALS = "SELECT * FROM  animals;";

    private static final String INSERT_ANIMAL = "INSERT INTO animals(animal_name, animal_species) VALUES (?, ?);";
    private static final String INSERT_ANIMAL_IN_CAGE = "UPDATE cages SET animal_name = ? WHERE cage_number = ?;";

    private static final String DELETE_ANIMAL_BY_NAME = "DELETE FROM animals WHERE animal_name = ?;";
    private static final String DELETE_ANIMAL_FROM_CAGE = "UPDATE cages SET animal_name = NULL WHERE cage_number = ?;";

    private final ConnectionManager connectionManager;

    public AnimalRepositoryImpl(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    private Animal getAnimalFromSet(ResultSet set) throws SQLException {
        String animalName = set.getString("animal_name");
        String animalSpecies = set.getString("animal_species");
        return new MyAnimal.AnimalBuilder().getAnimal(animalSpecies, animalName);
    }

    @Override
    public Optional<Animal> findAnimalByName(String name) throws SQLException {
        Animal animal = null;

        Connection conn = connectionManager.getConnection();

        PreparedStatement statement = conn.prepareStatement(FIND_ANIMAL_BY_NAME);
        statement.setString(1, name);
        ResultSet set = statement.executeQuery();

        if (set.next()) {
            animal = this.getAnimalFromSet(set);

            if (set.next()) {
                throw new SQLException(ANIMAL_DUPLICATE);
            }
        }

        return Optional.ofNullable(animal);
    }

    @Override
    public List<Animal> findAll() throws SQLException {
        List<Animal> animals = new LinkedList<>();

        Connection conn = connectionManager.getConnection();

        PreparedStatement statement = conn.prepareStatement(FIND_ALL_ANIMALS);
        ResultSet set = statement.executeQuery();

        while (set.next()) {
            Animal animal = this.getAnimalFromSet(set);
            animals.add(animal);
        }

        return animals;
    }

    @Override
    public void insertWithCageUpdate(Animal animal, Cage cage) throws SQLException {
        Connection conn = connectionManager.getConnection();

        conn.setAutoCommit(false);

        PreparedStatement animalStatement = conn.prepareStatement(INSERT_ANIMAL);
        animalStatement.setString(1, animal.getName());
        animalStatement.setString(2, animal.getSpecies().name());
        animalStatement.execute();

        PreparedStatement cageStatement = conn.prepareStatement(INSERT_ANIMAL_IN_CAGE);
        cageStatement.setString(1, animal.getName());
        cageStatement.setInt(2, cage.getNumber());
        cageStatement.execute();

        conn.commit();
    }

    @Override
    public void deleteWithCageUpdate(Animal animal, Cage cage) throws SQLException {
        Connection conn = connectionManager.getConnection();

        conn.setAutoCommit(false);

        PreparedStatement animalStatement = conn.prepareStatement(DELETE_ANIMAL_BY_NAME);
        animalStatement.setString(1, animal.getName());
        animalStatement.execute();

        PreparedStatement cageStatement = conn.prepareStatement(DELETE_ANIMAL_FROM_CAGE);
        cageStatement.setInt(1, cage.getNumber());
        cageStatement.execute();

        conn.commit();
    }
}
