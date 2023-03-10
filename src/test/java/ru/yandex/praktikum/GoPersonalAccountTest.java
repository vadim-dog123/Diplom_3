package ru.yandex.praktikum;

import io.qameta.allure.Allure;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static ru.yandex.praktikum.Authorization.EMAIL;
import static ru.yandex.praktikum.Authorization.PASSWORD;
@DisplayName("Переход в личный кабинет ")
public class GoPersonalAccountTest extends BaseTest {

    @Test
    @DisplayName("Переход в личный кабинет по клику на «Личный кабинет»")
    public void testSuccessfulRegistration() {
        new EntrancePage(driver).open().passwordField(PASSWORD.getText()).emailField(EMAIL.getText()).entranceButtonClick();
        new MainPage(driver).personalAccountButtonClick();
        Allure.step("Проверка перехода в личный кабинет");
        assertTrue(new PersonalAreaPage(driver).isPersonalAreaPage());
    }
}
