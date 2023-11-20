package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.entities.CustomerPhone;
import com.tobeto.a.spring.intro.repositories.CustomerPhoneRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/phones/customer-phones")
public class CustomerPhonesController {
    private final CustomerPhoneRepository customerPhoneRepository;

    public CustomerPhonesController(CustomerPhoneRepository customerPhoneRepository) {
        this.customerPhoneRepository = customerPhoneRepository;
    }

    @GetMapping
    public List<CustomerPhone> getAll() {
        return customerPhoneRepository.findAll();
    }
    @GetMapping("{id}")
    public CustomerPhone getById(@PathVariable Integer id) {
        return customerPhoneRepository.findById(id).orElseThrow();
    }
    @PostMapping
    public void addCustomerPhone  (@RequestBody CustomerPhone customerPhone) {
        customerPhoneRepository.save(customerPhone);
    }
    @DeleteMapping("{id}")
    public void deleteCustomerPhone (@PathVariable Integer id) {
        CustomerPhone customerPhoneToDelete = customerPhoneRepository.findById(id).orElseThrow();
        customerPhoneRepository.delete(customerPhoneToDelete);
    }
    @PutMapping("{id}")
    public void updateCustomerPhone (@RequestBody CustomerPhone customerPhone) {
        CustomerPhone customerPhoneToUpdate = customerPhoneRepository.findById(customerPhone.getId()).orElseThrow();
        customerPhoneToUpdate.setCustomer(customerPhone.getCustomer());
        customerPhoneToUpdate.setPhoneCountryCode(customerPhone.getPhoneCountryCode());
        customerPhoneToUpdate.setPhone(customerPhone.getPhone());
        customerPhoneRepository.save(customerPhoneToUpdate);
    }
}
