import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestClass {
    WebDriver driver;

    @BeforeAll
    static void setupClass() {
        System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");

    }

    @BeforeEach
    void setupTest() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\chrome-win64\\chrome.exe");
        driver = new ChromeDriver(options);
        driver.get("https://www.mts.by/");
        driver.findElement(By.id("cookie-agree")).click();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    public void shouldDisplayOnlinePaymentBlockTitle() {
        WebElement title = driver.findElement(By.xpath("//section[@class='pay']//h2"));
        assertEquals(
                "ОНЛАЙН ПОПОЛНЕНИЕ\n" +
                        "БЕЗ КОМИССИИ",
                title.getText()
        );
    }

    @Test
    public void shouldDisplayPaymentSystemLogos() {
        List<WebElement> paymentSystems = driver.findElements(
                By.xpath("//section[@class='pay']//ul/li/img")
        );
        for (WebElement element : paymentSystems) {
            assertTrue(element.isDisplayed());
        }
        assertEquals(5, paymentSystems.size());
    }

    @Test
    public void shouldOpenServiceDetailsPageByLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@class='pay']//a")));
        assertTrue(link.isDisplayed());
        link.click();
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl());
    }

    @Test
    public void shouldSubmitCommunicationServicePayment() {
        WebElement fieldNumberPhone = driver.findElement(By.id("connection-phone"));
        fieldNumberPhone.click();
        fieldNumberPhone.sendKeys("297777777");
        WebElement fieldAmount = driver.findElement(By.id("connection-sum"));
        fieldAmount.click();
        fieldAmount.sendKeys("10");
        WebElement continueButton = driver.findElement(By.xpath("//section[@class='pay']//form[1]//button"));
        continueButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement paymentWindow = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.payment-widget-app"))
        );
        assertTrue(paymentWindow.isDisplayed());
    }
}
