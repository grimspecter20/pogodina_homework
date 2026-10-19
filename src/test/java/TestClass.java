import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestClass {
    WebDriver driver;
    PaymentPage page;
    String phone = "297777777";
    double sum = 10;
    String expectedAmount = String.format(Locale.US, "%.2f BYN", sum);

    @BeforeAll
    static void setupClass() {
        System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
    }

    @BeforeEach
    void setupTest() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\chrome-win64\\chrome.exe");
        driver = new ChromeDriver(options);
        page = new PaymentPage(driver);
        page.open();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @DisplayName("Отображается корректный заголовок блока онлайн-пополнения")
    @Test
    public void shouldDisplayOnlinePaymentBlockTitle() {
        assertEquals("ОНЛАЙН ПОПОЛНЕНИЕ\n" + "БЕЗ КОМИССИИ", page.getPaymentTitle());
    }

    @DisplayName("Логотипы платёжных систем отображаются в ожидаемом количестве")
    @Test
    public void shouldDisplayPaymentSystemLogos() {
        assertTrue(page.arePaymentLogosDisplayed());
        assertEquals(5, page.getPaymentLogosCount());
    }

    @DisplayName("Ссылка 'Подробнее о сервисе' ведёт на страницу с информацией об оплате")
    @Test
    public void shouldOpenServiceDetailsPageByLink() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        try {
            page.clickDetailsLink();
        } catch (TimeoutException ex) {
            ((JavascriptExecutor) driver).executeScript("window.stop();");
        }
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", page.getCurrentUrl());
    }

    @DisplayName("Отображение окна оплаты после заполнения формы услуги связи")
    @Test
    public void shouldSubmitCommunicationServicePayment() {
        page.fillPaymentForm(phone, String.valueOf(sum));
        page.clickContinue();
        assertTrue(page.isPaymentWindowDisplayed());
    }

    @DisplayName("Отображаются корректные подсказки в полях формы оплаты услуг связи")
    @Test
    public void shouldDisplayCorrectPlaceholdersForConnection() {
        page.clickServiceTypeButton();
        page.selectServiceType("Услуги связи");
        assertEquals("Номер телефона", page.getConnectionPhonePlaceholder());
        assertEquals("Сумма", page.getConnectionAmountPlaceholder());
        assertEquals("E-mail для отправки чека", page.getConnectionEmailPlaceholder());
    }

    @DisplayName("Отображаются корректные подсказки в полях формы оплаты домашнего интернета")
    @Test
    public void shouldDisplayCorrectPlaceholdersForInternet() {
        page.clickServiceTypeButton();
        page.selectServiceType("Домашний интернет");
        assertEquals("Номер абонента", page.getInternetPhonePlaceholder());
        assertEquals("Сумма", page.getInternetAmountPlaceholder());
        assertEquals("E-mail для отправки чека", page.getInternetEmailPlaceholder());
    }

    @DisplayName("Отображаются корректные подсказки в полях формы оплаты рассрочки")
    @Test
    public void shouldDisplayCorrectPlaceholdersForInstallment() {
        page.clickServiceTypeButton();
        page.selectServiceType("Рассрочка");
        assertEquals("Номер счета на 44", page.getInstallmentAccountPlaceholder());
        assertEquals("Сумма", page.getInstallmentAmountPlaceholder());
        assertEquals("E-mail для отправки чека", page.getInstallmentEmailPlaceholder());
    }

    @DisplayName("Отображаются корректные подсказки в полях формы оплаты задолженности")
    @Test
    public void shouldDisplayCorrectPlaceholdersForArrears() {
        page.clickServiceTypeButton();
        page.selectServiceType("Задолженность");
        assertEquals("Номер счета на 2073", page.getArrearsAccountPlaceholder());
        assertEquals("Сумма", page.getArrearsAmountPlaceholder());
        assertEquals("E-mail для отправки чека", page.getArrearsEmailPlaceholder());
    }
@DisplayName("Отображаются корректные данные в окне оплаты услуг связи")
    @Test
    public void shouldDisplayCorrectPaymentDetails() {
        page.fillPaymentForm(phone, String.valueOf(sum));
        page.clickContinue();
        page.waitOfVisibilityFrame();
        assertEquals(expectedAmount, page.getPaymentAmount());
        assertTrue(page.getPaymentDetails().contains("375" + phone));
        assertEquals("Номер карты", page.getCardNumberFieldLabel());
        assertEquals(5, page.getPaymentSystemIcons().size());
        assertEquals("Срок действия", page.getCardExpirationFieldLabel());
        assertEquals("CVC", page.getCardCvcFieldLabel());
        assertEquals("Имя и фамилия на карте", page.getCardHolderFieldLabel());
        assertTrue(page.getPaymentButtonText().contains(expectedAmount));
    }
}
