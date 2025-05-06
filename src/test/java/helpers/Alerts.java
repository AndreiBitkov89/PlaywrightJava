package helpers;

public enum Alerts {

    PRIVACY("Warning: You must agree to the Privacy Policy!"),
    EMPTYNAME("First Name must be between 1 and 32 characters!");

    String message;

    Alerts(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
