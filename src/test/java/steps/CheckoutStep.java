package steps;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.CartPage;
import pages.CheckoutPage;
import pages.ProductsPage;

import static org.testng.Assert.assertEquals;

public class CheckoutStep {

    private static final Logger log  = LoggerFactory.getLogger(CheckoutStep.class);
    WebDriver driver;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    public CheckoutStep(WebDriver driver) {

        this.driver = driver;
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    public void isOpened() {
        log.info("Открытие страницы чекаута");
        productsPage.addToCart("Sauce Labs Backpack");
        cartPage.open()
                .checkout();
        assertEquals(checkoutPage.getTitle(),
                "Checkout: Your Information",
                "Открытие чекаута не выполнено");
    }

    public void checkPositiveCheckout() {
        log.info("Проверка успешной оплаты");
        productsPage.addToCart("Sauce Labs Backpack");
        cartPage.open()
                .checkout();
        checkoutPage.open()
                .enterInfo("First", "Last", "123456");
        assertEquals(checkoutPage.getTitle(),
                "Checkout: Overview",
                "Чекаут не выполнен");
    }
}
