package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "nav-link-accountList")
    private WebElement signInButton;

    @FindBy(id = "ap_email")
    private WebElement emailField;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(id = "ap_password")
    private WebElement passwordField;

    @FindBy(id = "signInSubmit")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        click(signInButton);

        sendKeys(emailField, username);

        click(continueButton);

        sendKeys(passwordField, password);
        click(submitButton);
    }
} 