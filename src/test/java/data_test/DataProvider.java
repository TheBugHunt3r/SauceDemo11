package data_test;

public class DataProvider{
    @org.testng.annotations.DataProvider(name = "filters")
    public Object[][] sortingFilters() {
        return new Object[][] {
                {"Name (A to Z)",      "Sauce Labs Backpack"},
                {"Name (Z to A)",      "Test.allTheThings() T-Shirt (Red)"},
                {"Price (low to high)", "Sauce Labs Onesie"},
                {"Price (high to low)", "Sauce Labs Fleece Jacket"}
        };
    }

}
