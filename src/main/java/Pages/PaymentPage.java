package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PaymentPage extends BasePage {

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    By cardNumberField = By.cssSelector("div>span>input[name='cardnumber']");
    By loader = By.cssSelector("div[class='blockUI blockOverlay'");
    By buyAndPayButton = By.cssSelector("#place_order");
    By dateToExpire = By.cssSelector("input[name='exp-date']");
    By cvc = By.cssSelector("input[name='cvc']");
    By allErrorMessage = By.cssSelector("ul.woocommerce-error");
    By errorMessageCard = By.cssSelector("ul[class='woocommerce_error woocommerce-error wc-stripe-error']");
    By firstNameLocator = By.cssSelector("#billing_first_name");
    By lastNameLocator = By.cssSelector("#billing_last_name");
    By adressLocator = By.cssSelector("#billing_address_1");
    By postalCodeLocator = By.cssSelector("input[name='billing_postcode']");
    By cityLocator = By.cssSelector("#billing_city");
    By phoneLocator = By.cssSelector("#billing_phone");
    By emailLocator = By.cssSelector("#billing_email");
    By termsLocator = By.cssSelector("input[name='terms']");

    public PaymentPage goToPayment() {
        driver.navigate().to("https://fakestore.testelka.pl/zamowienie/");
        return this;
    }

    public PaymentPage typeCardNumber(String cardNumber) {
        switchToFrame(0);
        wait.until(ExpectedConditions.elementToBeClickable(cardNumberField)).sendKeys(cardNumber);
        driver.switchTo().defaultContent();
        return this;
    }

    public PaymentPage typeDateOfExpire(String dateOfExpire) {
        switchToFrame(1);
        wait.until(ExpectedConditions.elementToBeClickable(dateToExpire)).sendKeys(dateOfExpire);
        driver.switchTo().defaultContent();
        return this;
    }

    public PaymentPage typeCVC(String CVC) {
        switchToFrame(2);
        wait.until(ExpectedConditions.elementToBeClickable(cvc)).sendKeys(CVC);
        driver.switchTo().defaultContent();
        return this;
    }

    public PaymentPage payClick() {
        wait.until(ExpectedConditions.elementToBeClickable(buyAndPayButton));
        driver.findElement(buyAndPayButton).click();
        return this;
    }

    public void switchToFrame(int indexOfFrame) {
        driver.switchTo().frame(indexOfFrame);
    }

    public String getErrorMessageCard() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageCard));
        return driver.findElement(errorMessageCard).getText();
    }

    public PaymentPage waitUntilLoaderDisappear() {
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(loader)));
        return this;
    }

    public String getErrorMessagesFromPay() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(allErrorMessage)).getText();
    }

    public PaymentPage typePhoneAndEmail(String emailNew, String phoneNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(phoneLocator)).sendKeys(phoneNumber);
        wait.until(ExpectedConditions.elementToBeClickable(emailLocator)).sendKeys(emailNew);
        clickOnTerms();
        return this;
    }

    public PaymentPage typeFirstName(String firstName) {
        wait.until(ExpectedConditions.elementToBeClickable(firstNameLocator)).sendKeys(firstName);
        return this;
    }

    public PaymentPage typeLastName(String lastName) {
        wait.until(ExpectedConditions.elementToBeClickable(lastNameLocator)).sendKeys(lastName);
        return this;
    }


    public PaymentPage typeAdress(String adress) {
        wait.until(ExpectedConditions.elementToBeClickable(adressLocator)).sendKeys(adress);
        return this;
    }

    public PaymentPage typePostalCode(String postalCode) {
        wait.until(ExpectedConditions.elementToBeClickable(postalCodeLocator)).sendKeys(postalCode);
        return this;
    }

    public PaymentPage typeCity(String city) {
        wait.until(ExpectedConditions.elementToBeClickable(cityLocator)).sendKeys(city);
        return this;
    }


    public void clickOnTerms() {
        wait.until(ExpectedConditions.elementToBeClickable(termsLocator)).click();
    }


}
