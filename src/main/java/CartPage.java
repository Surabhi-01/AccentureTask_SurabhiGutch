import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CartPage {

    private static WebDriver driver;
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static final By listofNames = By.xpath("//td[@class='c11']/following-sibling::td[1]//a[@class='mainItem']");

    public List<String> CartItems(){
        List<WebElement> itemNames = driver.findElements(listofNames);
        List<String> beautyItemNamesCart = new ArrayList<>();
        for(int i=0; i<2;i++) {
            beautyItemNamesCart.add(itemNames.get(i).getText());
        }
        return beautyItemNamesCart;
    }

    public static boolean VerifyCartItemsName(List<String> BeautyPage, List<String> CartPage){
        boolean result = false;
        for (int i =0; i<BeautyPage.size(); i++){
           if(CartPage.get(i).contains(BeautyPage.get(i))){
               result=true;
           }else {
               result=false;
           }
        }
        return result;
    }
}
