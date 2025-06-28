package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.LocatorAssertions;
import valueObjects.NewUser;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class RegistrationPage extends BasePage {

    private final Locator personalBlock;
    private final Locator policyAlert;
    private final Locator fieldAlert;

    private final Locator firstNameInput;
    private final Locator lastNameInput;
    private final Locator emailInput;
    private final Locator phoneInput;
    private final Locator passwordInput;
    private final Locator confirmPasswordInput;
    private final Locator policyCheckbox;
    private final Locator continueButton;

    public RegistrationPage(Page page) {
        super(page);
        this.personalBlock = page.locator("fieldset#account");
        this.policyAlert = page.locator(".alert");
        this.fieldAlert = page.locator(".text-danger");

        this.firstNameInput = page.locator("#input-firstname");
        this.lastNameInput = page.locator("#input-lastname");
        this.emailInput = page.locator("#input-email");
        this.phoneInput = page.locator("#input-telephone");
        this.passwordInput = page.locator("#input-password");
        this.confirmPasswordInput = page.locator("#input-confirm");
        this.policyCheckbox = page.locator("input[type='checkbox']");
        this.continueButton = page.locator("input[value='Continue']");
    }

    @Override
    protected void waitForLoading() {
        personalBlock.waitFor(new Locator.WaitForOptions().setTimeout(1000));
    }

    public String getPolicyAlertText() {
        return policyAlert.textContent().trim();
    }

    public String getFieldAlertText() {
        return fieldAlert.textContent().trim();
    }

    public void registerUser(NewUser user, boolean policyChecked, boolean positive) {
        waitForLoading();
        fillForm(user);

        if (policyChecked) {
            policyCheckbox.check();
        } else {
            policyCheckbox.uncheck();
        }

        continueButton.click();

        if (positive && policyChecked) {
            assertThat(personalBlock).isHidden();
        } else if (!positive) {
            assertThat(fieldAlert).isVisible();
        } else {
            assertThat(policyAlert).isVisible();
            assertThat(personalBlock).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(3000));
        }
    }

    private void fillForm(NewUser user) {
        if (user.getFirstName() != null) firstNameInput.fill(user.getFirstName());
        if (user.getLastName() != null) lastNameInput.fill(user.getLastName());
        if (user.getEmail() != null) emailInput.fill(user.getEmail());
        if (user.getPhone() != null) phoneInput.fill(user.getPhone());
        if (user.getPassword() != null) passwordInput.fill(user.getPassword());
        if (user.getConfirmedPassword() != null) confirmPasswordInput.fill(user.getConfirmedPassword());
    }
}
