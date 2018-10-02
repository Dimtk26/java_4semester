public class NotCorrectAge extends Exception {
    public NotCorrectAge() {
    }

    public NotCorrectAge(String message) {
        super(message);
    }

    public NotCorrectAge(String message, Throwable cause) {
        super(message, cause);
    }

    public NotCorrectAge(Throwable cause) {
        super(cause);
    }
}
