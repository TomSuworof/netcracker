package homeworks.hwFromLecture7.repositories;

import homeworks.hwFromLecture7.model.Animal;
import homeworks.hwFromLecture7.model.Cage;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface AnimalRepository {
    Optional<Animal> findAnimalByName(String name) throws SQLException;

    List<Animal> findAll() throws SQLException;

    void insertWithCageUpdate(Animal animal, Cage cage) throws SQLException;

    void deleteWithCageUpdate(Animal animal, Cage cage) throws SQLException;
}
