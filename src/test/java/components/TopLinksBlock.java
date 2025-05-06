package components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.LocatorAssertions;
import com.microsoft.playwright.options.WaitForSelectorState;
import pages.BasePage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TopLinksBlock extends BasePage {
    private Locator topLinksBlock;
    private Locator dropDownMenu;
    private Locator registerLink;

    public TopLinksBlock(Page page) {
        super(page);
        topLinksBlock = page.locator("#top-links");
        dropDownMenu = page.locator("ul.dropdown-menu-right");
        registerLink = dropDownMenu.getByText("Register");
    }

    @Override
    protected void waitForLoading() {
        topLinksBlock.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
    }

    public void goToRegister(){
        waitForLoading();
        topLinksBlock.locator(".dropdown").click();
        assertThat(dropDownMenu).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(1000));
        registerLink.click();
    }
}
