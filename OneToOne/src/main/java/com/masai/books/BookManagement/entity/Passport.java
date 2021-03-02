package com.masai.books.BookManagement.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Passport {

    @Id
    String passportId;
    String passportNumber;




    public Passport(String passportId, String passportNumber) {
        this.passportId = passportId;
        this.passportNumber = passportNumber;
    }


    public Passport(){

    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

   }
