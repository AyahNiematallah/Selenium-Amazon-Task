package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class ProductSearchPage extends BasePage {
    @FindBy(id = "nav-hamburger-menu")
    private WebElement allMenu;

    @FindBy(xpath = "//div[contains(text(),'Video Games')]")
    private WebElement videoGamesCategory;

    @FindBy(xpath = "//a[contains(text(),'All Video Games')]")
    private WebElement allVideoGames;

    @FindBy(xpath = "//span[contains(text(),'Free Shipping')]")
    private WebElement freeShippingFilter;

    @FindBy(xpath = "//span[contains(text(),'New')]")
    private WebElement newConditionFilter;

    @FindBy(id = "s-result-sort-select")
    private WebElement sortDropdown;

    @FindBy(xpath = "//a[contains(text(),'Price: High to Low')]")
    private WebElement priceHighToLow;

    @FindBy(css = ".s-result-item")
    private List<WebElement> productList;

    @FindBy(css = ".a-price-whole")
    private List<WebElement> productPrices;

    @FindBy(id = "add-to-cart-button")
    private WebElement addToCartButton;

    @FindBy(css = "span.icp-nav-link-inner")
    private WebElement languageSelector;
    
    @FindBy(xpath = "//a[span[contains(text(), 'English')]]")
    private WebElement englishLanguageOption;
    
    @FindBy(xpath = "//*[@id='icp-save-button']//input[@type='submit']")
    private WebElement saveChangesButton;

    @FindBy(xpath = "//a[contains(@class,'hmenu-item hmenu-compressed-btn')]")
    private WebElement expandAll;

    @FindBy(xpath = "//a[div[text()='Video Games']]")
    private WebElement videoGamesLink;

    @FindBy(xpath = "//a[div[text()='All Video Games']]")
    private WebElement allvideoGamesLink;

    public ProductSearchPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToVideoGames() {
        // Switch to English first
        hover(languageSelector);
        click(englishLanguageOption);

        // Now navigate to video games
        click(allMenu);
        click(expandAll);
        click(videoGamesLink);
        click(allvideoGamesLink);
    }

    public void applyFilters() {
        click(freeShippingFilter);
        click(newConditionFilter);
    }

    public void sortByPriceHighToLow() {
        click(sortDropdown);
        click(priceHighToLow);
    }

    public void addProductsBelowPrice(double maxPrice) {
        for (int i = 0; i < productList.size(); i++) {
            double price = Double.parseDouble(productPrices.get(i).getText().replace(",", ""));
            if (price < maxPrice) {
                productList.get(i).click();
                click(addToCartButton);
                driver.navigate().back();
            }
        }
    }
} 