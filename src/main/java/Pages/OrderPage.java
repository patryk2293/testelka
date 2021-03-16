package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage extends BasePage {

    public OrderPage(WebDriver driver) {
        super(driver);
    }

    By titleNewOrder = By.cssSelector("h1[class='entry-title']");

    public String getMessageConfirmation() {
        return driver.findElement(titleNewOrder).getText();
    }
}
