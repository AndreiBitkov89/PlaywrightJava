package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class AccountPage extends BasePage {
    private final Locator title;

    public AccountPage(Page page) {
        super(page);
        this.title = page.locator("//h2[contains(text(), 'My Account')]");
    }

    @Override
    protected void waitForLoading() {
        this.title.waitFor(new Locator.WaitForOptions().setTimeout(3000));
    }

    public boolean isAccountOpen() {
       waitForLoading();
       return title.isVisible();
    }
}
