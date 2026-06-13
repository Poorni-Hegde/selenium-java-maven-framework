package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    By addToCartBtn = By.id("add-to-cart-sauce-labs-backpack");

    public void addProductToCart() {
        driver.findElement(addToCartBtn).click();
    }
}