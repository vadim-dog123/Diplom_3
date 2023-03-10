package ru.yandex.praktikum;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    public final WebDriver webDriver;
    //Сылка на главную страницу
    private final String mainPage = "https://stellarburgers.nomoreparties.site/";
    //Кнопка войти в акаунт
    private final By loginButton = By.xpath(".//section[2]/div/button");
    //Кнопка личный кабинет
    private final By personalAccountButton = By.xpath(".//header/nav/a");
    //Собери свой бургер
    private final By assembleBurger = By.xpath(".//section[1]/h1");
    //Кнопка логотип
    private final By logoStellarBurgersButton = By.className("AppHeader_header__logo__2D0X2");
    //Кнопка "Конструктор"
    private final By constructorButton = By.className("AppHeader_header__link__3D_hX");
    //Кнопка "Булки"
    private final By rollsButton = By.xpath(".//section[1]/div[1]/div[1]");
    //Кнопка "Соусы"
    private final By saucesButton = By.xpath(".//section[1]/div[1]/div[2]");
    //Кнопка "Начинка"
    private final By fillingButton = By.xpath(".//section[1]/div[1]/div[3]");

    private final By selectedIngredientChapter = By.xpath(".//div[contains(@class,'tab_tab_type_current__2BEPc ')]");

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Открытие главной страницы")
    public MainPage open() {
        webDriver.get(mainPage);
        return this;
    }

    @Step("Нажатие кнопку 'войти в акаунт'")
    public MainPage loginButtonClick() {
        webDriver.findElement(loginButton).click();
        return this;
    }

    @Step("Нажатие кнопку StellarBurgers")
    public MainPage logoStellarBurgersButtonClick() {
        webDriver.findElement(logoStellarBurgersButton).click();
        return this;
    }

    @Step("Нажатие кнопку 'Конструктор'")
    public MainPage constructorButtonClick() {
        webDriver.findElement(constructorButton).click();
        return this;
    }

    @Step("Нажатие кнопку 'войти в акаунт'")
    public MainPage personalAccountButtonClick() {
        webDriver.findElement(personalAccountButton).click();
        return this;
    }

    @Step("Нажатие кнопку 'Булки'")
    public MainPage rollsButtonClick() {
        webDriver.findElement(rollsButton).click();
        return this;
    }

    @Step("Нажатие кнопку 'Соусы'")
    public MainPage saucesButtonClick() {
        webDriver.findElement(saucesButton).click();
        return this;
    }

    @Step("Нажатие кнопку 'Начинки'")
    public MainPage fillingButtonClick() {
        webDriver.findElement(fillingButton).click();
        return this;
    }

    @Step("Надпись 'Соберите бургер' есть")
    public boolean isMainPage() {
        return webDriver.findElement(assembleBurger).getText().equals("Соберите бургер");
    }

    @Step("Текс ыбранной категории")
    public String getSelectedIngredientText() {
        System.out.println(webDriver.findElement(selectedIngredientChapter).getText());
        return webDriver.findElement(selectedIngredientChapter).getText();
    }
}
