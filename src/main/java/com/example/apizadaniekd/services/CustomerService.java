package com.example.apizadaniekd.services;

import com.example.apizadaniekd.exceptions.ResourceNotFoundException;
import com.example.apizadaniekd.models.Customer;
import com.example.apizadaniekd.models.CustomerDto;
import com.example.apizadaniekd.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    public List<Customer> getAll(){
        return customerRepository.getAll();
    }

    public Customer get(Long id){
        return customerRepository.get(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Customer create(CustomerDto customerDto){
        return customerRepository.create(customerDto);
    }

    public Customer update(Long id, CustomerDto customerDto){
        Customer customer = get(id);
        return customerRepository.update(customer,customerDto);
    }

    public void delete(Long id){
        Customer customer = get(id);
        customerRepository.delete(customer);
    }
}
