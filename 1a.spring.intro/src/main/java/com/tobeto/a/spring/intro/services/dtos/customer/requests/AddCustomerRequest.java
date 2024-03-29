package com.tobeto.a.spring.intro.services.dtos.customer.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddCustomerRequest {
    private String firstname;
    private String lastname;
    private String email;
    private Short age;
    private String password;
}
