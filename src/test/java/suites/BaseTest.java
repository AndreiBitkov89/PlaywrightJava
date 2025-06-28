package suites;

import com.microsoft.playwright.*;
import config.Config;
import extension.TestResultWatcher;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.awt.*;

@ExtendWith(TestResultWatcher.class)
public class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;
    protected String url = Config.getBaseUrl();

    @BeforeEach
    public void initialize(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(width, height));
        page = context.newPage();
        page.navigate(url);

        TestResultWatcher.setPage(page);

    }

    @AfterEach
    public void tearDown(){
        if (page != null) page.close();
        if (playwright != null) playwright.close();
    }


}
