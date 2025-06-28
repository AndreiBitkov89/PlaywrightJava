package constants;

public enum Alerts {

    PRIVACY("Warning: You must agree to the Privacy Policy!"),
    EMPTY_NAME("First Name must be between 1 and 32 characters!");

    final String message;

    Alerts(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
