package lectures.lecture2;

public enum CarState {
    IN_DRIVE("in drive"),
    PARKED("parked");

    private final String name;

    CarState(String name) {
        this.name = name;
    }
}
