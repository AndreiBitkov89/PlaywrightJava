package extension;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.extension.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestResultWatcher implements TestWatcher, BeforeTestExecutionCallback, AfterTestExecutionCallback {
    private static final ThreadLocal<String> testName = new ThreadLocal<>();
    private static final ThreadLocal<Page> pageRef = new ThreadLocal<>();

    public static void setPage(Page page) {
        pageRef.set(page);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        Page page = pageRef.get();
        if (page != null) {
            String fileName = context.getDisplayName().replace("()", "") + ".png";
            Path path = Paths.get("screenshots", fileName);
            page.screenshot(new Page.ScreenshotOptions().setPath(path));
            System.out.println("Saved screenshot: " + path.toAbsolutePath());
        }
    }

    @Override
    public void beforeTestExecution(ExtensionContext context) {
        testName.set(context.getDisplayName());
    }

    @Override
    public void afterTestExecution(ExtensionContext context) {
        testName.remove();
        pageRef.remove();
    }
}

