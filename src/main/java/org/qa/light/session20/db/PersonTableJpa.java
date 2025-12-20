package org.qa.light.session20.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonTableJpa extends JpaRepository<PersonsTable, Integer> {

    @Query(value = "SELECT * FROM Persons", nativeQuery = true)
    List<PersonsTable> customQuery();

    Optional<PersonsTable> findByFirstNameAndLastNameAndGender
            (String firstName, String lastName, String gender);
}
