package org.qa.light.session20.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.qa.light.session10.PersonDto;
import org.qa.light.session10.ResponseDto;
import org.qa.light.session20.DataHoler;
import org.qa.light.session20.db.PersonTableJpa;
import org.qa.light.session20.db.PersonsTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.testng.Assert;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class DBStepsV2 {

    @Autowired
    private DataHoler dataHoler;

    @Autowired
    private PersonTableJpa personTableJpa;

    @When("I store {string} in DB and new entries count is {string}")
    public void iStoreThosePeopleInDB(String alias, String entriesCountAlias) throws SQLException {
        //TODO: explain later
//        responseDto.getResults()
//                .stream()
//                .map(personDto -> fromDto(personDto))
//                .forEach(personDto -> personTableJpa.save(personDto));
        ResponseDto responseDto = (ResponseDto) dataHoler.get(alias);
        Integer count = 0;
        List<PersonDto> personDtos = responseDto.getResults();
        for (PersonDto personDto : personDtos) {
            PersonsTable personsTable = fromDto(personDto);
            try {
                personTableJpa.save(personsTable);
            } catch (Exception ex) {
                System.out.println("Failed to save to DB: " + personDto);
            }
            count++;
        }
        dataHoler.put(entriesCountAlias, count);
    }

    @Then("DB {string} has {string} more rows")
    public void thenDBHas3MoreEntries(String oldEntriesAlias, String newEntriesCountAlias) throws SQLException {
        int initialRowsCount = (Integer) dataHoler.get(oldEntriesAlias);
        int newRowsCount = (Integer) dataHoler.get(newEntriesCountAlias);
        Assert.assertEquals(
                personTableJpa.count(),
                initialRowsCount + newRowsCount,
                "DB Entries count mismatch!");
    }

    @Given("I store database row count as {string}")
    public void checkDatabaseRowCount(String alias) throws SQLException {
        dataHoler.put(alias, personTableJpa.count());
    }

    private PersonsTable fromDto(PersonDto personDto) {
        return PersonsTable.builder()
                .firstName(personDto.getName().getFirst())
                .lastName(personDto.getName().getLast())
                .title(personDto.getName().getTitle())
                .nat(personDto.getNat())
                .gender(personDto.getGender())
                .build();
    }

    @Given("I search for first name {string} last name {string}")
    public void iSearchForFirstNameLastName(String firstName, String lastName) {
        Optional<PersonsTable> person = personTableJpa.findOne(Example.of(
                PersonsTable.builder()
                        .firstName(firstName)
                        .lastName(lastName)
                        .build(),
                ExampleMatcher.matchingAny()
        ));
        Assert.assertFalse(person.isEmpty(), "No persons found!");
        person.get().setNat("PG");
        personTableJpa.save(person.get());
    }
}
