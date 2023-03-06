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

public class EntrancePageTest {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginThroughButtonInRegistrationTest() {
        new RegistrationPage(driver).open().loginButtonClick();
        new EntrancePage(driver).open().passwordField(PASSWORD.getText()).emailField(EMAIL.getText()).entranceButtonClick();
        Allure.step("Проверка перехода на главную страницу после авториации");
        assertTrue(new MainPage(driver).isMainPage());
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void logInUsingLoginButtonOnMainTest() {
        MainPage mainPage = new MainPage(driver).open().loginButtonClick();
        new EntrancePage(driver).passwordField(PASSWORD.getText()).emailField(EMAIL.getText()).entranceButtonClick();
        Allure.step("Проверка перехода на главную страницу после авториации");
        assertTrue(mainPage.isMainPage());
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void loginThroughButtonPersonalTest() {
        MainPage mainPage = new MainPage(driver).open().personalAccountButtonClick();
        new EntrancePage(driver).passwordField(PASSWORD.getText()).emailField(EMAIL.getText()).entranceButtonClick();
        Allure.step("Проверка перехода на главную страницу после авториации");
        assertTrue(mainPage.isMainPage());
    }

    @Test
    @DisplayName("Bход через кнопку в форме восстановления пароля")
    public void loginThroughButtonInPasswordRecoveryTest() {
        new PasswordRecoveryPage(driver).open().loginButtonClick();
        new EntrancePage(driver).passwordField(PASSWORD.getText()).emailField(EMAIL.getText()).entranceButtonClick();
        Allure.step("Проверка перехода на главную страницу после авториации");
        assertTrue(new MainPage(driver).isMainPage());
    }
}