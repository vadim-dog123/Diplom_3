package ru.yandex.praktikum;

import io.qameta.allure.Allure;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.junit4.Tag;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@DisplayName("Регистрация")
public class RegistrationTest extends BaseTest {
    @Test
    @DisplayName("Успешная регистрация")
    public void testSuccessfulRegistration() {
        new RegistrationPage(driver).open().nameField("name" + new Random().nextInt(10000000)).emailField("email" + new Random().nextInt(10000000) + "@email.ru").passwordField("password" + new Random().nextInt(10000000)).registrationButtonClick();
        Allure.step("Проверка перехода на страницу входа");
        assertTrue("Страница входа не открыта", new EntrancePage(driver).isInputText());
    }
    @Test
    @DisplayName("Ошибка при некорректном пароле.")
    public void testIncorrectPassword() {
        var text = new RegistrationPage(driver).open().nameField("name" + new Random().nextInt(10000000)).emailField("email" + new Random().nextInt(10000000) + "@email.ru").passwordField("12345").registrationButtonClick().getInputError();
        Allure.step("Проверка текста ошибки при неправильном пароле");
        assertEquals("Текст о неправильном пароле не совпадает", "Некорректный пароль", text);
    }
}