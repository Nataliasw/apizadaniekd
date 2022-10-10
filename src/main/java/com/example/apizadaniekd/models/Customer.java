package com.example.apizadaniekd.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {


    private Long id;
    private String firstName;
    private String lastName;

    private String emailAddress;
    private String phoneNumber;

    public Customer(Long id, String firstName, String lastName, String emailAddress, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    public Customer(Long id, CustomerDto customerDto){
        this.id = id;
        this.firstName = customerDto.getFirstName();
        this.lastName = customerDto.getLastName();
        this.emailAddress = customerDto.getEmailAddress();
        this.phoneNumber = customerDto.getPhoneNumber();
    }
}
