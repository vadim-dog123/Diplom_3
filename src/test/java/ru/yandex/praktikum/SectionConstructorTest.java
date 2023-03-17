package ru.yandex.praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
@DisplayName("Раздел «Конструктор»")
public class SectionConstructorTest extends BaseTest {
    @Test
    @DisplayName("Переход к разделу «Булки»")
    public void rollsTest() {
        assertEquals(new MainPage(driver).open().fillingButtonClick().rollsButtonClick().getSelectedIngredientText(), "Булки");
    }

    @Test
    @DisplayName("Переход к разделу «Соусы»")
    public void saucesTest() {
        assertEquals(new MainPage(driver).open().saucesButtonClick().getSelectedIngredientText(), "Соусы");
    }

    @Test
    @DisplayName("Переход к разделу «Начинки»")
    public void fillingTest() {
        assertEquals(new MainPage(driver).open().fillingButtonClick().getSelectedIngredientText(), "Начинки");
    }
}
