package com.pages;

import com.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private By userNameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage= By.cssSelector("[data-test='error']");
    private By mainPageTitle= By.cssSelector("[data-test='title']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage loginToWebsite(String username,String password){
        writeText(userNameField,username);
        writeText(passwordField,password);
        click(loginButton);
        return this;
    }

    public String getErrorMessage(){
    return readText(errorMessage);

    }

    public String getMainPageTitle(){
        return readText(mainPageTitle);
    }
}
