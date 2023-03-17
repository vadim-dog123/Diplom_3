package ru.yandex.praktikum;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAreaPage {
    public final WebDriver webDriver;
    /* Сылка на страницу */
    private final String personalAreaPage = "https://stellarburgers.nomoreparties.site/account/profile";
    private final By accountText = By.xpath(".//*[text()='В этом разделе вы можете изменить свои персональные данные']");
    private final By exitButton = By.xpath(".//*[text()='Выход']");

    public PersonalAreaPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Открытие главной страници")
    public PersonalAreaPage open() {
        webDriver.get(personalAreaPage);
        return this;
    }

    @Step("Нажатие кнопки 'Выход'")
    public PersonalAreaPage exitButtonClick() {
        webDriver.findElement(exitButton).click();
        return this;
    }

    @Step("Надпись 'В этом разделе вы можете изменить свои персональные данные' есть")
    public boolean isPersonalAreaPage() {
        return webDriver.findElement(accountText).isDisplayed();
    }
}
