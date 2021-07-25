package homeworks.hwFromLecture7.services.executors;

import homeworks.hwFromLecture7.Zoo;
import homeworks.hwFromLecture7.model.Animal;
import homeworks.hwFromLecture7.model.animals.MyAnimal;

public class CheckInExecutor extends Executor {
    public CheckInExecutor(Zoo zoo) {
        super(zoo);
    }

    @Override
    public void execute(String[] arguments) {
        try {
            String species = arguments[0];
            String name = arguments[1];
            checkInAnimal(species, name);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException(UNAVAILABLE_COMMAND);
        }
    }

    private void checkInAnimal(String species, String name) {
        Animal animal = new MyAnimal.AnimalBuilder().getAnimal(species, name);
        zoo.checkInAnimal(animal);
    }
}
