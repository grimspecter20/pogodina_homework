import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PaymentPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By paymentTitle = By.xpath("//section[@class='pay']//h2");
    private final By paymentLogos = By.xpath("//section[@class='pay']//ul/li/img");
    private final By detailsLink = By.xpath("//section[@class='pay']//a");
    private final By continueButton = By.xpath("//section[@class='pay']//form[1]//button");
    private final By paymentWindow = By.cssSelector("div.payment-widget-app");
    private final By cookieAgreeButton = By.id("cookie-agree");

    private final By connectionPhoneField = By.id("connection-phone");
    private final By connectionAmountField = By.id("connection-sum");
    private final By connectionEmailField = By.id("connection-email");

    private final By internetPhoneField = By.id("internet-phone");
    private final By internetAmountField = By.id("internet-sum");
    private final By internetEmailField = By.id("internet-email");

    private final By installmentAccountField = By.id("score-instalment");
    private final By installmentAmountField = By.id("instalment-sum");
    private final By installmentEmailField = By.id("instalment-email");

    private final By arrearsAccountField = By.id("score-arrears");
    private final By arrearsAmountField = By.id("arrears-sum");
    private final By arrearsEmailField = By.id("arrears-email");

    private final By serviceTypeButton = By.xpath("//button[@class='select__header']");
    private final By serviceTypeOption = By.xpath("//p[@class='select__option']");

    private final By paymentAmount = By.xpath("//div[@class='pay-description__cost']/span");
    private final By paymentDetails = By.xpath("//div[@class='pay-description__text']/span");

    private final By cardNumberFieldLabel = By.xpath("//input[@id='cc-number']/following-sibling::label");
    private final By cardExpirationFieldLabel = By.xpath("//input[@formcontrolname='expirationDate']/following-sibling::label");
    private final By cardCvcFieldLabel = By.xpath("//input[@formcontrolname='cvc']/following-sibling::label");
    private final By cardHolderFieldLabel = By.xpath("//input[@formcontrolname='holder']/following-sibling::label");

    private final By payButton = By.xpath("//app-card-page//button[@type='submit']");

    private final By paymentSystemIcons = By.xpath("//div[contains(@class, 'cards-brands__container')]//img");

    private final By paymentFrame = By.xpath("//iframe[@class='payment-widget-iframe']");
    private final By paymentFrameContainer = By.cssSelector("div.app-wrapper__content");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Открыть сайт МТС и принять cookies")
    public void open() {
        //driver.get("https://www.mts.by/");
        //driver.findElement(cookieAgreeButton).click();
        driver.get("https://www.mts.by/");
        wait.until(ExpectedConditions.elementToBeClickable(cookieAgreeButton)).click();
    }

    @Step("Получить заголовок блока онлайн-пополнения")
    public String getPaymentTitle() {
        return driver.findElement(paymentTitle).getText();
    }

    @Step("Проверить отображение логотипов платёжных систем")
    public boolean arePaymentLogosDisplayed() {
        List<WebElement> logos = driver.findElements(paymentLogos);
        if (logos.isEmpty()) {
            return false;
        }
        for (WebElement logo : logos) {
            if (!logo.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    @Step("Получить количество логотипов платёжных систем")
    public int getPaymentLogosCount() {
        return driver.findElements(paymentLogos).size();
    }

    @Step("Перейти по ссылке 'Подробнее о сервисе'")
    public void clickDetailsLink() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(detailsLink)).click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Step("Заполнить форму оплаты услуг связи")
    public void fillPaymentForm(String phone, String amount) {
        driver.findElement(connectionPhoneField).sendKeys(phone);
        driver.findElement(connectionAmountField).sendKeys(amount);
    }

    @Step("Нажать кнопку 'Продолжить'")
    public void clickContinue() {
        driver.findElement(continueButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentWindow));
    }

    @Step("Проверить отображение окна оплаты")
    public boolean isPaymentWindowDisplayed() {
        return driver.findElement(paymentWindow).isDisplayed();
    }

    @Step("Получить текст плейсхолдера соответствующего поля")
    public String getConnectionPhonePlaceholder() {
        return getPlaceholder(driver.findElement(connectionPhoneField));
    }

    public String getConnectionAmountPlaceholder() {
        return getPlaceholder(driver.findElement(connectionAmountField));
    }

    public String getConnectionEmailPlaceholder() {
        return getPlaceholder(driver.findElement(connectionEmailField));
    }

    public String getInternetPhonePlaceholder() {
        return getPlaceholder(driver.findElement(internetPhoneField));
    }

    public String getInternetAmountPlaceholder() {
        return getPlaceholder(driver.findElement(internetAmountField));
    }

    public String getInternetEmailPlaceholder() {
        return getPlaceholder(driver.findElement(internetEmailField));
    }

    public String getInstallmentAccountPlaceholder() {
        return getPlaceholder(driver.findElement(installmentAccountField));
    }

    public String getInstallmentAmountPlaceholder() {
        return getPlaceholder(driver.findElement(installmentAmountField));
    }

    public String getInstallmentEmailPlaceholder() {
        return getPlaceholder(driver.findElement(installmentEmailField));
    }

    public String getArrearsAccountPlaceholder() {
        return getPlaceholder(driver.findElement(arrearsAccountField));
    }

    public String getArrearsAmountPlaceholder() {
        return getPlaceholder(driver.findElement(arrearsAmountField));
    }

    public String getArrearsEmailPlaceholder() {
        return getPlaceholder(driver.findElement(arrearsEmailField));
    }

    @Step("Открыть список типов услуг")
    public void clickServiceTypeButton() {
        driver.findElement(serviceTypeButton).click();
    }

    @Step("Выбрать тип услуги")
    public void selectServiceType(String serviceType) {
        List<WebElement> options = driver.findElements(serviceTypeOption);
        for (WebElement option : options) {
            if (option.getText().equals(serviceType)) {
                option.click();
                break;
            }
        }
    }

    private String getPlaceholder(WebElement element) {
        return element.getAttribute("placeholder");
    }

    public String getPaymentAmount() {
        return driver.findElement(paymentAmount).getText();
    }

    public String getPaymentDetails() {
        return driver.findElement(paymentDetails).getText();
    }

    public String getPaymentButtonText() {
        return driver.findElement(payButton).getText().trim();
    }

    public String getCardNumberFieldLabel() {
        return driver.findElement(cardNumberFieldLabel).getText();
    }

    public String getCardExpirationFieldLabel() {
        return driver.findElement(cardExpirationFieldLabel).getText();
    }

    public String getCardCvcFieldLabel() {
        return driver.findElement(cardCvcFieldLabel).getText();
    }

    public String getCardHolderFieldLabel() {
        return driver.findElement(cardHolderFieldLabel).getText();
    }

    public List<WebElement> getPaymentSystemIcons() {
        return driver.findElements(paymentSystemIcons);
    }

    @Step("Переключиться на окно оплаты и дождаться его загрузки")
    public void waitOfVisibilityFrame() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentFrame));
        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentFrameContainer));
    }
}
