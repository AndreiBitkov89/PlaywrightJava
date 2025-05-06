package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class MainPage extends BasePage{
    private Locator topLinksBlock;
    private Locator topLinksDropdown;

    public MainPage(Page page) {
        super(page);
        topLinksBlock = page.locator("#top-links");
        topLinksDropdown = topLinksBlock.locator(".dropdown");

    }

    @Override
    protected void waitForLoading() {

    }
}
