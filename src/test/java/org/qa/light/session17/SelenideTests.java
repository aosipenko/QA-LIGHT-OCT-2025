package org.qa.light.session17;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SelenideTests {

    @Test
    public void test() {
        WebDriverRunner.setWebDriver(new ChromeDriver());
        Selenide.open("https://www.google.com");
        $(".APjFqb").click();
        $(".asdasdczx").click();
        $(".APjFqb").click();
        $(".1234345").click();
        $(".sdvrtfv4").click();

        WebDriverRunner.getWebDriver().quit();

    }
}
