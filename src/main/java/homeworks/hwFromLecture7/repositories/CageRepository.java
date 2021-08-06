package homeworks.hwFromLecture7.repositories;

import homeworks.hwFromLecture7.model.Animal;
import homeworks.hwFromLecture7.model.Cage;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CageRepository {
    Optional<Cage> findCageByAnimalName(String name) throws SQLException;

    Optional<Cage> findEmptyCageAvailTo(String species) throws SQLException;

    List<Cage> findAll() throws SQLException;

    void saveCageWithAnimal(Cage cage, Animal animal) throws SQLException;
}
