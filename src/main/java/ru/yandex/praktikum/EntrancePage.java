package ru.yandex.praktikum;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EntrancePage {
    public final WebDriver webDriver;
    //Сылка на главную страницу
    private final String entrancePage = "https://stellarburgers.nomoreparties.site/login";

    // email
    private final By emailField = By.xpath(".//fieldset[1]/div/div/input");
    //  пароль
    private final By passwordField = By.xpath(".//fieldset[2]/div/div/input");
    //кнопка вход
    private final By entranceButton = By.xpath(".//form/button");

    private final By inputText = By.xpath(".//*[text()='Вход']");


    public EntrancePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Открытие страници регистрации")
    public EntrancePage open() {
        webDriver.get(entrancePage);
        return this;
    }

    @Step("Ввод email={text}")
    public EntrancePage emailField(String text) {
        webDriver.findElement(emailField).sendKeys(text);
        return this;
    }

    @Step("Ввод password={text}")
    public EntrancePage passwordField(String text) {
        webDriver.findElement(passwordField).sendKeys(text);
        return this;
    }

    @Step("Нажатие кнопки регистрации")
    public EntrancePage entranceButtonClick() {
        webDriver.findElement(entranceButton).click();
        return this;
    }

    @Step("Страница входа открыта")
    public boolean isInputText() {
        return webDriver.findElement(inputText).getText().equals("Вход");
    }
}
