package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;

public class LoginPage extends BasePage
{
    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    private static By UserName =  By.id("username") ;
    private static By Password = By.id("password");
    private static By Submit = By.id("submitBtn");

    public static void Login(String s1, String s2) throws Throwable
    {
        basePageDriver.findElement(UserName).sendKeys(s1);
        basePageDriver.findElement(Password).sendKeys(s2);
        Thread.sleep(4000);
        basePageDriver.findElement(Submit).click();
    }

    private static By RightLogin = By.xpath("/html/body/vf-root/main/section[1]/vf-nav-bar/nav/div/vf-user-profile/div/button/p/span");
    //Right Login
    public static void RightLoginFunc(String s1)
    {
        String W =basePageDriver.findElement(RightLogin).getText();
        //Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
        AssertJUnit.assertEquals("* * success * *",W,s1);
    }
}
