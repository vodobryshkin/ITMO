package exceptions;

public class NoGuestsError extends Exception {
    private final String customMessage;

    public NoGuestsError(String message) {
        super(message); // Вызываем конструктор родительского класса
        this.customMessage = message;
    }

    @Override
    public String getMessage() {
        return "NoGuestsError: " + customMessage; // Переопределяем метод getMessage
    }
}
