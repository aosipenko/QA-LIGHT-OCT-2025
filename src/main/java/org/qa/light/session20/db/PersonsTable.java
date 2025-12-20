package org.qa.light.session20.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Persons")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonsTable {
    @Id
    @Column(name = "PersonID")
    private int personId;
    @Column(name = "LastName")
    private String lastName;
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "Gender")
    private String gender;
    @Column(name = "Title")
    private String title;
    @Column(name = "Nat")
    private String nat;
}
