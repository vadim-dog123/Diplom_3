package ru.yandex.praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class SectionConstructorTest {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }


    @Test
    @DisplayName("Переход к разделу «Булки»")
    public void rollsTest() {
        assertEquals(new MainPage(driver).open().rollsButtonClick().fillingChapterText(),
                "Начинки");
    }

    @Test
    @DisplayName("Переход к разделу «Соусы»")
    public void saucesTest() {

    }

    @Test
    @DisplayName("Переход к разделу «Начинки»")
    public void fillingTest() {

    }
}
