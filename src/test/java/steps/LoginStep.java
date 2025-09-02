package steps;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductsPage;

import static org.testng.Assert.assertEquals;

public class LoginStep {

    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;

    public LoginStep(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    public void auth(String username, String password) {
        loginPage.open().login(username, password);
    }

    public void testWithPositiveCred() {
        assertEquals(productsPage.getTitle(),
                "Products",
                "Логин не выполнен");
    }

    public void testWithEmptyPassword() {
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "Сообщение об ошибке не соответствует");
    }

    public void testWithEmptyUsername() {
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "Сообщение об ошибке не соответствует");
    }
    public void testWithTestCred() {
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Сообщение об ошибке не соответствует");
    }
}
