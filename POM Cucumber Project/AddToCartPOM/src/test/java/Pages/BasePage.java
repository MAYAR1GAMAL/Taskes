package Pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
public class BasePage
{
    protected static WebDriver basePageDriver;
    BasePage(WebDriver driver)
    {
        basePageDriver = driver;
    }
    public static void scrollV(WebDriver driver) throws  Throwable
    {
        //convert javascript to java
        JavascriptExecutor java =(JavascriptExecutor)driver;
        //scroll vertical
        java.executeScript("scroll(0,500)");
        Thread.sleep(5000);
    }
    public void scrollH (WebDriver driver) throws Throwable
    {
        //convert javascript to java
        JavascriptExecutor java =(JavascriptExecutor)driver;
        //scroll Horizontal
        java.executeScript("window.scrollBy(5000,40)");
        Thread.sleep(5000);
    }
}
