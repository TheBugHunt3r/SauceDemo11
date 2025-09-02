package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import plugins.allure.AllureUtils;

import java.util.List;
import java.util.NoSuchElementException;

public class ProductsPage extends BasePage {

    private static final Logger logger  = LoggerFactory.getLogger(ProductsPage.class);

    @FindBy(className = "title")
    private WebElement TITLE;
    @FindBy(xpath = "//*[text()='%s']/ancestor::div[@class='inventory_item']" +
            "//button[text()='Add to cart']")
    private WebElement ADD_TO_CART_PATTERN;

    public ProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Открытие страницы продуктов")
    public ProductsPage open() {
        driver.get(BASE_URL + "inventory.html");
        logger.info("Открытие страницы продуктов");
        AllureUtils.takeScreenshot(driver);
        return this;
    }


    @Step("Проверка открытия страницы продуктов")
    public ProductsPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Products']")));
        logger.info("Проверка открытия страницы продуктов");
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Нажатие кнопки сортировки")
    public ProductsPage sortingFilters(String filterOption) {
        By filterDropdownLocator = By.className("product_sort_container");
        Select filterDropdown = new Select(driver.findElement(filterDropdownLocator));
        filterDropdown.selectByVisibleText(filterOption);
        logger.info("Нажатие кнопки сортировки");
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Проверка первого товара после сортировки")
    public String getFirstProductTitle() {
        By productNameLocator = By.className("inventory_item_name");
        List<WebElement> productNames = driver.findElements(productNameLocator);
        if (productNames.isEmpty()) {
            throw new NoSuchElementException("No products found on the page");
        }
        logger.info("Проверка первого товара после сортировки");
        AllureUtils.takeScreenshot(driver);
        return productNames.get(0).getText();

    }

    public String getTitle() {
        return TITLE.getText();
    }

    @Step("Добавление товара с именем: '{product}' в корзину и нажатие на кнопку")
    public ProductsPage addToCart(String product) {
        driver.findElement(By.xpath(String.format(product, ADD_TO_CART_PATTERN))).click();
        logger.info("Добавление товара в корзину и нажатие на кнопку");
        AllureUtils.takeScreenshot(driver);
        return this;
    }
}
