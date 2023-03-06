package ru.yandex.praktikum;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    public final WebDriver webDriver;
    //Сылка на главную страницу
    private final String registrationPage = "https://stellarburgers.nomoreparties.site/register";
    //имя
    private final By nameField = By.xpath(".//fieldset[1]/div/div/input");
    // email
    private final By emailField = By.xpath(".//fieldset[2]/div/div/input");
    //  пароль
    private final By passwordField = By.xpath(".//fieldset[3]/div/div/input");
    // зарегистрироваться
    private final By registrationButton = By.xpath(".//form/button");
    private final By loginButton = By.className("Auth_link__1fOlj");
    //сообщение о неправильном пароле
    private final By inputError = By.xpath(".//fieldset[3]/div/p");

    public RegistrationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Открытие страници регистрации")
    public RegistrationPage open() {
        webDriver.get(registrationPage);
        return this;
    }

    @Step("Ввод email={text}")
    public RegistrationPage emailField(String text) {
        webDriver.findElement(emailField).sendKeys(text);
        return this;
    }

    @Step("Ввод password={text}")
    public RegistrationPage passwordField(String text) {
        webDriver.findElement(passwordField).sendKeys(text);
        return this;
    }

    @Step("Ввод name={text}")
    public RegistrationPage nameField(String text) {
        webDriver.findElement(nameField).sendKeys(text);
        return this;
    }

    @Step("Нажатие кнопки регистрации")
    public RegistrationPage registrationButtonClick() {
        webDriver.findElement(registrationButton).click();
        return this;
    }

    @Step("Нажатие кнопки войти")
    public RegistrationPage loginButtonClick() {
        webDriver.findElement(loginButton).click();
        return this;
    }

    @Step("Запрос текста ошибки при задании неправильного пароле")
    public String getInputError() {
        return webDriver.findElement(inputError).getText();
    }
}
