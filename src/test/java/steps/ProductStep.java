package steps;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.CartPage;
import pages.ProductsPage;

import static org.testng.Assert.assertEquals;

public class ProductStep {

    private static final Logger log  = LoggerFactory.getLogger(ProductStep.class);
    WebDriver driver;
    ProductsPage productsPage;
    CartPage cartPage;

    public ProductStep(WebDriver driver) {
        this.driver = driver;
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
    }

    public void sorting(String filterOption, String expectedFirstItem) {
        log.info("Проверка сортировки товаров");
        productsPage.sortingFilters(filterOption);
        String actualFirstItem = productsPage.getFirstProductTitle();
        assertEquals(actualFirstItem, expectedFirstItem,
                "Первый товар после сортировки '" + filterOption +  "' не совпадает");
    }

    public void checkContinue() {
        log.info("Проверка возвращения на страницу товаров");
        productsPage.addToCart("Sauce Labs Backpack");
        cartPage.open().continueShopping();
        assertEquals(productsPage.getTitle(),
                "Products",
                "Возвращение на страницу товаров не выполнено");
    }
}
