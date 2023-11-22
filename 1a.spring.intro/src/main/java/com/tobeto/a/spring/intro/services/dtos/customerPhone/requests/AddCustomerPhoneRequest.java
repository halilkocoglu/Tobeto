package com.tobeto.a.spring.intro.services.dtos.customerPhone.requests;

import com.tobeto.a.spring.intro.entities.Customer;
import com.tobeto.a.spring.intro.entities.PhoneCountryCode;
import lombok.Data;

@Data
public class AddCustomerPhoneRequest {
    private Customer customer;
    private PhoneCountryCode phoneCountryCode;
    private String phone;
}
