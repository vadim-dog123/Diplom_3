package ru.yandex.praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegistrationTest {
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
    @DisplayName("Успешная регистрация")
    public void testSuccessfulRegistration() {
        new RegistrationPage(driver).open().nameField("name" + new Random().nextInt(10000000)).emailField("email" + new Random().nextInt(10000000) + "@email.ru").passwordField("password" + new Random().nextInt(10000000)).registrationButtonClick();
        Allure.step("Проверка перехода на страницу входа");
        assertTrue("Страница входа не открыта", new EntrancePage(driver).isInputText());
    }

    @Test
    @DisplayName("Ошибку для некорректного пароля. Минимальный пароль — шесть символов")
    public void testIncorrectPassword() {
        var text = new RegistrationPage(driver).open().nameField("name" + new Random().nextInt(10000000)).emailField("email" + new Random().nextInt(10000000) + "@email.ru").passwordField("12345").registrationButtonClick().getInputError();
        Allure.step("Проверка текста ошибки при неправильном пароле");
        assertEquals("Текст о неправильном пароле не совпадает", "Некорректный пароль", text);
    }
}