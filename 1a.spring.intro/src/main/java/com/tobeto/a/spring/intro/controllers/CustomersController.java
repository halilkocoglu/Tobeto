package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.entities.Customer;
import com.tobeto.a.spring.intro.repositories.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomersController {
    private final CustomerRepository customerRepository;
    public CustomersController (CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @GetMapping
    public List<Customer> getAll ( ) {
        return customerRepository.findAll();
    }
    @GetMapping("{id}")
    public Customer getById (@PathVariable Integer id) {
        return customerRepository.findById(id).orElseThrow();
    }
    @PostMapping
    public void addCustomer (@RequestBody Customer customer) {
        customerRepository.save(customer);
    }
    @DeleteMapping("{id}")
    public void deleteCustomer (@PathVariable Integer id) {
        Customer customerToDelete = customerRepository.findById(id).orElseThrow();
        customerRepository.delete(customerToDelete);
    }
    @PutMapping("{id}")
    public void updateCustomer (@RequestBody Customer customer) {
        Customer customerToUpdate = customerRepository.findById(customer.getId()).orElseThrow();
        customerToUpdate.setFirstname(customer.getFirstname());
        customerToUpdate.setLastname(customer.getLastname());
        customerToUpdate.setEmail(customer.getEmail());
        customerToUpdate.setAge(customer.getAge());
        customerRepository.save(customerToUpdate);
    }

}
