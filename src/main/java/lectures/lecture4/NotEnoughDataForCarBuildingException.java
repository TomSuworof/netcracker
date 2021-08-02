package lectures.lecture4;

public class NotEnoughDataForCarBuildingException extends Exception {
    private static final String CAR_BUILDER_MESSAGE = "[Not enough data for building car]";

    public NotEnoughDataForCarBuildingException() {
        super(CAR_BUILDER_MESSAGE);
    }

    public NotEnoughDataForCarBuildingException(String message) {
        super(CAR_BUILDER_MESSAGE + " " + message);
    }

    public NotEnoughDataForCarBuildingException(String message, Throwable cause) {
        super(CAR_BUILDER_MESSAGE + " " + message, cause);
    }
}
