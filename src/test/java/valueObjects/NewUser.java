package valueObjects;

public class NewUser {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phone;
    private final String password;
    private final String confirmedPassword;


    public NewUser(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.phone = builder.phone;
        this.password = builder.password;
        this.confirmedPassword = builder.confirmedPassword;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getPassword() { return password; }
    public String getConfirmedPassword() { return confirmedPassword; }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        private String password;
        private String confirmedPassword;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder confirmedPassword(String confirmedPassword) {
            this.confirmedPassword = confirmedPassword;
            return this;
        }

        public NewUser build() {
            return new NewUser(this);
        }
    }
}