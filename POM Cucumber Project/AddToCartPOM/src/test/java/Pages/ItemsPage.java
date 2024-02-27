package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ItemsPage extends BasePage
{
    public ItemsPage(WebDriver driver)
    {
        super(driver);
    }
    private static By TrueWireless = By.xpath("/html/body/vf-root/main/section[2]/vf-landing-page/vf-ng-main-container[1]/section/div/div[1]/button[8]");

    public static void GoToTrueWireless()
    {
        basePageDriver.findElement(TrueWireless).click();
    }

    private static By ISAVAILABLE = By.xpath("/html/body/vf-root/main/section[2]/vf-middleware/vf-product-details-page/div[2]/div/div/div[1]/div[3]/p");
    public static boolean isOutOfStock() {
        return basePageDriver.findElement(ISAVAILABLE).getText().equals("Out Of Stock");
    }
    public static boolean AvailablePlans() {
        return basePageDriver.findElement(ISAVAILABLE).getText().equals("Available Installment Plans:");
    }
    public static By category_tabs_section =By.className("tab");
    public static By category_product_card =By.className("product-card");

    public static By SelectFromSearch = By.xpath("/html/body/vf-root/main/section[1]/vf-nav-bar/nav/div/div[2]/vf-search-engine/div[1]/div[2]/div[2]/div");
    public static By ExitSearchBarAfterSelection = By.xpath("/html/body/vf-root/main/section[1]/vf-nav-bar/nav/div/div[2]/vf-search-engine/div[1]/div[1]/img");
    public void SelectFromSearchFunc () throws Throwable
    {
        Thread.sleep(5000);
        basePageDriver.findElement(SelectFromSearch).click();
        Thread.sleep(8000);
        basePageDriver.findElement(ExitSearchBarAfterSelection).click();
        Thread.sleep(5000);
    }
    public static void selectProduct(int num) throws Throwable
    {
        BasePage.scrollV(basePageDriver);
        List<WebElement> productCards = basePageDriver.findElements(category_product_card);
        Thread.sleep(5000);
        productCards.get(num).click();
        Thread.sleep(5000);
    }
    public static int selectProductListSize() throws Throwable
    {
        Thread.sleep(4000);
        BasePage.scrollV(basePageDriver);
        List<WebElement> productCards = basePageDriver.findElements(By.className("product-card"));
        int Count = productCards.size();
        return Count;
    }
    public static By ADDTOCARTBUTTON =By.className("add-to-cart");
    public static void ADDToCart() throws Throwable
    {
        Thread.sleep(8000);
        basePageDriver.findElement(ADDTOCARTBUTTON).click();
        Thread.sleep(3000);
    }

}