package homeworks.hwFromLecture7.repositories;

import homeworks.hwFromLecture7.model.Cage;

import java.util.List;
import java.util.Optional;

public interface CageRepository {
    Optional<Cage> findCageByNumber(int number);

    List<Cage> findAll();

    void save(Cage cage);

    void remove(Cage cage);
}
