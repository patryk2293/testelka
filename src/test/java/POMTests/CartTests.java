package POMTests;

import Pages.CartPage;
import Pages.CategoryPage;
import Pages.ProductPage;
import org.junit.*;

public class CartTests extends BaseTest {

    @Test
    @Ignore
    public void addToCart() {
        ProductPage productPage = new ProductPage(driver);
        productPage.goToProductUrl("https://fakestore.testelka.pl/product/egipt-el-gouna/")
                .addToCart();
        String expectedMessage = productPage.getMessageAfterAdd();
        String statusCart = productPage.getStatusCart();

        Assert.assertEquals("Message does not appear", true, expectedMessage.contains("został dodany do koszyka"));
        Assert.assertEquals("Count is not equal", "1 Produkt", statusCart);
    }

    @Test
    public void addToCartandCheckStatusCart() {
        ProductPage productPage = new ProductPage(driver);
        productPage.goToProductUrl("https://fakestore.testelka.pl/product/egipt-el-gouna/")
                .addToCart();
        String statusCart = productPage.getStatusCart();

        Assert.assertEquals("Count is not equal", "1 Produkt", statusCart);
    }

    @Test
    @Ignore
    public void addSameProducts() {
        ProductPage productPage = new ProductPage(driver);
        productPage.goToProductUrl("https://fakestore.testelka.pl/product/egipt-el-gouna/")
                .addSameProduct("10")
                .addToCart();
        String expectedMessage = productPage.getMessageAfterAdd();

        Assert.assertEquals("Message does not appear", true, expectedMessage.contains("10 ×"));
    }

    @Test
    @Ignore
    public void addDifferentProduct() {
        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.goToCategory()
                .chooseCategory("Windsurfing")
                .addAllProducts();
        int actualCount = categoryPage
                .goToCategory()
                .chooseCategory("Yoga i pilates")
                .addAllProducts()
                .goToCart()
                .countOfElementsInCart();

        Assert.assertEquals("Count is not the same", 11, actualCount);
    }

    @Test
    @Ignore
    public void removeFromCart() {
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        productPage
                .goToProductUrl("https://fakestore.testelka.pl/product/egipt-el-gouna/")
                .addToCart();
        cartPage
                .goToCart()
                .removeFromCart();

        String actualMessage = cartPage.getMessageInfo();

        Assert.assertEquals("Message does not appear", true, actualMessage.contains("Usunięto"));
    }

}
