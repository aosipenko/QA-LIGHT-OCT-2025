package org.qa.light.session13.steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.qa.light.session13.steps.elements.GeneralPageObject;
import org.qa.light.session13.steps.elements.GooglePageElements;
import org.qa.light.session20.TestComponent;
import org.qa.light.session8.CloudFlarePage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class WebSteps {
    public static CloudFlarePage cloudFlarePage;
    public static WebDriver driver;
    public static GeneralPageObject generalPageObject;

    @Given("Cloud flare step")
    public void cloudFlareStep() {
        cloudFlarePage.load();
    }

    @Given("I load google page")
    public void iLoadGooglePage() {
        driver.get("https://www.google.com");
    }

    @Given("I accept google cookies")
    public void acceptGoogleCookies() {
        List<WebElement> cookieLink = driver.findElements(
                GooglePageElements.COOKIES_LINK.getLocator());
        if (!cookieLink.isEmpty()) {
            driver.findElements(GooglePageElements.ACCEPT_COOKIES.getLocator())
                    .get(5).click();
        }
    }

    @Given("I click {} if present")
    public void iClickIfPresent(GooglePageElements element) {
        List<WebElement> elements = driver.findElements(element.getLocator());
        if (!elements.isEmpty()) {
            elements.get(0).click();
        }
    }

    @Given("I click {}")
    public void iClickSearchInput(GooglePageElements element) {
        generalPageObject.clickSomething(element);
    }

    @Given("I set element {} value to {string}")
    public void iSetElementValueTo(GooglePageElements element, String value) {
        driver.findElement(element.getLocator()).sendKeys(value);
    }

    @Given("I send {} to {}")
    public void iSendEnterToSearchInput(Keys keys, GooglePageElements element) {
        driver.findElement(element.getLocator()).sendKeys(keys);
    }
}
