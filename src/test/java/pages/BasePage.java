package pages;
import com.microsoft.playwright.*;

public abstract class BasePage {
    public Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    protected abstract void waitForLoading();
}
