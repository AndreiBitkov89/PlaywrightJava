package suites;

import org.junit.jupiter.api.*;
import pages.PageManager;
import utils.NewUserFactory;
import utils.RandomDataGenerator;
import valueObjects.NewUser;
import static constants.Alerts.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationTests extends BaseTest {
    private NewUser newUser;
    private PageManager pageManager;
    private String password;

    @BeforeEach
    public void initiateData() {
        newUser = NewUserFactory.generate();
        pageManager = new PageManager(page);
        password = RandomDataGenerator.randomPassword();
    }

    @Test
    @Tag("regress")
    @DisplayName("Check correct registration")
    public void successfulRegistration() {
        pageManager.topLinksBlock().goToRegister();
        pageManager.registrationPage().registerUser(newUser, true, true);
        assertTrue(pageManager.successPage().getSuccessMessage());
    }

    @Test
    @Tag("regress")
    @DisplayName("Check registration with unchecked policy")
    public void shouldReturnMistakeAfterRegistrationWithoutPolicy() {
        pageManager.topLinksBlock().goToRegister();
        pageManager.registrationPage().registerUser(newUser, false, true);
        assertEquals(PRIVACY.getMessage(), pageManager.registrationPage().getPolicyAlertText());
    }

    @Test
    @Tag("regress")
    @DisplayName("Check unsuccessful registration with empty name")
    public void shouldShowAlertWithEmptyName() {
        newUser = NewUser.builder()
                .lastName(RandomDataGenerator.randomLastName())
                .email(RandomDataGenerator.randomEmail())
                .phone(RandomDataGenerator.randomPhoneNumber())
                .password(password)
                .confirmedPassword(password)
                .build();

        pageManager.topLinksBlock().goToRegister();
        pageManager.registrationPage().registerUser(newUser, true, false);
        assertEquals(EMPTY_NAME.getMessage(), pageManager.registrationPage().getFieldAlertText());
    }
}
