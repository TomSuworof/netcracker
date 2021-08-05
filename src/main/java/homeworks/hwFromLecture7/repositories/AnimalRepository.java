package homeworks.hwFromLecture7.repositories;

import homeworks.hwFromLecture7.model.Animal;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface AnimalRepository {
    Optional<Animal> findAnimalByName(String name) throws SQLException;

    List<Animal> findAll() throws SQLException;

    void save(Animal animal) throws SQLException;

    void delete(Animal animal) throws SQLException;
}
