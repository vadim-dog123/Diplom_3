package ru.yandex.praktikum;

import io.qameta.allure.Allure;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static ru.yandex.praktikum.Authorization.EMAIL;
import static ru.yandex.praktikum.Authorization.PASSWORD;
@DisplayName("Вход")
public class EntrancePageTest extends BaseTest {

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