package homeworks.hwFromLecture7.services.executors;

import homeworks.hwFromLecture7.Zoo;
import homeworks.hwFromLecture7.model.Species;
import homeworks.hwFromLecture7.model.animals.MyAnimal;

public class CheckOutExecutor extends Executor {
    private static final String ANIMAL_DOES_NOT_EXIST = "We do not have this animal";

    public CheckOutExecutor(Zoo zoo) {
        super(zoo);
    }

    @Override
    public void execute(String[] arguments) {
        String name = arguments[0];
        checkOutAnimal(name);
    }

    private void checkOutAnimal(String name) {
        boolean found = false;
        for (Species species : Species.values()) {
            try {
                zoo.checkOutAnimal(new MyAnimal.AnimalBuilder().getAnimal(species.toString(), name));
                found = true;
                break;
            } catch (IllegalArgumentException ignored) {
            }
        }
        if (!found) {
            throw new IllegalArgumentException(ANIMAL_DOES_NOT_EXIST);
        }
    }
}
