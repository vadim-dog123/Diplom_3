package ru.yandex.praktikum;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage {
    public final WebDriver webDriver;
    //Сылка на главную страницу
    private final String entrancePage = "https://stellarburgers.nomoreparties.site/forgot-password";
    // email
    private final By loginButton = By.className("Auth_link__1fOlj");

    public PasswordRecoveryPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Открытие страници регистрации")
    public PasswordRecoveryPage open() {
        webDriver.get(entrancePage);
        return this;
    }

    @Step("Нажатие кнопки Войти")
    public PasswordRecoveryPage loginButtonClick() {
        webDriver.findElement(loginButton).click();
        return this;
    }
}
