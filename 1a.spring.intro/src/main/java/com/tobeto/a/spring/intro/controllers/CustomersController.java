package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.entities.Customer;
import com.tobeto.a.spring.intro.repositories.CustomerRepository;
import com.tobeto.a.spring.intro.services.abstracts.CustomerService;
import com.tobeto.a.spring.intro.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.a.spring.intro.services.dtos.customer.requests.UpdateCustomerRequest;
import com.tobeto.a.spring.intro.services.dtos.customer.responses.GetAllCustomerResponse;
import com.tobeto.a.spring.intro.services.dtos.customer.responses.GetCustomerByIdResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomersController {
    private final CustomerService customerService;

    public CustomersController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public void addCustomer (@RequestBody AddCustomerRequest request) {
        customerService.add(request);
    }
    @PutMapping("{id}")
    public void updateCustomer (@RequestBody UpdateCustomerRequest request) {
        customerService.update(request);
    }
    @DeleteMapping("{id}")
    public void deleteCustomer (@PathVariable Integer id) {
        customerService.delete(id);
    }
    @GetMapping("{id}")
    public GetCustomerByIdResponse getById (@PathVariable Integer id) {
        return customerService.getById(id);
    }

    @GetMapping
    public List<GetAllCustomerResponse> getAll ( ) {
        return customerService.getAll();
    }
}
