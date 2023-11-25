package com.tobeto.a.spring.intro.services.dtos.customer.responses;

import lombok.Data;

@Data
public class GetAllCustomerResponse {
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private Short age;
}
