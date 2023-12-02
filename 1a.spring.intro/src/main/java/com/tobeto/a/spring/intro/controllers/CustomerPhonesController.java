package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.entities.Customer;
import com.tobeto.a.spring.intro.entities.PhoneCountryCode;
import com.tobeto.a.spring.intro.services.abstracts.CustomerPhoneService;
import com.tobeto.a.spring.intro.services.dtos.customerPhone.requests.AddCustomerPhoneRequest;
import com.tobeto.a.spring.intro.services.dtos.customerPhone.requests.UpdateCustomerPhoneRequest;
import com.tobeto.a.spring.intro.services.dtos.customerPhone.responses.GetCustomerPhoneResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/phones/customer-phones")
public class CustomerPhonesController {
    private CustomerPhoneService customerPhoneService;

    public CustomerPhonesController(CustomerPhoneService customerPhoneService) {
        this.customerPhoneService = customerPhoneService;
    }

    @PostMapping
    public void addCustomerPhone  (@RequestBody AddCustomerPhoneRequest request) {
        customerPhoneService.add(request);
    }
    @PutMapping("{id}")
    public void updateCustomerPhone (@RequestBody UpdateCustomerPhoneRequest request) {
        customerPhoneService.update(request);
    }
    @DeleteMapping("{id}")
    public void deleteCustomerPhone (@PathVariable Integer id) {
        customerPhoneService.delete(id);
    }
    @GetMapping("{id}")
    public GetCustomerPhoneResponse getById(@PathVariable Integer id) {
        return customerPhoneService.getById(id);
    }
    @GetMapping
    public List<GetCustomerPhoneResponse> getAll() {
        return customerPhoneService.getAll();
    }
    @GetMapping("dto-byCustomer")
    public List<GetCustomerPhoneResponse> getByCustomer(@RequestParam Integer id){
        return customerPhoneService.getByCustomer(id);
    }
    @GetMapping("dto-byCountryCode")
    public  List<GetCustomerPhoneResponse> getByCountryCode(@RequestParam Integer id ){
        return  customerPhoneService.getByCountryCode(id);
    }
}
