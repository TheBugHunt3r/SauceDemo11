package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import plugins.allure.AllureUtils;


public class LoginPage extends BasePage {

    private static final Logger log  = LoggerFactory.getLogger(LoginPage.class);

    @FindBy(id = "user-name")
    private WebElement USERNAME_INPUT;
    @FindBy(id = "password")
    private WebElement PASSWORD;
    @FindBy(id = "login-button")
    private WebElement LOGIN_BUTTON;
    @FindBy(css = "[data-test=error]")
    private WebElement ERROR_MESSAGE;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPage open() {
        driver.get(BASE_URL);
        wait.until(ExpectedConditions.visibilityOf(LOGIN_BUTTON));
        log.info("Открытие страницы");
        return this;
    }

    @Step("Вход в магазин с именем '{user}' и паролем '{password}'")
    public ProductsPage login(String user, String password) {
        log.debug("Ввод usernsme: {}", user);
        wait.until(ExpectedConditions.visibilityOf(USERNAME_INPUT));
        USERNAME_INPUT.sendKeys(user);
        wait.until(ExpectedConditions.visibilityOf(PASSWORD));
        log.debug("Ввод password: {}", password);
        PASSWORD.sendKeys(password);
        log.info("Нажатие кнопки Login");
        LOGIN_BUTTON.click();
        AllureUtils.takeScreenshot(driver);
        return new ProductsPage(driver);
    }

    public String getErrorMessage() {
        String error = ERROR_MESSAGE.getText();
        log.warn("Поученос сообщение об ошибке {}", ERROR_MESSAGE);
        return error;
    }
}
