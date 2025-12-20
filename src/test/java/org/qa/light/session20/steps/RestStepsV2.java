package org.qa.light.session20.steps;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import org.qa.light.session10.ResponseDto;
import org.qa.light.session20.DataHoler;
import org.springframework.beans.factory.annotation.Autowired;

public class RestStepsV2 {

    @Autowired
    private DataHoler dataHoler;

    @Given("I request {int} random people from API as {string}")
    public void iRequest3RandomPeopleFromAPI(int amount, String alias) {
        dataHoler.put(alias, RestAssured.given()
                .queryParam("inc", "gender,name,nat")
                .queryParam("results", amount)
                .queryParam("noinfo")
                .baseUri("https://randomuser.me/")
                .basePath("/api")
                .get()
                .as(ResponseDto.class));
    }
}
