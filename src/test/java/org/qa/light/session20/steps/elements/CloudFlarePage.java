package org.qa.light.session20.steps.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class CloudFlarePage {
    private final WebDriver driver;
    private final static String URL = "https://www.cloudflare.com/";

    public CloudFlarePage(WebDriver driver) {
        this.driver = driver;
        driver.manage().window().maximize();
    }

    public void load() {
        driver.get(URL);
    }

    public void cookies() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("onetrust-accept-btn-handler"))
        );
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void upperMenuHover(String menuName) throws InterruptedException {
        String xpathPattern = String.format("//span[text()='%s']/..", menuName);
        WebElement menuElement = driver.findElement(By.xpath(xpathPattern));

        Actions actions = new Actions(driver);
        actions.moveToLocation(menuElement.getLocation().x, menuElement.getLocation().y);
        actions.perform();
    }
}
