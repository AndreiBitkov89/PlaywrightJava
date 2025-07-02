package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import valueObjects.NewUser;

public class LoginPage extends BasePage {
    private final Locator title;
    private final Locator inputEmail;
    private final Locator inputPassword;
    private final Locator submit;

    public LoginPage(Page page) {
        super(page);

        title = page.locator("//h2[contains(text(), 'Returning Customer')]");
        inputEmail = page.locator("input#input-email");
        inputPassword = page.locator("input#input-password");
        submit = page.locator("input[type=\"submit\"]");
    }

    @Override
    protected void waitForLoading() {
        this.title.isVisible();
    }

    public LoginPage login(NewUser user) {
        waitForLoading();
        this.inputEmail.fill(user.getEmail());
        this.inputPassword.fill(user.getPassword());

        this.submit.click();
        return this;
    }
}
