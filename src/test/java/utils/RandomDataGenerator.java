package utils;

import java.util.Random;
import java.util.UUID;

public class RandomDataGenerator {
    private static final Random RANDOM = new Random();
    private static final String[] FIRST_NAMES = {"Anna", "John", "Maria", "Peter", "Elena", "Mark", "Olga", "James"};
    private static final String[] LAST_NAMES = {"Smith", "Ivanov", "Brown", "Taylor", "Petrov", "Johnson", "Lee", "Garcia"};
    private static final String[] DOMAINS = {"example.com", "test.com", "mail.com"};

    public static String randomFirstName() {
        return FIRST_NAMES[RANDOM.nextInt(FIRST_NAMES.length)];
    }

    public static String randomLastName() {
        return LAST_NAMES[RANDOM.nextInt(LAST_NAMES.length)];
    }

    public static String randomEmail() {
        String localPart = "user" + UUID.randomUUID().toString().substring(0, 6);
        String domain = DOMAINS[RANDOM.nextInt(DOMAINS.length)];
        return localPart + "@" + domain;
    }

    public static String randomPhoneNumber() {
        return "9" + (RANDOM.nextInt(900_000_000) + 100_000_000);
    }

    public static String randomPassword() {
        return "Pass" + (RANDOM.nextInt(9000) + 1000) + "!";
    }
}
