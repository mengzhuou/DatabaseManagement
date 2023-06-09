package com.gtbackend.gtbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    @Id
    @Column(name = "personID")
    private String personID;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "locationID")
    private String locationID;

    public Person() {
    }

    public Person(String personID, String first_name, String last_name, String locationID) {
        this.personID = personID;
        this.first_name = first_name;
        this.last_name = last_name;
        this.locationID = locationID;
    }

    //personID
    public String getPersonID(){
        return personID;
    }

    public void setPersonID(String personID){
        this.personID = personID;
    }

    //first_name
    public String getFirst_name(){
        return first_name;
    }

    public void setFirst_name(String first_name){
        this.first_name = first_name;
    }

    //last_name
    public String getLast_name(){
        return last_name;
    }

    public void setLast_name(String last_name){
        this.last_name = last_name;
    }

    //locationID
    public String getLocationID(){
        return locationID;
    }

    public void setLocationID(String locationID){
        this.locationID = locationID;
    }
}