package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends BasePage {

    By countOfProduct = By.cssSelector("tr[class='woocommerce-cart-form__cart-item cart_item'");
    By removeButton = By.cssSelector(".remove");
    By message = By.cssSelector(".woocommerce-message");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage goToCart() {
        driver.navigate().to("https://fakestore.testelka.pl/koszyk/");
        return new CartPage(driver);
    }

    public int countOfElementsInCart() {
        List<WebElement> elements;
        elements = driver.findElements(countOfProduct);
        return elements.size();
    }

    public void removeFromCart() {
        driver.findElement(removeButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(message));
    }

    public String getMessageInfo() {
        return driver.findElement(message).getText();
    }


}
