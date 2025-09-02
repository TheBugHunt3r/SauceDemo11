package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CartPage extends BasePage {

    private static final Logger log  = LoggerFactory.getLogger(CartPage.class);

    @FindBy(id = "checkout")
    private WebElement CHECKOUT;
    @FindBy(id = "continue-shopping")
    private WebElement CONTINUE_SHOPPING_BUTTON;
    @FindBy(className = "title")
    private WebElement TITLE;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage open() {
        log.info("Открытие страницы корзины");
        driver.get(BASE_URL + "cart.html");
        return this;
    }

    public CheckoutPage checkout() {
        log.info("Нажатие на кнопку оплаты");
        CHECKOUT.click();
        return new CheckoutPage(driver);
    }

    public CartPage remove(String itemId) {
        log.info("Удаление товара из корзины");
        driver.findElement(By.id("remove-" + itemId));
        return this;
    }

    public ProductsPage continueShopping() {
        log.info("Нажатие на кнопку 'Продолжить покупки'");
        CONTINUE_SHOPPING_BUTTON.click();
        return new ProductsPage(driver);
    }

    public CartPage getTitle() {
        TITLE.getText();
        return this;
    }

    public boolean isItemDisplayed(String itemId) {
        log.info("Проверка изображения товара");
        try {
            return driver.findElement(By.id(itemId)).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
