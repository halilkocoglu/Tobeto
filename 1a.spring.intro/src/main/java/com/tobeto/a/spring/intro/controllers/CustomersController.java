package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.services.abstracts.CustomerService;
import com.tobeto.a.spring.intro.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.a.spring.intro.services.dtos.customer.requests.UpdateCustomerRequest;
import com.tobeto.a.spring.intro.services.dtos.customer.responses.GetCustomerResponse;
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
    public GetCustomerResponse getById (@PathVariable Integer id) {
        return customerService.getById(id);
    }

    @GetMapping
    public List<GetCustomerResponse> getAll ( ) {
        return customerService.getAll();
    }
    @GetMapping("dto-greater-age")
    public List<GetCustomerResponse> getByAgeGreaterThan(@RequestParam Short age){
        return customerService.getByAgeGreaterThan(age);
    }
    @GetMapping("dto-adults")
    public List<GetCustomerResponse> getAdults() {
        return customerService.getAdultCustomers();
    }
}
