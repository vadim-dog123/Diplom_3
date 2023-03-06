package ru.yandex.praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static ru.yandex.praktikum.Authorization.EMAIL;
import static ru.yandex.praktikum.Authorization.PASSWORD;

public class LogoutTest {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        new EntrancePage(driver).open().passwordField(PASSWORD.getText()).emailField(EMAIL.getText()).entranceButtonClick();
        new MainPage(driver).personalAccountButtonClick();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Проверка выхода из акаунта по кнопке «Выйти» в личном кабинете")
    public void testSuccessfulRegistration() {
        new PersonalAreaPage(driver).exitButtonClick();
        Allure.step("Проверка перехода к страници авторизации");
        assertTrue(new EntrancePage(driver).isInputText());
    }
}
