package tests;

import data_test.DataProvider;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import plugins.retry.RetryAnalyzer;

public class ProductTest extends BaseTest {

    @Owner("Alisa")
    @Link("https://www.saucedemo.com/")
    @Description("Провекрка входа на страницу товаров")
    @Epic("SauceDemo Log in")
    @Feature("Open product page test")
    @Story("Open product page test")
    @Severity(SeverityLevel.CRITICAL)
    @Lead("Timofei")
    @TmsLink("SD-03")
    @Issue("SD_03/1")
    @Test(testName = "Вход на страницу товаров", description = "Провекрка входа на страницу товаров",
            retryAnalyzer = RetryAnalyzer.class)
    public void checkProductPage() {
        loginStep.auth("standard_user", "secret_sauce");
        productsPage.open()
                .isPageOpened();
    }

    @Test(testName = "Проверка фильтрации продуктов", dataProvider = "filters", dataProviderClass = DataProvider.class,
            retryAnalyzer = RetryAnalyzer.class, description = "Проверка фильтрации продуктов")
    @Owner("Alisa")
    @Link("https://www.saucedemo.com/")
    @Description("Проверка фильтрации продуктов")
    @Epic("SauceDemo Sorting")
    @Feature("Sorting")
    @Story("Sorting with positive cred")
    @Severity(SeverityLevel.CRITICAL)
    @Lead("Timofei")
    @TmsLink("SD-03")
    @Issue("SD_03/2")

    public void checkSorting(String filterOption, String expectedFirstItem) {
        loginStep.auth("standard_user", "secret_sauce");
        productStep.sorting(filterOption, expectedFirstItem);
    }
}

