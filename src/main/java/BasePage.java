import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class BasePage {
    public WebDriver driver ;


    @BeforeMethod
    public void launchBrowser() throws Exception
    {

        Reporter.log("=====Browser session Started=====");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        PropertiesFile propfile = new PropertiesFile();
        driver.get(PropertiesFile.getPropertyValuebyKey("URL"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }



    @AfterMethod
    public void closeBrowser()
    {
        this.driver.quit();
        Reporter.log("====Browser session End====");
    }

}
