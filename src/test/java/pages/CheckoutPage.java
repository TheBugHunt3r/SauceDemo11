package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {

    private final By FIRST_NAME = By.xpath("//input[@id='first-name']");
    private final By LAST_NAME = By.xpath("//input[@id='last-name']");
    private final By POSTAL_CODE = By.xpath("//input[@id='postal-code']");
    private final By CONTINUE_BUTTON = By.xpath("//*[@id='continue']");
    private final By TITLE = By.className("title");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage open() {
        driver.get(BASE_URL + "checkout-step-one.html");
        return this;
    }

    public ProductsPage enterInfo(String first_name, String last_name, String zip) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(FIRST_NAME));
        driver.findElement(FIRST_NAME).sendKeys(first_name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(LAST_NAME));
        driver.findElement(LAST_NAME).sendKeys(last_name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(POSTAL_CODE));
        driver.findElement(POSTAL_CODE).sendKeys(zip);
        driver.findElement(CONTINUE_BUTTON).click();
        return new ProductsPage(driver);
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }
}
