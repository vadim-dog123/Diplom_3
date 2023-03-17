package ru.yandex.praktikum;

import io.qameta.allure.Allure;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static ru.yandex.praktikum.Authorization.EMAIL;
import static ru.yandex.praktikum.Authorization.PASSWORD;
@DisplayName("Выход из аккаунта")
public class LogoutTest extends BaseTest {
    @Test
    @DisplayName("Проверка выхода из акаунта по кнопке «Выйти» в личном кабинете")
    public void testSuccessfulRegistration() {
        new EntrancePage(driver).open().passwordField(PASSWORD.getText()).emailField(EMAIL.getText()).entranceButtonClick();
        new MainPage(driver).personalAccountButtonClick();
        new PersonalAreaPage(driver).exitButtonClick();
        Allure.step("Проверка перехода к страници авторизации");
        assertTrue(new EntrancePage(driver).isInputText());
    }
}
