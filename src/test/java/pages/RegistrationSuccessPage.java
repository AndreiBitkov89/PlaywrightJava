package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class RegistrationSuccessPage extends BasePage {
    private final Locator successMessage;
    private final Locator title;

    public RegistrationSuccessPage(Page page) {
        super(page);
        successMessage = page.locator("xpath=//p[contains(text(), 'Congratulations!')]");
        title = page.locator("xpath=//h1[text()='Account']");
    }

    @Override
    protected void waitForLoading() {
        title.waitFor(new Locator.WaitForOptions().setTimeout(1000));
    }

    public boolean getSuccessMessage() {
        successMessage.waitFor(new Locator.WaitForOptions().setTimeout(3000));
        return successMessage.isVisible();
    }


}
