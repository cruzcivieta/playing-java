package thread.practice;


public class ResourceNotAvailableException extends Exception {

    public ResourceNotAvailableException(String message) {
        super("Resource not available for " + message);
    }

    public static ResourceNotAvailableException forWriting() {
        return new ResourceNotAvailableException("writing");
    }

    public static ResourceNotAvailableException forReading() {
        return new ResourceNotAvailableException("reading");
    }
}
