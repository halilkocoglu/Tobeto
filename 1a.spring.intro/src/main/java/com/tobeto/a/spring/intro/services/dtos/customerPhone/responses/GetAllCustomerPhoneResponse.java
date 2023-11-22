package com.tobeto.a.spring.intro.services.dtos.customerPhone.responses;

import com.tobeto.a.spring.intro.entities.Customer;
import com.tobeto.a.spring.intro.entities.PhoneCountryCode;
import lombok.Data;

@Data
public class GetAllCustomerPhoneResponse {
    private Integer id;
    private Customer customer;
    private PhoneCountryCode phoneCountryCode;
    private String phone;
}
