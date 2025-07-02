package suites;

import org.junit.jupiter.api.*;
import pages.PageManager;
import valueObjects.NewUser;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTests extends BaseTest {
    private final NewUser user = NewUser.builder().email("asd123!@gmail.com").password("Qwerty123").build();
    private PageManager pageManager;

    @BeforeEach
    public void initiateData() {
        pageManager = new PageManager(page);
    }

    @Test
    @Tag("regress")
    @DisplayName("Check correct login")
    public void successfulLogin() {
        pageManager.topLinksBlock().goToLogin();
        pageManager.loginPage().login(user);
        assertTrue(pageManager.accountPage().isAccountOpen());
    }

}
