package POMTests;

import Pages.OrderPage;
import Pages.PaymentPage;
import Pages.ProductPage;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.testng.Assert.assertTrue;

public class PaymentTests extends BaseTest {

    @Test
    @Ignore
    public void EmptyCardNumberFieldMessage() {
        ProductPage productPage = new ProductPage(driver);
        PaymentPage paymentPage = new PaymentPage(driver);
        productPage.goToProductUrl("https://fakestore.testelka.pl/product/egipt-el-gouna/")
                .addToCart();
        paymentPage.goToPayment()
                .waitUntilLoaderDisappear()
                .typeCardNumber("")
                .payClick()
                .waitUntilLoaderDisappear();
        String errorMessage = paymentPage.getErrorMessageCard();

        Assert.assertEquals("Message is not the same", "Numer karty jest niekompletny.", errorMessage);
    }

    @Test
    @Ignore
    public void EmptyDateOFExpireFieldMessage() {
        ProductPage productPage = new ProductPage(driver);
        PaymentPage paymentPage = new PaymentPage(driver);
        productPage.goToProductUrl("https://fakestore.testelka.pl/product/egipt-el-gouna/")
                .addToCart();
        paymentPage.goToPayment()
                .waitUntilLoaderDisappear()
                .typeCardNumber(testData.getCard().getCardNumber())
                .typeDateOfExpire("")
                .payClick()
                .waitUntilLoaderDisappear();
        String errorMessage = paymentPage.getErrorMessageCard();

        Assert.assertEquals("Message is not the same", "Data ważności karty jest niekompletna.", errorMessage);
    }

    @Test
    @Ignore
    public void llIncorectMessagesWithoutCardMessages() {
        ProductPage productPage = new ProductPage(driver);
        PaymentPage paymentPage = new PaymentPage(driver);
        productPage.goToProductUrl("https://fakestore.testelka.pl/product/egipt-el-gouna/")
                .addToCart();

        paymentPage.goToPayment()
                .waitUntilLoaderDisappear()
                .typeCardNumber(testData.getCard().getCardNumber())
                .typeDateOfExpire(testData.getCard().getDateOfExpire())
                .typeCVC(testData.getCard().getCVCNumber())
                .payClick()
                .waitUntilLoaderDisappear();

        String errorMessages = paymentPage.getErrorMessagesFromPay();

        assertAll(
                () -> assertTrue(errorMessages.contains("Imię płatnika jest wymaganym polem."),
                        "Error message doesn't contain lack of first name error."),
                () -> assertTrue(errorMessages.contains("Nazwisko płatnika jest wymaganym polem."),
                        "Error message doesn't contain lack of last name error."),
                () -> assertTrue(errorMessages.contains("Ulica płatnika jest wymaganym polem."),
                        "Error message doesn't contain lack of street name error."),
                () -> assertTrue(errorMessages.contains("Miasto płatnika jest wymaganym polem."),
                        "Error message doesn't contain lack of city name error."),
                () -> assertTrue(errorMessages.contains("Telefon płatnika jest wymaganym polem."),
                        "Error message doesn't contain lack of phone number error."),
                () -> assertTrue(errorMessages.contains("Adres email płatnika jest wymaganym polem."),
                        "Error message doesn't contain lack of email address error."),
                () -> assertTrue(errorMessages.contains("Kod pocztowy płatnika nie jest prawidłowym kodem pocztowym."),
                        "Error message doesn't contain lack of postal code error."),
                () -> assertTrue(errorMessages.contains("Proszę przeczytać i zaakceptować regulamin sklepu aby móc sfinalizować zamówienie."),
                        "Error message doesn't contain lack of terms acceptance error.")
        );
    }

    @Test
    public void buyWithoutAccount() {
        ProductPage productPage = new ProductPage(driver);
        PaymentPage paymentPage = new PaymentPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        productPage.goToProductUrl("https://fakestore.testelka.pl/product/egipt-el-gouna/")
                .addToCart();

        paymentPage.goToPayment()
                .waitUntilLoaderDisappear()
                .typeCardNumber(testData.getCard().getCardNumber())
                .typeDateOfExpire(testData.getCard().getDateOfExpire())
                .typeCVC(testData.getCard().getCVCNumber())
                .typeFirstName(testData.getPerson().getFirstName())
                .typeLastName(testData.getPerson().getLastName())
                .typeAdress(testData.getContact().getAdress())
                .typePostalCode(testData.getContact().getPostalCode())
                .typeCity(testData.getContact().getCity())
                .typePhoneAndEmail(testData.getContact().getEmail(), testData.getContact().getPhone())
                .payClick()
                .waitUntilLoaderDisappear();

        String confirmationMessage = orderPage.getMessageConfirmation();

        Assert.assertEquals("Payment not finished", "Zamówienie otrzymane", confirmationMessage);
    }
}
