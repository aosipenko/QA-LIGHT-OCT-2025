package org.qa.light.session16.steps;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qa.light.session10.ResponseDto;
import org.qa.light.session12.DataHoler;

public class RestStepsV2 {

    private final static Logger LOG = LogManager.getLogger("RestSteps");

    @Given("I request {int} random people from API as {string}")
    public void iRequest3RandomPeopleFromAPI(int amount, String alias) {
        ResponseDto responseDto = RestAssured.given()
                .queryParam("inc", "gender,name,nat")
                .queryParam("results", amount)
                .queryParam("noinfo")
                .baseUri("https://randomuser.me/")
                .basePath("/api")
                .get()
                .as(ResponseDto.class);
        LOG.info("Data received from API {}", responseDto);
        DataHoler.DATA.put(alias, responseDto);
    }
}
