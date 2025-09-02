package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import plugins.allure.AllureUtils;

public class LoginPage extends BasePage {

    private final By USERNAME_INPUT = By.id("user-name");
    private final By PASSWORD = By.id("password");
    private final By LOGIN_BUTTON = By.id("login-button");
    private final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");
    LoginPage loginPage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open() {
        driver.get(BASE_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        return this;
    }

    @Step("Вход в магазин с именем '{user}' и паролем '{password}'")
    public ProductsPage login(String user, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_INPUT));
        driver.findElement(USERNAME_INPUT).sendKeys(user);
        wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD));
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        AllureUtils.takeScreenshot(driver);
        return new ProductsPage(driver);
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
