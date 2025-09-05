package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CartPage extends BasePage {

    private static final Logger log  = LoggerFactory.getLogger(CartPage.class);

    @FindBy(id = "checkout")
    public WebElement CHECKOUT;
    @FindBy(id = "continue-shopping")
    public WebElement CONTINUE_SHOPPING_BUTTON;
    @FindBy(className = "title")
    public WebElement TITLE;

    public CartPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        PageFactory.initElements(driver, this);
    }

    public CartPage open() {
        log.info("Открытие страницы корзины");
        driver.get(BASE_URL + "cart.html");
        return this;
    }

    public CheckoutPage checkout() {
        initElements();
        log.info("Нажатие на кнопку оплаты");
        WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(CHECKOUT));
        checkoutButton.click();
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

    public String getTitle() {
        return TITLE.getText();
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
