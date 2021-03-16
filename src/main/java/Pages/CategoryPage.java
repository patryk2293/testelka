package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class CategoryPage extends BasePage {

    By category = By.cssSelector("h2[class='woocommerce-loop-category__title']");
    By allProducts = By.cssSelector("a[class='button product_type_simple add_to_cart_button ajax_add_to_cart']");
    By showCartButton = By.cssSelector("a[class='added_to_cart wc-forward']");

    public CategoryPage(WebDriver driver) {
        super(driver);
    }


    public CategoryPage goToCategory() {
        driver.navigate().to("https://fakestore.testelka.pl/shop/");
        return new CategoryPage(driver);
    }

    public CategoryPage chooseCategory(String nameOfCategory) {
        List<WebElement> elements = new ArrayList<WebElement>();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(category));
        elements = driver.findElements(category);
        for (int i = 0; i <= elements.size(); i++) {
            if (elements.get(i).getText().contains(nameOfCategory) == true) {
                elements.get(i).click();
                break;
            }
        }
        return new CategoryPage(driver);
    }

    public CartPage addAllProducts() {
        List<WebElement> elements = new ArrayList<>();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(allProducts));
        elements = driver.findElements(allProducts);
        for (int i = 0; i < elements.size(); i++) {
            ;
            elements.get(i).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(showCartButton));
        }
        wait.until(ExpectedConditions.numberOfElementsToBe(showCartButton, elements.size()));
        return new CartPage(driver);
    }

}
