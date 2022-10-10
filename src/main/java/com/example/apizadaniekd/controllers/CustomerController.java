package com.example.apizadaniekd.controllers;


import com.example.apizadaniekd.models.Customer;
import com.example.apizadaniekd.models.CustomerDto;
import com.example.apizadaniekd.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.IanaLinkRelations;

@RestController
@RequestMapping("customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("list")
    public CollectionModel<EntityModel<Customer>> index(){
        List<EntityModel<Customer>> customers = customerService.getAll()
                .stream()
                .map(c -> EntityModel.of(c,linkTo(methodOn(CustomerController.class).show(c.getId())).withSelfRel()))
                .collect(Collectors.toList());
        return CollectionModel.of(customers,linkTo(methodOn(CustomerController.class).index()).withSelfRel());

    }

    @GetMapping("list/{id}")
    ResponseEntity<?> show(@PathVariable Long id){
        Customer customer = customerService.get(id);
        if(customer !=null){
            EntityModel<Customer> customerModel = EntityModel.of(customer,
                    linkTo(methodOn(CustomerController.class).show(id)).withSelfRel(),
                    linkTo(methodOn(CustomerController.class).index()).withRel("list"));
            return ResponseEntity.ok().body(customerModel);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("list/{id}")
    ResponseEntity<?> update(@RequestBody CustomerDto customerDto , @PathVariable Long id){
        Customer updatedCustomer = customerService.update(id,customerDto);

        if(updatedCustomer != null){
            EntityModel<Customer> customerModel = EntityModel.of(updatedCustomer,
                    linkTo(methodOn(CustomerController.class).show(id)).withSelfRel());
            return ResponseEntity.ok().body(customerModel);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("list")
    ResponseEntity<?> save(@RequestBody CustomerDto customerDto){
        Customer savedCustomer = customerService.create(customerDto);
        if(savedCustomer != null){
            EntityModel<Customer> customerModel = EntityModel.of(savedCustomer,
                    linkTo(methodOn(CustomerController.class).show(savedCustomer.getId())).withSelfRel());
            return ResponseEntity.created(customerModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(customerModel);
        }else{
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @DeleteMapping("list/{id}")
    ResponseEntity<?> delete(@PathVariable Long id){
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
