package com.pages;

import com.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage {
    By addToCartButton=By.cssSelector("[data-test='add-to-cart']");
    By cartItemCountField= By.cssSelector("[data-test='shopping-cart-badge']");


    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void addItemstoCart(){
        click(addToCartButton);
    }

    public String getItemCountOnCart(){
        return readText(cartItemCountField);
    }
}
