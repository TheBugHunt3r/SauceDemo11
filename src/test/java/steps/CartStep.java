package steps;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.CartPage;
import pages.CheckoutPage;
import pages.ProductsPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class CartStep {

    private static final Logger log  = LoggerFactory.getLogger(CartStep.class);
    WebDriver driver;
    ProductsPage productsPage;
    CartPage cartPage;

    public CartStep(WebDriver driver) {
        this.driver = driver;
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
    }

    public void isCartOpened() {
        log.info("Проверка открытия корзины");
        productsPage.addToCart("Sauce Labs Backpack").addToCart("Sauce Labs Bolt T-Shirt");
        cartPage.open();
        assertEquals(cartPage.getTitle(),
                "Your Cart",
                "Открытие корзины не выполнено");
    }

    public void checkRemoveButton() {
        log.info("Проверка удаления товара из корзины");
        cartPage.remove("sauce-labs-bolt-t-shirt");
        assertFalse(cartPage.isItemDisplayed("sauce-labs-bolt-t-shirt"));
    }
}
