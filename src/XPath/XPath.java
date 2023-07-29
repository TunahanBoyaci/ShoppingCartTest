package XPath;

import Utilities.MyMethods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Test;

import java.util.List;

import static Utilities.BaseDriver.driver;
import static Utilities.BaseDriver.waitAndQuit;

public class XPath {

    @Test
    public void test1(){
        driver.get("https://www.saucedemo.com/");

        WebElement userNameInbox = driver.findElement(By.xpath("//input[@id='user-name']"));
        userNameInbox.sendKeys("standard_user");

        WebElement passwordInbox = driver.findElement(By.xpath("//input[@id='password']"));
        passwordInbox.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();

        WebElement backpackButton = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        backpackButton.click();

        WebElement addToCartButton = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        addToCartButton.click();

        driver.navigate().back();

        MyMethods.myWait(1);

        WebElement tshirtButton = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Bolt T-Shirt')]"));
        tshirtButton.click();

        WebElement addToCartButton2 = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']"));
        addToCartButton2.click();

        driver.navigate().back();

        MyMethods.myWait(1);

        WebElement cartButton = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        cartButton.click();

        WebElement checkoutButton = driver.findElement(By.xpath("//button[@id='checkout']"));
        checkoutButton.click();

        MyMethods.myWait(1);

        WebElement firstNameInbox = driver.findElement(By.xpath("//input[@id='first-name']"));
        firstNameInbox.sendKeys("Tuna");

        WebElement lastNameInbox = driver.findElement(By.xpath("//input[@id='last-name']"));
        lastNameInbox.sendKeys("Byc");

        WebElement zipCodeInbox = driver.findElement(By.xpath("//input[@id='postal-code']"));
        zipCodeInbox.sendKeys("10011");

        WebElement continueButton = driver.findElement(By.xpath("//input[@id='continue']"));
        continueButton.click();

        MyMethods.myWait(1);

        // Backpack and Tshirt Price
        List<WebElement> productList = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        double manuallyTotalPrice = 0.0;
        for (WebElement w : productList){
            manuallyTotalPrice += Double.parseDouble(w.getText().substring(1));
        }

        //Total Price
        WebElement totalLabel = driver.findElement(By.xpath("//div[@class='summary_subtotal_label']"));
        Double subTotalPrice = Double.parseDouble(totalLabel.getText().replaceAll("[^0-9,.]",""));

        Assert.assertTrue("Test Failed",manuallyTotalPrice == subTotalPrice);

        waitAndQuit();
    }
}
