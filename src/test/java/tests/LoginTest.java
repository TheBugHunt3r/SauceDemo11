package tests;

import io.qameta.allure.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import plugins.retry.RetryAnalyzer;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(LoginTest.class);

    @Owner("Alisa")
    @Link("https://www.saucedemo.com/")
    @Description("Проверка входа в аккаунт с валидными данными")
    @Epic("SauceDemo Log in")
    @Feature("Log in")
    @Story("Log in with positive cred")
    @Severity(SeverityLevel.CRITICAL)
    @Lead("Timofei")
    @TmsLink("SD-01")
    @Issue("SD_01/1")
    @Test(testName = "Позитивный тест логина", description = "Проверка входа в аккаунт с валидными данными",
            retryAnalyzer = RetryAnalyzer.class)
    public void checkPositiveLogin() {
        loginStep.auth(user,password);
        loginStep.testWithPositiveCred();
    }

    @Owner("Alisa")
    @Link("https://www.saucedemo.com/")
    @Description("Проверка входа пользователя с пустым паролем")
    @Epic("SauceDemo Log in")
    @Feature("Log in")
    @Story("Log in with negative cred")
    @Severity(SeverityLevel.CRITICAL)
    @Lead("Timofei")
    @TmsLink("SD-01")
    @Issue("SD_01/2")
    @Test(testName = "Негативный тест логина", description = "Проверка входа пользователя с пустым паролем",
            retryAnalyzer = RetryAnalyzer.class)
    public void checkLoginWithEmptyPassword() {
        loginStep.auth("standard_user","");
        loginStep.testWithEmptyPassword();
    }


    @Owner("Alisa")
    @Link("https://www.saucedemo.com/")
    @Description("Проверка входа пользователя с именем пользователя")
    @Epic("SauceDemo Log in")
    @Feature("Log in")
    @Story("Log in with negative cred")
    @Severity(SeverityLevel.CRITICAL)
    @Lead("Timofei")
    @TmsLink("SD-01")
    @Issue("SD_01/3")
    @Test(testName = "Негативный тест логина", description = "Проверка входа пользователя с именем пользователя",
            retryAnalyzer = RetryAnalyzer.class)
    public void checkLoginWithEmptyUsername() {
        loginStep.auth("","secret_sauce");
        loginStep.testWithEmptyUsername();
    }

    @Owner("Alisa")
    @Link("https://www.saucedemo.com/")
    @Description("Проверка входа пользователя с тестовыми данными")
    @Epic("SauceDemo Log in")
    @Feature("Log in")
    @Story("Log in with negative cred")
    @Severity(SeverityLevel.CRITICAL)
    @Lead("Timofei")
    @TmsLink("SD-01")
    @Issue("SD_01/4")
    @Test(testName = "Негативный тест логина", description = "Проверка входа пользователя с тестовыми данными",
            retryAnalyzer = RetryAnalyzer.class)
    public void checkLoginWithTestCred() {
        loginStep.auth("test","test");
        loginStep.testWithTestCred();
    }

    @DataProvider(name = "Проверка логина с негативными данными")
    public Object[][] loginData() {
        return new Object[][] {
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"test", "test", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(dataProvider = "Проверка логина с негативными данными")
    public void paramNegativeTest(String user, String password, String expectedErrorMessage) {
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(loginPage.getErrorMessage(),
                expectedErrorMessage,
                "Сообщение об ошибке не соответствует");
    }
}
