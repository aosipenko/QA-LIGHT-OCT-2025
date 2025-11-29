package org.qa.light.session7;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

//TODO: write test that will to go allo.ua, search for iphone 17
//TODO *: Assert that search has at least 3 results

public class WebTest {

    @Test
    public void webTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        List<WebElement> cookieLink = driver.findElements(
                By.xpath("//a[contains(@href, 'technologies/cookies')]"));
        if (!cookieLink.isEmpty()) {
            driver.findElements(By.tagName("button")).get(5).click();
        }
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("Java");
        searchInput.sendKeys(Keys.ENTER);
        driver.quit();
    }

    @Test
    public void testSwitchStatement() {
        String s = "b";
        switch (s) {
            case "a":
                System.out.println("this is a!");
            case "b":
                System.out.println("this is b!");
            case "c":
                System.out.println("this is c!");
            default:
                System.out.println("this is default!");
        }
    }
}
