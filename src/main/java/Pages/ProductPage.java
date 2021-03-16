package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ProductPage extends BasePage {

    By addToCartButton = By.cssSelector("button[name='add-to-cart']");
    By message = By.cssSelector(".woocommerce-message");
    By quantityField = By.cssSelector("input[type='number']");
    By statusCart = By.cssSelector("span[class*='woocommerce-Price-amount amount']+span.count");

    public ProductPage(WebDriver driver){
        super(driver);
    }

    public ProductPage goToProductUrl(String url){
        driver.navigate().to(url);
        return new ProductPage(driver);
    }

    public void addToCart(){
        driver.findElement(addToCartButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(message));
    }

    public String getMessageAfterAdd(){
        return driver.findElement(message).getText();
    }

    public ProductPage addSameProduct(String quantity){
        WebElement quantityField  = driver.findElement(this.quantityField);
        quantityField.clear();
        quantityField.sendKeys(quantity);
        return new ProductPage(driver);
    }


    public String getStatusCart(){
        String status = driver.findElement(statusCart).getText();
        return status;
    }


}


