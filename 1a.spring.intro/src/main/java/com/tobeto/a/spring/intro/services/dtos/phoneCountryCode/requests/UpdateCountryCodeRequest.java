package com.tobeto.a.spring.intro.services.dtos.phoneCountryCode.requests;

import lombok.Data;

@Data
public class UpdateCountryCodeRequest {
    private Integer id;
    private String name;
    private String code;
}
