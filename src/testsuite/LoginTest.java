package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilites.Utility;

import java.util.List;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        // Enter “standard_user” username
        sendTextToElement(By.xpath("//input[@id='user-name']"),"standard_user");

        //Enter “secret_sauce” password
        sendTextToElement(By.xpath("//input[@id='password']"),"secret_sauce");

        // Click on ‘LOGIN’ button
        clickOnElement(By.id("login-button"));

        //verify the text products
        String expectedText="Products";
        String actualText=driver.findElement(By.xpath("//span[contains(text(),'Products')]")).getText();
        Assert.assertEquals("text matched",expectedText,actualText);

    }
    public void verifyThatSixProductsAreDisplayedOnPage(){
        // Enter “standard_user” username
        sendTextToElement(By.xpath("//input[@id='user-name']"),"standard_user");

        //Enter “secret_sauce” password
        sendTextToElement(By.xpath("//input[@id='password']"),"secret_sauce");

        // Click on ‘LOGIN’ button
        clickOnElement(By.id("login-button"));

        //Verify that six products are displayed on page
        List<WebElement> list =driver.findElements(By.className("inventory_item"));
        System.out.println("Total products are =" +list.size());
        int actual=6;
        int expected = list.size();
        Assert.assertEquals("Size is equal",actual,expected);


    }


    @After
    public void tearDown() {
        //   closeBrowser();
    }
}


