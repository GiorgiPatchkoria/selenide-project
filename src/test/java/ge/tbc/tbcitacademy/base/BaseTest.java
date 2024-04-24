package ge.tbc.tbcitacademy.base;

import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.closeWebDriver;

import com.codeborne.selenide.logevents.SelenideLogger;
import ge.tbc.tbcitacademy.utils.ScreenshotSaver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    @BeforeMethod
    public void setUp(){
        Configuration.browser = "chrome";
        WebDriverManager.chromedriver().setup();
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 5000;
        SelenideLogger.addListener("AllureSelenide", new ScreenshotSaver());
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("safebrowsing.enabled", false);
        options.setExperimentalOption("prefs", prefs);
        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
    }

    @AfterMethod
    public void tearDown(){
        closeWebDriver();
    }
}
