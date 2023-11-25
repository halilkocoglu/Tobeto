package com.tobeto.a.spring.intro.services.dtos.customer.requests;

import lombok.Data;

@Data
public class AddCustomerRequest {
    private String firstname;
    private String lastname;
    private String email;
    private Short age;
}
