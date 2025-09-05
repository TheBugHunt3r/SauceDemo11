package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckoutPage extends BasePage {

    private static final Logger log  = LoggerFactory.getLogger(CheckoutPage.class);

    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement FIRST_NAME;
    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement LAST_NAME;
    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement POSTAL_CODE;
    @FindBy(xpath = "//*[@id='continue']")
    private WebElement CONTINUE_BUTTON;
    @FindBy(className = "title")
    private WebElement TITLE;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        PageFactory.initElements(driver, this);
    }

    public CheckoutPage open() {
        log.info("Открытие страницы оплаты");
        driver.get(BASE_URL + "checkout-step-one.html");
        return this;
    }

    public ProductsPage enterInfo(String first_name, String last_name, String zip) {
        initElements();
        log.info("Ввод данных оплаты");
        log.debug("Ввод firstname: {}", first_name);
        wait.until(ExpectedConditions.visibilityOf(FIRST_NAME));
        FIRST_NAME.sendKeys(first_name);
        log.debug("Ввод last name: {}", last_name);
        wait.until(ExpectedConditions.visibilityOf(LAST_NAME));
        LAST_NAME.sendKeys(last_name);
        log.debug("Ввод zip: {}", zip);
        wait.until(ExpectedConditions.visibilityOf(POSTAL_CODE));
        POSTAL_CODE.sendKeys(zip);
        log.info("Нажатие на кнопку продолжить");
        CONTINUE_BUTTON.click();
        return new ProductsPage(driver);
    }

    public String getTitle() {
        log.info("Получение названия страницы");
        return TITLE.getText();
    }
}
