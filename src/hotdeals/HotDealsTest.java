package hotdeals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class HotDealsTest extends Utility {

    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifySaleProductsArrangeAlphabetically() throws InterruptedException {

        useMouseHoverAction(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[text()='Hot deals']"));
        useMouseHoverAndClickAction(By.xpath("(//span[contains(text(),'Sale')])[2]"));

        useVerifyResult(By.xpath("//h1[@id='page-title']"),"Sale", "Sale message is not displayed");
        useMouseHoverAction(By.xpath("//span[contains(text(),'Recommended')]"));

        Thread.sleep(500);
        //1.5 Verify that the product arrange alphabetically
        useDataSorting(By.partialLinkText("Name A"));

    }

    @Test
    public void verifySaleProductsPriceArrangeLowToHigh() throws InterruptedException {
        useMouseHoverAction(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
        useMouseHoverAction(By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]"));

        useClickOnElement(By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]"));
        useVerifyResult(By.xpath("//h1[@id='page-title']"),"Sale","user is not on sale page");

        useMouseHoverAction(By.xpath("//span[contains(text(),'Recommended')]"));
        useDataSorting(By.partialLinkText("Price Low - Hi"));


    }

    @Test
    public void verifySaleProductsArrangeByRates() throws InterruptedException {

        useMouseHoverAction(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));


        Thread.sleep(1000);
        useMouseHoverAction(By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]"));

        Thread.sleep(1000);
        useClickOnElement(By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]"));

        useVerifyResult(By.xpath("//h1[@id='page-title']"),"Sale","user is not on sale page");

        useMouseHoverAction(By.xpath("//span[contains(text(),'Recommended')]"));

        useDataSorting(By.partialLinkText("Rates"));



    }

    @Test
    public void verifyBestSellersProductsArrangeByZToA() throws InterruptedException {

        useMouseHoverAction(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));

        useMouseHoverAction(By.xpath("//li[@class='leaf has-sub']//li[2]/a[1]/span"));
        useClickOnElement(By.xpath("//li[@class='leaf has-sub']//li[2]/a[1]/span"));

       useVerifyResult(By.xpath("//h1[@id='page-title']"),"Bestsellers","user is not on bestsellers page");

       useMouseHoverAction(By.xpath("//span[contains(text(),'Sort by:')]"));


        Thread.sleep(1000);
        useDataSorting(By.partialLinkText("Name Z -"));

    }

    @Test
    public void verifyBestSellersProductsPriceArrangeHighToLow() throws InterruptedException {
        useMouseHoverAction(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));

        Thread.sleep(1000);
        useMouseHoverAction(By.xpath("//li[@class='leaf has-sub']//li[2]/a[1]/span"));
        useClickOnElement(By.xpath("//li[@class='leaf has-sub']//li[2]/a[1]/span"));
        useVerifyResult(By.xpath("//h1[@id='page-title']"),"Bestsellers","user is not on bestsellers page");

        useMouseHoverAction(By.xpath("//span[contains(text(),'Sort by:')]"));

        Thread.sleep(1000);
        useDataSorting(By.partialLinkText("Price High - L"));


    }

    @Test
    public void verifyBestSellersProductsArrangeByRates() throws InterruptedException {

        useMouseHoverAction(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));

        Thread.sleep(1000);
        useMouseHoverAction(By.xpath("//li[@class='leaf has-sub']//li[2]/a[1]/span"));
        useClickOnElement(By.xpath("//li[@class='leaf has-sub']//li[2]/a[1]/span"));
        useVerifyResult(By.xpath("//h1[text()='Bestsellers']"),"Bestsellers","user is not on bestsellers page");
        Thread.sleep(1000);
        useMouseHoverAction(By.xpath("//span[contains(text(),'Sort by:')]"));

        Thread.sleep(1000);
        useDataSorting(By.partialLinkText("Rates"));

    }

    @After
    public void tearDown(){
        closeBrowser();
    }

}
