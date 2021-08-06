package homeworks.hwFromLecture7.repositories;

import homeworks.hwFromLecture7.database.ConnectionManager;
import homeworks.hwFromLecture7.model.Animal;
import homeworks.hwFromLecture7.model.animals.MyAnimal;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class AnimalRepositoryImpl implements AnimalRepository {
    private static final String ANIMAL_DUPLICATE = "There are two animals with the same name";

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

        PreparedStatement statement = conn.prepareStatement("SELECT * FROM animals WHERE animal_name = ?;");
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

        PreparedStatement statement = conn.prepareStatement("SELECT * FROM  animals;");
        ResultSet set = statement.executeQuery();

        while (set.next()) {
            Animal animal = this.getAnimalFromSet(set);
            animals.add(animal);
        }

        return animals;
    }

    @Override
    public void save(Animal animal) throws SQLException {
        Connection conn = connectionManager.getConnection();

        conn.setAutoCommit(false);
        PreparedStatement statement = conn.prepareStatement("INSERT INTO animals(animal_name, animal_species) VALUES (?, ?);");
        statement.setString(1, animal.getName());
        statement.setString(2, animal.getSpecies().name());
        statement.execute();
        conn.commit();
    }

    @Override
    public void delete(Animal animal) throws SQLException {
        Connection conn = connectionManager.getConnection();

        conn.setAutoCommit(false);
        PreparedStatement statement = conn.prepareStatement("DELETE FROM animals WHERE animal_name = ?;");
        statement.setString(1, animal.getName());
        statement.execute();
        conn.commit();
    }
}
