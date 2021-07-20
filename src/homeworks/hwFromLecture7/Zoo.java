package homeworks.hwFromLecture7;

import homeworks.hwFromLecture7.model.Animal;

import java.util.List;

/**
 * entity keep state of Zoo and provide service desk functionality
 * @checkInAnimal method add Animal to Zoo
 * should throw exception when Zoo can't provide place
 * @checkOutAnimal method remove Animal from Zoo
 * @getHistory - method show log of check in and check out
 */

public interface Zoo {
    void checkInAnimal(Animal animal);

    void checkOutAnimal(Animal animal);

    List<InhabitationLog> getHistory();
}