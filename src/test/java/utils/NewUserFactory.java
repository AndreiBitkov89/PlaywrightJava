package utils;

import valueObjects.NewUser;


public class NewUserFactory {

    public static NewUser generate() {
        String password = RandomDataGenerator.randomPassword();

        return NewUser.builder()
                .firstName(RandomDataGenerator.randomFirstName())
                .lastName(RandomDataGenerator.randomLastName())
                .email(RandomDataGenerator.randomEmail())
                .phone(RandomDataGenerator.randomPhoneNumber())
                .password(password)
                .confirmedPassword(password)
                .build();
    }
}