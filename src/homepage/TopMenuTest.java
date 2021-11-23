package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TopMenuTest extends Utility {

    String baseUrl = "https://mobile.x-cart.com/";

    public void selectMenu(String menu) throws InterruptedException {

        List<WebElement> names = driver.findElements(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//li"));

        for (WebElement name : names) {
            //Thread.sleep(2000);
            if (name.getText().equalsIgnoreCase(menu)) {
                Thread.sleep(2000);
                name.click();
                break;
            }
        }

    }


    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToShippingPageSuccessfully() throws InterruptedException {
        selectMenu("Shipping");
        Thread.sleep(1000);
        useVerifyResult(By.xpath("//h1[@id='page-title']"),"Shipping","Tab not selected");
        }

    @Test
    public void verifyUserShouldNavigateToNewPageSuccessfully() throws InterruptedException {
        selectMenu("Home");
        useVerifyResult(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//li[@class='leaf']//a[1]//span[text()='New!']"),"New!","Tab not selected");

    }

    @Test
    public void verifyUserShouldNavigateToComingsoonPageSuccessfully() throws InterruptedException{
        selectMenu("Coming soon");
        useVerifyResult(By.xpath("//h1[text()='Coming soon']"),"Coming soon","Tab not selected");
    }

    @Test
    public void verifyUserShouldNavigateToContactUsPageSuccessfully() throws InterruptedException{
        selectMenu("Contact us");
        useVerifyResult(By.xpath("//h1[text()='Contact us']"),"Contact us","Tab not selected");
    }


    @After
    public void tearDown(){
        closeBrowser();
    }

}
