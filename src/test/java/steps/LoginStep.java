package steps;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.LoginPage;
import pages.ProductsPage;

import static org.testng.Assert.assertEquals;

public class LoginStep {

    private static final Logger log  = LoggerFactory.getLogger(LoginStep.class);

    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;

    public LoginStep(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    public void auth(String username, String password) {
        log.info("Авторизация");
        loginPage.open().login(username, password);
    }

    public void testWithPositiveCred() {
        log.info("Тест с позитивными данными");
        assertEquals(productsPage.getTitle(),
                "Products",
                "Логин не выполнен");
    }

    public void testWithEmptyPassword() {
        log.info("Тест с пустым паролем");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "Сообщение об ошибке не соответствует");
    }

    public void testWithEmptyUsername() {
        log.info("Тест с пустым юзернеймом");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "Сообщение об ошибке не соответствует");
    }
    public void testWithTestCred() {
        log.info("Тест с тестовыми данными");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Сообщение об ошибке не соответствует");
    }
}
