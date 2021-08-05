package homeworks.hwFromLecture7.repositories;

import homeworks.hwFromLecture7.database.ConnectionManager;
import homeworks.hwFromLecture7.model.Animal;
import homeworks.hwFromLecture7.model.Species;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class AnimalRepositoryImpl implements AnimalRepository {
    private final Class<? extends ConnectionManager> classOfConnectionManager;

    public AnimalRepositoryImpl(Class<? extends ConnectionManager> classOfConnectionManager) {
        this.classOfConnectionManager = classOfConnectionManager;
    }

    @Override
    public Optional<Animal> findAnimalByName(String name) {
        // todo
        // now it uses wrong database - it is sample work

        try (ConnectionManager connectionManager = (ConnectionManager) classOfConnectionManager.getMethod("getInstance").invoke(this)) {

            ResultSet set = connectionManager.getConnection().createStatement().executeQuery("select species_name from species;");

            while (set.next()) {
                String spec = set.getString("species_name");
                System.out.println(Species.valueOf(spec));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public List<Animal> findAll() {
        return null;
    }

    @Override
    public void save(Animal animal) {

    }

    @Override
    public void delete(Animal animal) {

    }
}
