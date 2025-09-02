package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import plugins.retry.RetryAnalyzer;

public class LocatorsTest extends BaseTest {

    @Test(testName = "Тест локаторов сайта", description = "Прверка локаторов",
            retryAnalyzer = RetryAnalyzer.class)
    public void checkLocators() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name"));
        driver.findElement(By.name("user-name"));
        driver.findElement(By.className("login_wrapper-inner"));
        driver.findElement(By.tagName("div"));
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.linkText("Sauce Labs Backpack"));
        driver.findElement(By.partialLinkText("Backpack"));
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']"));
        driver.findElement(By.xpath("//a[text()='LinkedIn']"));
        driver.findElement(By.xpath("//button[contains(@id,'onesie')]"));
        driver.findElement(By.xpath("//div[contains(text(),'Jacket')]"));
        driver.findElement(By.xpath("//*[text()='Sauce Labs Bolt T-Shirt']//ancestor::div"));
        driver.findElement(By.xpath("//div[@class='pricebar']//" +
                "descendant::button"));
        driver.findElement(By.xpath("//div[@class='inventory_item_label']/following::button"));
        driver.findElement(By.xpath("//a[@id='item_3_title_link']/parent::div"));
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.className("shopping_cart_link")).click();
        driver.findElement(By.xpath("//div[@class='inventory_item_desc']/preceding::a"));
        driver.findElement(By.cssSelector(".inventory_item_name"));
        driver.findElement(By.id("continue-shopping")).click();
        driver.findElement(By.cssSelector(".btn.btn_primary"));
        driver.findElement(By.cssSelector(".inventory_item .btn"));
        driver.findElement(By.cssSelector("#react-burger-menu-btn"));
        driver.findElement(By.cssSelector("button"));
        driver.findElement(By.cssSelector("button.btn"));
        driver.findElement(By.className("shopping_cart_link")).click();
        driver.findElement(By.cssSelector("[name='checkout']"));
        driver.findElement(By.cssSelector("[id~='continue-shopping']"));
        driver.findElement(By.cssSelector("[id|='remove']"));
        driver.findElement(By.id("continue-shopping")).click();
        driver.findElement(By.cssSelector("[src^='/static/']"));
        driver.findElement(By.cssSelector("[src$='.jpg']"));
        driver.findElement(By.cssSelector("[data-test*='cart']"));
    }
}