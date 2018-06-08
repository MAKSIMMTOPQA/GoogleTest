import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class GoogleBaseTest {


    WebDriver webDriver;
    GoogleHomePage googleHomePage;

    @BeforeMethod
    public void before() {
        WebDriverManager.chromedriver().setup();

        webDriver = new ChromeDriver();
        webDriver.get("https://www.google.com/");
        googleHomePage = new GoogleHomePage(webDriver);
    }

    @AfterMethod
    public void after() {
        webDriver.close();
    }
}

