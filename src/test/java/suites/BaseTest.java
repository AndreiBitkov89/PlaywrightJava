package suites;

import com.microsoft.playwright.*;
import config.Config;
import org.junit.jupiter.api.*;
import java.awt.*;

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

    }

    @AfterEach
    public void tearDown(){
        page.close();
        playwright.close();
    }


}
