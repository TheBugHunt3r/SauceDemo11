package steps;

import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.ProductsPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class CartStep {

    WebDriver driver;
    ProductsPage productsPage;
    CartPage cartPage;

    public CartStep(WebDriver driver) {
        this.driver = driver;
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
    }

    public void isCartOpened() {
        productsPage.addToCart("Sauce Labs Backpack").addToCart("Sauce Labs Bolt T-Shirt");
        cartPage.open();
        assertEquals(cartPage.getTitle(),
                "Your Cart",
                "Открытие корзины не выполнено");
    }

    public void checkRemoveButton() {
        cartPage.remove("sauce-labs-bolt-t-shirt");
        assertFalse(cartPage.isItemDisplayed("sauce-labs-bolt-t-shirt"));
    }
}
