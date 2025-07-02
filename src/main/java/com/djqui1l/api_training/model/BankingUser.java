package com.djqui1l.api_training.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;

public class BankingUser {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
//    private String phone;
//    private String password;
    private Double balance;

    public BankingUser(){
        /*
        This no-args constructor is required by Spring (via Jackson) to create a BankingUser object from a JSON request (e.g., during a POST or PUT). Jackson deserializes the incoming JSON into a Java object by first calling this constructor, then using the setters in this class to populate the fields.
         */

        this.balance = 0.00; // default balance
    }

    public BankingUser(String firstName, String lastName)
 // this constructor is for me and whatever I may want to do with it within this code base.
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = 0.00;

    }
    //================================
    public String getId(){
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    //================================
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    //================================
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    // ==============================
    public Double getBalance(){
        return balance;
    }

    public void withdraw(Double amount) {
        this.balance -= amount;
    }

    public void deposit(Double amount) {
        this.balance += amount;
    }






}
