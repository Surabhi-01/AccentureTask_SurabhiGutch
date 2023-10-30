import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class BeautyPage {
    private static WebDriver driver;
    public BeautyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static final By makeUp_CategoryBtn = By.xpath("//span[contains(text(),'Make-up')]");
    public static final By priceHighToLowBtn = By.xpath("//a[contains(text(),'Price High to Low')]");
    public static final By listOfItems  = By.xpath("//div[@id='boxc']//a[@class='btnk1']");
    public static final By listofNames = By.xpath("//div[@id='boxc']//a[@class='name browsinglink']");

    public List<String> addMostExpensiveItem(int numberOfItems){
        List<WebElement> beautyItemsBuyBtn = driver.findElements(listOfItems);
        List<WebElement> itemNames = driver.findElements(listofNames);
        List<String> beautyItemNames = new ArrayList<>();

        for(int i = 0;i<numberOfItems;i++){
            beautyItemNames.add(itemNames.get(i).getText());
            beautyItemsBuyBtn.get(i).click();
        }
        return beautyItemNames;
    }

}
