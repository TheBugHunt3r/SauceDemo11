package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By CHECKOUT = By.id("checkout");
    private final By CONTINUE_SHOPPING_BUTTON = By.id("continue-shopping");
    private final By TITLE = By.className("title");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage open() {
        driver.get(BASE_URL + "cart.html");
        return this;
    }

    public CheckoutPage checkout() {
        driver.findElement(CHECKOUT).click();
        return new CheckoutPage(driver);
    }

    public CartPage remove(String itemId) {
        driver.findElement(By.id("remove-" + itemId));
        return this;
    }

    public ProductsPage continueShopping() {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
        return new ProductsPage(driver);
    }

    public CartPage getTitle() {
        driver.findElement(TITLE).getText();
        return this;
    }

    public boolean isItemDisplayed(String itemId) {
        try {
            return driver.findElement(By.id(itemId)).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
