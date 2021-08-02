package homeworks.hwFromLecture7.services.executors;

import homeworks.hwFromLecture7.Zoo;

public abstract class Executor {
    protected static final String UNAVAILABLE_COMMAND = "Sorry, I do not know this command";

    protected Zoo zoo;

    public Executor(Zoo zoo) {
        this.zoo = zoo;
    }

    public abstract void execute(String[] arguments);
}
