package Defination;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import io.cucumber.java.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import io.cucumber.java.en.*;

public class TestCasses
{
    WebDriver Adriver;
    private static final Logger LOGGER = Logger.getLogger(TestCasses.class.getName());

    @Given("user in login")
    public void user_in_login() throws Throwable
    {
        LOGGER.info("Starting user login");
        // Setup Chrome WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        // Initialize ChromeDriver instance
        Adriver = new ChromeDriver();
        Adriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        //website to teat login
        Adriver.get("https://eshop.vodafone.com.eg/en/");
        Adriver.manage().window().maximize();
        Thread.sleep(2000);
        //to click in exit in small window  //Cookies settings//
        Adriver.findElement(By.xpath("//*[@id=\"onetrust-close-btn-container\"]/button")).click();
        Thread.sleep(1000);
        //for go to login page
        //   //*[@id="userProfileMenu"]/button/img
        Adriver.findElement(By.xpath("//*[@id=\"userProfileMenu\"]/button/img")).click();
        Thread.sleep(1000);
        //enter phone number
        //username
        Adriver.findElement(By.id("username")).sendKeys("***********");
        Thread.sleep(1000);
        //enter passward
        //password
        Adriver.findElement(By.id("password")).sendKeys("***********");
        Thread.sleep(1000);
        //name=login   id=submitBtn
        Adriver.findElement(By.id("submitBtn") ).click();
        Thread.sleep(2000);

        //Right Login
        String W =Adriver.findElement(By.xpath("//*[@id=\"userProfileMenu\"]/button/p/span")).getText();
        //Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
        AssertJUnit.assertEquals("success",W,"Mayar");

        System.out.println("**************End Given***********");
        LOGGER.info("Login successful");
    }

    @When("user add two items to cart")
    public void user_add_two_items_to_cart() throws Throwable
    {
        LOGGER.info("Adding two items to cart");

		int j = 0;
		// True Wireless
		Adriver.findElement(By.xpath("/html/body/vf-root/main/section[2]/vf-landing-page/vf-ng-main-container[1]/section/div/div[1]/button[8]")).click();
		Thread.sleep(4000);
		// Get all the elements available with tag name 'product-card'
        List<WebElement> elements = Adriver.findElements(By.className("product-card"));

	    boolean B = false ;
    	boolean B2 = false;

        for (int i=0; i<=elements.size(); i++)
        {
    		System.out.println(i+" = i********** loop1      j=  "+j+" ***** ");
        	elements = Adriver.findElements(By.className("product-card"));
            //Clicking on the first element
            elements.get(i).click();
            Thread.sleep(5000);
            //Out Of Stock
            String Out=Adriver.findElement(By.xpath("/html/body/vf-root/main/section[2]/vf-middleware/vf-product-details-page/div[2]/div/div/div[1]/div[3]/p")).getText();
            B=Out.equals("Out Of Stock");//b=true
            System.out.println(Out+ " = Out ***"+i+" = i****************B=  "+ B +" ***** ");
            //Available Installment Plans:
            B2=Out.equals("Available Installment Plans:");//b2=true
            System.out.println(Out+" = Out **"+i+" = i****************B2=  "+ B2 +" ***** ");

            if (B2==true)
            {
                Thread.sleep(7000);
                //ADD To Cart
                //boolean is = Adriver.findElement(By.className("add-to-cart")).isEnabled();
                //String text = Adriver.findElement(By.className("add-to-cart")).getText();
                //System.out.println("***** is = "+is+" **** text = "+ text);
                Adriver.findElement(By.className("add-to-cart")).click();
                Thread.sleep(6000);
                j++;
                if(j==2) {break;}
                //Go To Home Page again
                Adriver.findElement(By.className("logo")).click();
                // True Wireless
                Adriver.findElement(By.xpath("/html/body/vf-root/main/section[2]/vf-landing-page/vf-ng-main-container[1]/section/div/div[1]/button[8]")).click();
                Thread.sleep(4000);
            }
            else
            {
                Thread.sleep(5000);
                //Go To Home Page again
                Adriver.findElement(By.className("logo")).click();
                System.out.println(i+" = i**********loop2       j=  "+j+" ***** B = "+B);
                System.out.println("***Go To Home Page again****");
                Thread.sleep(7000);
                // True Wireless
                Adriver.findElement(By.xpath("/html/body/vf-root/main/section[2]/vf-landing-page/vf-ng-main-container[1]/section/div/div[1]/button[8]")).click();
                Thread.sleep(4000);
            }
        }
        LOGGER.info("Items added to cart");
    }

    @And("user add item from search to cart")
    public void user_add_item_from_search_to_cart() throws Throwable
    {
        LOGGER.info("Adding item from search to cart");
        Adriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

        boolean B = false ;
        boolean B2 = false;
        int j = 0 ;
        //Go To Home Page again
        //Adriver.findElement(By.className("logo")).click();
        Thread.sleep(4000);
        Adriver.findElement(By.id("searchInput")).click();
        Thread.sleep(4000);
        //type in search  Smart Phone   searchInput
        Adriver.findElement(By.id("searchInput")).sendKeys("sam");
        Thread.sleep(1000);
        Adriver.findElement(By.id("searchInput")).click();
        Thread.sleep(2000);
        Adriver.findElement(By.id("searchInput")).sendKeys("sung");
        Thread.sleep(5000);
        //select from search
        Adriver.findElement(By.xpath("/html/body/vf-root/main/section[1]/vf-nav-bar/nav/div/div[2]/vf-search-engine/div[1]/div[2]/div[2]/div")).click();
        Thread.sleep(4000);

        // Get all the elements available with tag name 'product-card'
        List<WebElement> elements = Adriver.findElements(By.className("product-card"));
        Thread.sleep(5000);
        for (int i=0 ; i<=elements.size(); i+=2)
        {
            //convert javascript to java
            JavascriptExecutor java =(JavascriptExecutor)Adriver;
            //scroll vertical
            java.executeScript("scroll(0,500)");
            System.out.println(i +" = i ****** elements = "+elements.get(i));
            elements = Adriver.findElements(By.className("product-card"));
            Thread.sleep(7000);
            //Clicking on the Last element
            elements.get(i).click();
            Thread.sleep(5000);

            //Out Of Stock
            String Out=Adriver.findElement(By.xpath("/html/body/vf-root/main/section[2]/vf-middleware/vf-product-details-page/div[2]/div/div/div[1]/div[3]/p")).getText();
            B=Out.equals("Out Of Stock");//b=true
            System.out.println(Out+ " = Out ***"+i+" = i****************B=  "+ B +" ***** ");
            //Available Installment Plans:
            B2=Out.equals("Available Installment Plans:");//b2=true
            System.out.println(Out+" = Out **"+i+" = i****************B2=  "+ B2 +" ***** ");


            if (B==false & B2==true)
            {
                Thread.sleep(6000);
                //ADD To Cart
                //boolean is = Adriver.findElement(By.className("add-to-cart")).isEnabled();
                //String text = Adriver.findElement(By.className("add-to-cart")).getText();
                //System.out.println("***** is = "+is+" **** text = "+ text);
                Adriver.findElement(By.className("add-to-cart")).click();
                Thread.sleep(4000);
                j++;
                break;
            }
            else
            {
                System.out.println("***Go To Home Page again****");
                //Go To Home Page again
                Adriver.findElement(By.className("logo")).click();
                //j=0;
                System.out.println(i+" = i******* loop2       j=  "+j+" ***** B = "+B);
                Thread.sleep(4000);
                //search bar
                Adriver.findElement(By.id("searchInput")).click();
                Thread.sleep(4000);
                Adriver.findElement(By.id("searchInput")).clear();
                Thread.sleep(4000);
                //search bar
                Adriver.findElement(By.id("searchInput")).click();
                Thread.sleep(4000);
                //type in search  Smart Phone   searchInput
                Adriver.findElement(By.id("searchInput")).sendKeys("sam");
                Thread.sleep(1000);
                Adriver.findElement(By.id("searchInput")).click();
                Thread.sleep(2000);
                Adriver.findElement(By.id("searchInput")).sendKeys("sung");
                Thread.sleep(5000);
                //select from search
                Adriver.findElement(By.xpath("/html/body/vf-root/main/section[1]/vf-nav-bar/nav/div/div[2]/vf-search-engine/div[1]/div[2]/div[2]/div")).click();
                Thread.sleep(4000);
                //scroll vertical
                java.executeScript("scroll(0,1000)");
                Thread.sleep(10000);
            }
        }
        LOGGER.info("Item added to cart");
    }

    @Then("Go to cart and find three items")
    public void go_to_cart_and_find_three_items() throws Throwable
    {
        LOGGER.info("Going to cart and verifying items");


	    Adriver.findElement(By.xpath("/html/body/vf-root/main/section[1]/vf-nav-bar/nav/div/div[3]/vf-cart/div/button")).click();
		Thread.sleep(7000);
	    ///html/body/vf-root/main/section[2]/vf-my-cart/div/div/div/div[2]/vf-cart-order-summary/div/div/div[1]/div[1]/p[1]
	    String NumItems = Adriver.findElement(By.xpath("/html/body/vf-root/main/section[2]/vf-my-cart/div/div/div/div[2]/vf-cart-order-summary/div/div/div[1]/div[1]/p[1]")).getText();
        Thread.sleep(4000);
		//Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
		Assert.assertEquals(NumItems,"Subtotal ( 3 Items )","success");
		Thread.sleep(4000);
		System.out.println("****************success");


		Adriver.quit();

        LOGGER.info("Items in cart verified");

    }
}
