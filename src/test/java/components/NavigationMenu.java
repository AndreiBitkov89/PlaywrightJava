package components;
import com.microsoft.playwright.Page;
import pages.BasePage;

public class NavigationMenu extends BasePage {

    public NavigationMenu(Page page) {
        super(page);
    }

    @Override
    protected void waitForLoading() {

    }
}
