package com.example.apizadaniekd.repository;

import com.example.apizadaniekd.models.Customer;
import com.example.apizadaniekd.models.CustomerDto;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepository {

    static Long currentId = 5L;

    private List<Customer> customers = new LinkedList<>(
            Arrays.asList(
                    new Customer(1L,"Anna","Nowak","abc@gmail.com","12345678"),
                    new Customer(1L,"Marcin","Nowicki","ggg@gmail.com","12345678"),
                    new Customer(1L,"Michal","Kowal","mmmm@gmail.com","12345678"),
                    new Customer(1L,"Maria","Kowalczyk","ooo@gmail.com","12345678")
            )
    );

    public List<Customer> getAll(){return customers;}

    public Optional<Customer> get(Long id){
        return customers.stream().filter(customer ->
                customer.getId().equals(id)).findFirst();
    }

    public Customer create(CustomerDto customerDto){
        Customer newCustomer = new Customer(currentId++,customerDto);
        customers.add(newCustomer);
        return newCustomer;
    }

    public Customer update(Customer customer,CustomerDto customerDto){
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmailAddress(customerDto.getEmailAddress());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        return customer;
    }

    public void delete(Customer customer){customers.remove(customer);}
}

