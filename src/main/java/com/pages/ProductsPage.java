package com.pages;

import com.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.PrimitiveIterator;

public class ProductsPage extends BasePage {
    private By addtoCartButton = By.cssSelector("[data-test='add-to-cart-sauce-labs-bolt-t-shirt']");
    private By productNamesField = By.cssSelector("[data-test='inventory-item-name']");
    private By cartItemCountField= By.cssSelector("[data-test='shopping-cart-badge']");


    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCartButton(){
        click(addtoCartButton);
    }

    public void selectProductByIndex(int index){
        List<WebElement> productList=driver.findElements(productNamesField);
        productList.get(index).click();
    }

    public String getCartCount(){
        return readText(cartItemCountField);
    }


}
