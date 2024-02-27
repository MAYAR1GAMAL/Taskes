package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class CartPage extends BasePage
{
    public CartPage(WebDriver driver) {
        super(driver);
    }
    private static By itemsCount = By.xpath("/html/body/vf-root/main/section[2]/vf-my-cart/div/div/div/div[2]/vf-cart-order-summary/div/div/div[1]/div[1]/p[1]");
    public static void getItemsCount() throws Throwable
    {
        String NumItems = basePageDriver.findElement(itemsCount).getText();
        Thread.sleep(7000);
        //Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
        //Assert.assertEquals(NumItems,"Subtotal ( 3 Items )","success");
        //Thread.sleep(5000);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(NumItems, "Subtotal ( 3 Items )", "Number of items in the cart is not as expected");
        Thread.sleep(5000);
        softAssert.assertAll();
        Thread.sleep(5000);
    }
}
