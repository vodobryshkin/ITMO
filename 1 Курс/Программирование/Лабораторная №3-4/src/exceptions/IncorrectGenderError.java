package exceptions;

public class IncorrectGenderError extends RuntimeException {
    private final String customMessage;

    public IncorrectGenderError(String message) {
        super(message);
        this.customMessage = message;
    }

    @Override
    public String getMessage() {
        return "IncorrectGenderError: " + customMessage;
    }
}
