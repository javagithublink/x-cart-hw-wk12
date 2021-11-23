package shopping;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ShoppingTest extends Utility {

    String baseUrl="https://mobile.x-cart.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyForCupOfMojoBluetoothSpeaker () throws InterruptedException {

        useMouseHoverAction(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
        useMouseHoverAndClickAction(By.xpath("(//span[contains(text(),'Sale')])[2]"));
        useVerifyResult(By.xpath("//h1[@id='page-title']"), "Sale", "use is not on sale page");


        useMouseHoverAction(By.xpath("//span[contains(text(),'Sort by:')]"));
        useClickOnElement(By.partialLinkText("Name A -"));


        useMouseHoverAction(By.xpath("//a[@class='product-thumbnail next-previous-assigned']"));
        Thread.sleep(2000);
        useClickOnElement(By.xpath("//button[contains(@class,'regular-button add-to-cart product-add2cart productid-16')]//span[contains(text(),'Add to cart')]"));
        useVerifyResult(By.xpath("//li[@class='info']"), "Product has been added to your cart", "product is not added to cart");


        useClickOnElement(By.cssSelector("a[title='Close']"));
        useClickOnElement(By.xpath("//div[@title='Your cart']"));
        Thread.sleep(2000);
        useClickOnElement(By.xpath("//span[normalize-space()='View cart']"));

        useVerifyResult(By.xpath("//h1[@id='page-title']"), "Your shopping cart - 1 item", "product is not added to cart");


        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@id='amount16']")).clear();

        Thread.sleep(500);
        useSendTextToElement(By.xpath("//input[@id='amount16' and @ name='amount']"), "2");




        Thread.sleep(4000);
        useVerifyResult(By.xpath("//h1[@id='page-title']"), "Your shopping cart - 2 items", "product is not added to cart");

        Thread.sleep(500);
        useVerifyResult(By.xpath("//ul[@class='sums']//span[@class='surcharge-cell']"), "$29.98", "wrong total");

        Thread.sleep(500);
        useVerifyResult(By.xpath("//li[@class='total']//span[@class='surcharge']"), "$36.00", "wrong total");


        useClickOnElement(By.xpath("//button[contains(@class,'regular-button regular-main-button checkout')]"));


        Thread.sleep(500);
        useVerifyResult(By.xpath("//h3[contains(text(),'Log in to your account')]"), "Log in to your account", "incorrect message on log in");

        useSendTextToElement(By.cssSelector("#email"),useGetUniqueEmailAddress());


        useClickOnElement(By.xpath("//button[contains(@class,'regular-button anonymous-continue-button submit')]"));


        useVerifyResult(By.cssSelector(".title"),"Secure Checkout","wrong secure message");


        useSendTextToElement(By.id("shippingaddress-firstname"), "JJJ");
        useSendTextToElement(By.id("shippingaddress-lastname"), "PPP");
        useSendTextToElement(By.id("shippingaddress-street"), "1 North Ave");
        useSendTextToElement(By.id("shippingaddress-custom-state"), "Beds");

        useClickOnElement(By.id("create_profile"));

        useSendTextToElement(By.id("password"), "abcdef123");



        useClickOnElement(By.id("method128"));

        Thread.sleep(500);

        useClickOnElement(By.id("pmethod6"));

        Thread.sleep(500);

        useVerifyResult(By.xpath("//div[@class='total clearfix']//span[@class='surcharge-cell']"),"$37.03","wrong total");
        Thread.sleep(500);

        useClickOnElement(By.cssSelector("button[class='btn regular-button regular-main-button place-order submit']"));

        Thread.sleep(3000);

        useVerifyResult(By.xpath("//h1[text()='Thank you for your order']"),"Thank you for your order","Thank you message not displyed correctly");


    }

    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {

        useMouseHoverAction(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));


        useMouseHoverAction(By.xpath("//li[@class='leaf has-sub']//li[2]/a[1]/span"));
        useClickOnElement(By.xpath("//li[@class='leaf has-sub']//li[2]/a[1]/span"));



        Thread.sleep(500);
        useVerifyResult(By.xpath("//h1[@id='page-title']"),"Bestsellers","user is not on bestsellers page");

        useMouseHoverAction(By.xpath("//span[contains(text(),'Sort by:')]"));
        useClickOnElement(By.partialLinkText("Name A -"));

        useMouseHoverAction(By.cssSelector(" .product.productid-13"));
        Thread.sleep(1000);
        useClickOnElement(By.xpath("//button[@class='btn  regular-button add-to-cart product-add2cart productid-13']/span[1]"));





        useVerifyResult(By.xpath("//li[contains(text(),'Product has been added to your cart')]"),"Product has been added to your cart","product is not on cart");



        Thread.sleep(500);
        useClickOnElement(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[1]/div[1]/div[1]/a[1]"));



        Thread.sleep(500);
        useClickOnElement(By.xpath("//div[@title='Your cart']"));

        Thread.sleep(500);
        useClickOnElement(By.xpath("//span[contains(text(),'View cart')]"));



        Thread.sleep(500);
        useVerifyResult(By.xpath("//h1[@id='page-title']"),"Your shopping cart - 1 item","product is not on cart");



        Thread.sleep(500);
        useClickOnElement(By.xpath("//a[contains(text(),'Empty your cart')]"));

        String alert = useGetTextAlert();
        Assert.assertEquals("Are you sure you want to clear your cart?",useGetTextAlert());

        //String alert = doGetTextFromAlert();
        //String expectedAlert = "Are you sure you want to clear your cart?";
        //Assert.assertEquals("Alert Message is incorrect", expectedAlert, alert);
        Thread.sleep(500);

        useAcceptAlert();
        Thread.sleep(2000);

        useVerifyResult(By.xpath("//li[contains(text(),'Item(s) deleted from your cart')]"),"Item(s) deleted from your cart","product still on cart");
         Thread.sleep(500);

        useVerifyResult(By.xpath("//h1[normalize-space()='Your cart is empty']"),"Your cart is empty","product still on cart");

    }

    @After
    public void tearDown(){
        closeBrowser();
    }


}
