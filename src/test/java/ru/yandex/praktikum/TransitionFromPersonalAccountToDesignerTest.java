package ru.yandex.praktikum;

import io.qameta.allure.Allure;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static ru.yandex.praktikum.Authorization.EMAIL;
import static ru.yandex.praktikum.Authorization.PASSWORD;
@DisplayName("Переход из личного кабинета в конструктор ")
public class TransitionFromPersonalAccountToDesignerTest extends BaseTest {

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на логотип Stellar Burgers")
    public void logoStellarBurgersButtonClickTest() {
        new EntrancePage(driver).open().passwordField(PASSWORD.getText()).emailField(EMAIL.getText()).entranceButtonClick();
        new MainPage(driver).personalAccountButtonClick();
        new MainPage(driver).logoStellarBurgersButtonClick();
        Allure.step("Проверка перехода в конструктор");
        assertTrue("Страница с конструктором не открыта", new MainPage(driver).isMainPage());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на «Конструктор»")
    public void constructorButtonClickTest() {
        new EntrancePage(driver).open().passwordField(PASSWORD.getText()).emailField(EMAIL.getText()).entranceButtonClick();
        new MainPage(driver).personalAccountButtonClick();
        new MainPage(driver).constructorButtonClick();
        Allure.step("Проверка перехода в конструктор");
        assertTrue("Страница с конструктором не открыта", new MainPage(driver).isMainPage());
    }
}
