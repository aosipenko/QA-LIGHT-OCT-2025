package org.qa.light.session21.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.SneakyThrows;
import org.qa.light.session12.AgentActions;
import org.testng.Assert;

import java.util.Random;

public class DemoSteps {
    private final static Random RANDOM = new Random();

    private static final ThreadLocal<String> s = new ThreadLocal<>();

    @SneakyThrows
    @Given("I set value to {string}")
    public void setValue(String value) {
        int pause = RANDOM.nextInt(100);
        Thread.sleep(pause);
        s.set(value);
    }

    @Then("I print value")
    public void iPrintValue() {
        System.out.println(s.get());
    }

    @Given("Print this number {int}")
    public void printThisNumber(int number) {
        System.out.println(number);
    }

    @Given("Print this string {string}")
    public void printThisString(String string) {
        System.out.println(string);
    }

    @SneakyThrows
    @Given("Support agent executes {}")
    public void supportAgentExecutes(AgentActions actions) {
        int i = RANDOM.nextInt(100);
        if (i <= 5) {
            throw new RuntimeException("Random error");
        }
        if (i <= 10) {
            Assert.fail("Test broke randomly!");
        }
        switch (actions) {
            case UPDATE_USER_DATA:
                System.out.println("Agent updates user data");
                break;
            case DELETE_USER_DATA:
                System.out.println("Agent deletes user data");
                break;
            case REGISTER_NEW_USER_DATA:
                System.out.println("Agent registers new user data");
                break;
        }
    }
}
