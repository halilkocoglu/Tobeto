package com.tobeto.a.spring.intro.services.dtos.customer.requests;

import lombok.Data;

@Data
public class UpdateCustomerRequest {
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private Short age;
    private String password;

}
