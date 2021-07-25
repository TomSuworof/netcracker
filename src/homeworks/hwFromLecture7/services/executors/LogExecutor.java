package homeworks.hwFromLecture7.services.executors;

import homeworks.hwFromLecture7.Zoo;

public class LogExecutor extends Executor {
    public LogExecutor(Zoo zoo) {
        super(zoo);
    }

    @Override
    public void execute(String[] arguments) {
        if (String.join("", arguments).equals("")) {
            zoo.getHistory().forEach(System.out::println);
        } else {
            throw new IllegalStateException(UNAVAILABLE_COMMAND);
        }
    }
}
