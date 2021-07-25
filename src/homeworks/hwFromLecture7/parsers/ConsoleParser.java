package homeworks.hwFromLecture7.parsers;

import homeworks.hwFromLecture7.services.ExecutorFabric;
import homeworks.hwFromLecture7.services.executors.Executor;

public class ConsoleParser implements Parser {
    private final ExecutorFabric fabric;

    public ConsoleParser(ExecutorFabric fabric) {
        this.fabric = fabric;
    }

    @Override
    public void parse(String expression) {
        expression = expression.toLowerCase();

        String command = expression.trim().split(" ")[0];
        String[] arguments = expression.substring(command.length()).trim().split(" ");

        Executor executor = fabric.getExecutor(command);
        executor.execute(arguments);
    }
}