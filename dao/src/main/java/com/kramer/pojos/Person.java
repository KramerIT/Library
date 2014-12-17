/*
 * Copyright (c) 2012 by VeriFone, Inc.
 * All Rights Reserved.
 *
 * THIS FILE CONTAINS PROPRIETARY AND CONFIDENTIAL INFORMATION
 * AND REMAINS THE UNPUBLISHED PROPERTY OF VERIFONE, INC.
 *
 * Use, disclosure, or reproduction is prohibited
 * without prior written approval from VeriFone, Inc.
 */
package com.kramer.pojos;

import javax.persistence.*;

/**
 * User: yslabko
 * Date: 14.04.14
 * Time: 12:24
 */
@Entity
//@SequenceGenerator(name = "PK", sequenceName = "t_person_seq")
public class Person {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "F_PERSON_ID")
    @GeneratedValue//(strategy = GenerationType.SEQUENCE, generator = "PK")
    private Integer id;

    private Integer age;

    private String name;

    private String surname;
    //private Address personAddress;

    public Person() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

//    public Address getPersonAddress() {
//        return personAddress;
//    }
//
//    public void setPersonAddress(Address personAddress) {
//        this.personAddress = personAddress;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (age != null ? !age.equals(person.age) : person.age != null) return false;
        if (id != null ? !id.equals(person.id) : person.id != null) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        //if (personAddress != null ? !personAddress.equals(person.personAddress) : person.personAddress != null) return false;
        if (surname != null ? !surname.equals(person.surname) : person.surname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        //result = 31 * result + (personAddress != null ? personAddress.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person : id: " + id + " Name: " + name + " Surname: " + surname + " Age: " +age;// + personAddress;
    }
}
