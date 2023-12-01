package com.tobeto.a.spring.intro.services.dtos.customerPhone.responses;

import com.tobeto.a.spring.intro.entities.Customer;
import com.tobeto.a.spring.intro.entities.PhoneCountryCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomerPhoneResponse {
    private Integer id;
    private Customer customer;
    private PhoneCountryCode phoneCountryCode;
    private String phone;
}
