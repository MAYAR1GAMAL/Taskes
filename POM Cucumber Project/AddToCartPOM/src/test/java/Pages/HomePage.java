package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver)
    {
        super(driver);
    }
    //LoginIcon
    private By LoginIcon= By.id("userProfileMenu");
    //CartIcon
    private static By CartIcon = By.className("cart-btn");
    //LogoIcon TO go to home pge
    private By Logo = By.className("logo");
    //search icon
    private By SearchIcon = By.id("searchInput");
    //Exit in SmallWindow
    private By SmallWindow = By.xpath("//*[@id=\"onetrust-close-btn-container\"]/button");

    //to click in exit in small window  //Cookies settings//
    public void ExitSmallWindow()
    {
        basePageDriver.findElement(SmallWindow).click();
    }
    public void GoToLoginPage()
    {
        basePageDriver.findElement(LoginIcon).click();
    }
    public static void GoToCartPage() throws Throwable
    {
        Thread.sleep(4000);
        basePageDriver.findElement(CartIcon).click();
        Thread.sleep(4000);
    }
    public void GoToHomePage() throws Throwable
    {
        basePageDriver.findElement(Logo).click();
        Thread.sleep(5000);
    }
    public void SearchBar(String s1 , String s2) throws Throwable
    {
        basePageDriver.findElement(SearchIcon).click();
        Thread.sleep(2000);
        basePageDriver.findElement(SearchIcon).sendKeys(s1);
        Thread.sleep(2000);
        basePageDriver.findElement(SearchIcon).click();
        Thread.sleep(2000);
        basePageDriver.findElement(SearchIcon).sendKeys(s2);
        Thread.sleep(5000);
    }
}
