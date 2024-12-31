import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.fluent.Target;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase {
    static WebDriver driver;
    Eyes eyes;
    @BeforeAll
    public static void beforeAll() {
        driver = WebDriverManager.chromedriver().create();
    }
    @BeforeEach
    public void beforeEach(TestInfo testInfo) {
        eyes = new Eyes();
        eyes.setApiKey("2tCeC9wT2TC4iUj9cSa101NkYK6G5DsnyNpc101SOES106cwQ110");
        eyes.open(
                driver,
                "My First Tests",
                testInfo.getTestMethod().get().getName(),
                new RectangleSize(1000,600)
        );
    }
    @Test
    public void myTestCaseOne() {
        driver.get("https://applitools.com/helloworld/");
        eyes.check(Target.window());
    }
    @Test
    public void myTestCaseTwo() {
        driver.get("https://applitools.com/helloworld/?diff1");
        eyes.check(Target.window());
    }

    @AfterEach
    public void afterEach() {
        eyes.closeAsync();
    }
    @AfterAll
    public static void afterAll() {
        driver.close();
    }
}
