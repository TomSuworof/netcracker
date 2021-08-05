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

    private final Class<? extends ConnectionManager> classOfConnectionManager;

    public AnimalRepositoryImpl(Class<? extends ConnectionManager> classOfConnectionManager) {
        this.classOfConnectionManager = classOfConnectionManager;
    }

    @Override
    public Optional<Animal> findAnimalByName(String name) throws SQLException {
        Animal animal = null;

        try (ConnectionManager connectionManager = (ConnectionManager) classOfConnectionManager.getMethod("getInstance").invoke(this)) {
            Connection conn = connectionManager.getConnection();

            PreparedStatement statement = conn.prepareStatement("select * from animals where animal_name = ?;");
            statement.setString(1, name);
            ResultSet set = statement.executeQuery();

            if (set.next()) {
                String animalName = set.getString("animal_name");
                String animalSpecies = set.getString("animal_species");
                animal = new MyAnimal.AnimalBuilder().getAnimal(animalSpecies, animalName);

                if (set.next()) {
                    throw new SQLException(ANIMAL_DUPLICATE);
                }
            }
        } catch (Exception e) {
            throw new SQLException(e);
        }

        return Optional.ofNullable(animal);
    }

    @Override
    public List<Animal> findAll() throws SQLException {
        List<Animal> animals = new LinkedList<>();

        try (ConnectionManager connectionManager = (ConnectionManager) classOfConnectionManager.getMethod("getInstance").invoke(this)) {
            Connection conn = connectionManager.getConnection();

            PreparedStatement statement = conn.prepareStatement("select * from animals;");
            ResultSet set = statement.executeQuery();

            while (set.next()) {
                String animalName = set.getString("animal_name");
                String animalSpecies = set.getString("animal_species");
                Animal animal = new MyAnimal.AnimalBuilder().getAnimal(animalSpecies, animalName);
                animals.add(animal);
            }
        } catch (Exception e) {
            throw new SQLException(e);
        }

        return animals;
    }

    @Override
    public void save(Animal animal) throws SQLException {
        try (ConnectionManager connectionManager = (ConnectionManager) classOfConnectionManager.getMethod("getInstance").invoke(this)) {
            Connection conn = connectionManager.getConnection();

            conn.setAutoCommit(false);
            PreparedStatement statement = conn.prepareStatement("insert into animals(animal_name, animal_species) values (?, ?);");
            statement.setString(1, animal.getName());
            statement.setString(2, animal.getSpecies().name());
            statement.execute();
            conn.commit();
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }

    @Override
    public void delete(Animal animal) throws SQLException {
        try (ConnectionManager connectionManager = (ConnectionManager) classOfConnectionManager.getMethod("getInstance").invoke(this)) {
            Connection conn = connectionManager.getConnection();

            conn.setAutoCommit(false);
            PreparedStatement statement = conn.prepareStatement("delete from animals where animal_name = ?;");
            statement.setString(1, animal.getName());
            statement.execute();
            conn.commit();
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }
}
