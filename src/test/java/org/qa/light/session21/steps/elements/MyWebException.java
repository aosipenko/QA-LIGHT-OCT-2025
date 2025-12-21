package org.qa.light.session21.steps.elements;

import lombok.Getter;
import org.openqa.selenium.WebDriver;

public class MyWebException extends RuntimeException {

    @Getter
    private WebDriver driver;

    public MyWebException(WebDriver driver, String message) {
        super(message);
        this.driver = driver;
    }
}
