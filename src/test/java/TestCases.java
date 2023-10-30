
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestCases extends BasePage{

    @Test(description = "Verify adding to 2 most expensive items in cart")
    public void TC001_ExpensiveItemsAddToCart() throws Exception
    {
        HomePage home = new HomePage(driver);
        home.clickBtn(HomePage.understandBtn);
        home.clickBtn(HomePage.loginBtn);

        home.login(PropertiesFile.getPropertyValuebyKey("EmailID"), System.getenv("Password"));

        home.clickBtn(HomePage.BeautyCategoryOption); //Navigating to category of choice : Beauty

        BeautyPage beauty = new BeautyPage(driver);
        home.clickBtn(BeautyPage.makeUp_CategoryBtn);

        home.clickBtn(BeautyPage.priceHighToLowBtn); //Clicking on Price "High to Low" Button to sort the items
        List<String> NameofItemsBeautyPage = beauty.addMostExpensiveItem(2); //Adding 2 most expensive items to cart

        home.clickBtn(HomePage.shoppingCartBtn);
        CartPage cart = new CartPage(driver);
        List<String> NameofItemsCartPage = cart.CartItems();

        Assert.assertTrue(cart.VerifyCartItemsName(NameofItemsBeautyPage, NameofItemsCartPage)); //Verifying that the items added from the beauty page are present in the cart

    }
}
