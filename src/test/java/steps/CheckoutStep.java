package steps;

import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.CheckoutPage;
import pages.ProductsPage;

import static org.testng.Assert.assertEquals;

public class CheckoutStep {

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
        productsPage.addToCart("Sauce Labs Backpack");
        cartPage.open()
                .checkout();
        assertEquals(checkoutPage.getTitle(),
                "Checkout: Your Information",
                "Открытие чекаута не выполнено");
    }

    public void checkPositiveCheckout() {
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
