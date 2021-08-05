package homeworks.hwFromLecture7.repositories;

import homeworks.hwFromLecture7.model.Animal;

import java.util.List;
import java.util.Optional;

public interface AnimalRepository {
    Optional<Animal> findAnimalByName(String name);

    List<Animal> findAll();

    void save(Animal animal);

    void delete(Animal animal);
}
