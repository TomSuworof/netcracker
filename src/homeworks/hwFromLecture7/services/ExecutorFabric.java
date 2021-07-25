package homeworks.hwFromLecture7.services;

import homeworks.hwFromLecture7.Zoo;
import homeworks.hwFromLecture7.services.executors.CheckInExecutor;
import homeworks.hwFromLecture7.services.executors.CheckOutExecutor;
import homeworks.hwFromLecture7.services.executors.Executor;
import homeworks.hwFromLecture7.services.executors.LogExecutor;

public class ExecutorFabric {
    private static final String UNAVAILABLE_COMMAND = "Sorry, I do not know this command";
    private final Zoo zoo;

    public ExecutorFabric(Zoo zoo) {
        this.zoo = zoo;
    }

    public Executor getExecutor(String command) {
        return switch (command) {
            case "check-in" -> new CheckInExecutor(zoo);
            case "check-out" -> new CheckOutExecutor(zoo);
            case "log" -> new LogExecutor(zoo);
            default -> throw new IllegalStateException(UNAVAILABLE_COMMAND);
        };
    }
}
