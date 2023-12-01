package com.tobeto.a.spring.intro.services.dtos.customer.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomerResponse {
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private Short age;
}
