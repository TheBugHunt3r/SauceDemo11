package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import plugins.retry.RetryAnalyzer;

public class CheckoutTest extends BaseTest {


    @Owner("Alisa")
    @Link("https://www.saucedemo.com/")
    @Description("Тест перехода на страницу оплаты")
    @Epic("SauceDemo checkout")
    @Feature("checkout")
    @Story("Test of checkout")
    @Severity(SeverityLevel.CRITICAL)
    @Lead("Timofei")
    @TmsLink("SD-04")
    @Issue("SD_04/1")
    @Test(testName = "Позитивный тест страницы оплаты", description = "Проверка перехода на страницу оплаты",
            retryAnalyzer = RetryAnalyzer.class)
    public void checkCheckoutPageIsOpened() {
        loginStep.auth("standard_user", "secret_sauce");
        checkoutStep.isOpened();
    }


    @Owner("Alisa")
    @Link("https://www.saucedemo.com/")
    @Description("Позитивный тест оплаты")
    @Epic("SauceDemo checkout test")
    @Feature("checkout test")
    @Story("Test of checkout")
    @Severity(SeverityLevel.CRITICAL)
    @Lead("Timofei")
    @TmsLink("SD-04")
    @Issue("SD_04/2")
    @Test(testName = "Позитивный тест оплаты", description = "Проверка оплаты пользователем",
            retryAnalyzer = RetryAnalyzer.class)
    public void checkPositiveCheckout() {
        loginStep.auth("standard_user", "secret_sauce");
        checkoutStep.checkPositiveCheckout();
    }
}
