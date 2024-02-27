package Definition;

import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ItemsPage;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import static Pages.ItemsPage.selectProductListSize;

public class TestCasess
{
    private static WebDriver driver;
    public HomePage homePage;
    public LoginPage loginPage;
    public CartPage cartPage;
    public ItemsPage itemsPage;
    @BeforeStep
    public void setUp1() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        cartPage = new CartPage(driver);
        itemsPage = new ItemsPage(driver);
    }
    private static final Logger LOGGER = Logger.getLogger(TestCasess.class.getName());
    @Before
    public  void Setup() throws Throwable
    {
        // Setup Chrome WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        // Initialize ChromeDriver instance
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        //website to teat login
        driver.get("https://eshop.vodafone.com.eg/en/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        homePage = new HomePage(driver); // Initialize homePage here
    }
    @Given("user in login")
    public void user_in_login() throws Throwable
    {
        LOGGER.info("Starting user login");
        //to click in exit in small window  //Cookies settings//
        homePage.ExitSmallWindow();
        Thread.sleep(2000);
        //for go to login page
        homePage.GoToLoginPage();
        Thread.sleep(2000);
        //enter phone number
        //username
        loginPage.Login("**********","***********");
        Thread.sleep(5000);
        loginPage.RightLoginFunc("***********");
        System.out.println("**************End Given***********");
        LOGGER.info("Login successful");
    }

    @When("user add two items to cart")
    public void user_add_two_items_to_cart() throws Throwable
    {
        LOGGER.info("Adding two items to cart");
        int j = 0;
        // True Wireless
        ItemsPage.GoToTrueWireless();
        for (int i=0; i<=selectProductListSize(); i++)
        {
            ItemsPage.selectProduct(i);
            if (ItemsPage.AvailablePlans())
            {
                ItemsPage.ADDToCart();
                j++;
                if(j==2) {break;}
                //Undo
                driver.navigate().back();
            }
            else
            {
                //Undo
                driver.navigate().back();
                Thread.sleep(5000);
            }
        }
        LOGGER.info("Items added to cart");
    }
    @And("user add item from search to cart")
    public void user_add_item_from_search_to_cart() throws Throwable
    {
        LOGGER.info("Adding item from search to cart");
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        //GoToHomePage()
        homePage.GoToHomePage();
        //SearchBar(String s1 , String s2)
        homePage.SearchBar("sam","sung");
        //select from search
        itemsPage.SelectFromSearchFunc();
        Thread.sleep(5000);
        for (int i = 0; i<= selectProductListSize(); i+=2)
        {
            System.out.println(i +" = i ****** ");
            ItemsPage.selectProduct(i);
            if (ItemsPage.AvailablePlans())
            {
                ItemsPage.ADDToCart();
                break;
            }
            else
            {
                System.out.println("***Go To Home Page again****");
                //UnDo
                driver.navigate().back();
                Thread.sleep(10000);
            }
        }
        LOGGER.info("Item added to cart");
    }

    @Then("Go to cart and find three items")
    public void go_to_cart_and_find_three_items() throws Throwable
    {
        LOGGER.info("Going to cart and verifying items");
        HomePage.GoToCartPage();
        CartPage.getItemsCount();
        System.out.println("****************");
        driver.quit();
        LOGGER.info("Items in cart verified");
    }
}
