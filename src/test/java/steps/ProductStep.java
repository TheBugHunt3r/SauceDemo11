package steps;

import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.ProductsPage;

import static org.testng.Assert.assertEquals;

public class ProductStep {

    WebDriver driver;
    ProductsPage productsPage;
    CartPage cartPage;

    public ProductStep(WebDriver driver) {
        this.driver = driver;
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
    }

    public void sorting(String filterOption, String expectedFirstItem) {
        productsPage.sortingFilters(filterOption);
        String actualFirstItem = productsPage.getFirstProductTitle();
        assertEquals(actualFirstItem, expectedFirstItem,
                "Первый товар после сортировки '" + filterOption +  "' не совпадает");
    }

    public void checkContinue() {
        productsPage.addToCart("Sauce Labs Backpack");
        cartPage.open().continueShopping();
        assertEquals(productsPage.getTitle(),
                "Products",
                "Возвращение на страницу товаров не выполнено");
    }
}
