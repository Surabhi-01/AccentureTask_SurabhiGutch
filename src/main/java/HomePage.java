import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private static WebDriver driver ;

    public HomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public static final By understandBtn =By.xpath("//a[contains(text(),'I understand')]");
    public static final By loginBtn = By.xpath("//span[@title = 'Sign in']");
    private static final By EmailID = By.xpath("//input[@id='userName']");
    private static final By pwd = By.xpath("//input[@id='password']");
    public static final By LoginBtn = By.xpath("//button[@id='btnLogin']");
    public static final By BeautyCategoryOption = By.xpath("//ul[@class='fmenu']/li/a[contains(text(),'Beauty')]");

    PropertiesFile propfile = new PropertiesFile();
    private static final String userName;

    static {
        try {
            userName = PropertiesFile.getPropertyValuebyKey("UserName");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void clickBtn(By element){driver.findElement(element).click();
    }
    public void setUsername(String username) {
        driver.findElement(EmailID).sendKeys(username);
    }
    public void setPassword(String password) {
        driver.findElement(pwd).sendKeys(password);
    }
    public static final By shoppingCartBtn = By.xpath("//a[@title='Go to Shopping Cart']");

    public HomePage clickSignInButton() {
        driver.findElement(LoginBtn).click();
        return new HomePage(driver);
    }

    public HomePage login(String username, String password) {
        setUsername(username);
        setPassword(password);
        return clickSignInButton();
    }

}
