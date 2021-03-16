package POMTests;

import Utils.TestDataReader;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    protected TestDataReader testData;

    @Before
    public void getTestData() {
        testData = new TestDataReader();
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        driver.navigate().to("https://fakestore.testelka.pl");

        driver.findElement(By.cssSelector("a.woocommerce-store-notice__dismiss-link")).click();

    }


    @After
    public void tearDown() {
        driver.close();
    }
}
