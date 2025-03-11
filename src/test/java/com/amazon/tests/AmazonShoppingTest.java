package com.amazon.tests;

import com.amazon.pages.LoginPage;
import com.amazon.pages.ProductSearchPage;
import org.testng.annotations.Test;

public class AmazonShoppingTest extends BaseTest {

    @Test
    public void testAmazonShopping() {
        /* 
        // Login to Amazon
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(props.getProperty("username"), props.getProperty("password"));
*/
        // Navigate to Video Games and apply filters
        ProductSearchPage productPage = new ProductSearchPage(driver);
        productPage.navigateToVideoGames();
        productPage.applyFilters();
        productPage.sortByPriceHighToLow();

        // Add products below maximum price
        double maxPrice = Double.parseDouble(props.getProperty("maxPrice"));
        productPage.addProductsBelowPrice(maxPrice);
    }
} 