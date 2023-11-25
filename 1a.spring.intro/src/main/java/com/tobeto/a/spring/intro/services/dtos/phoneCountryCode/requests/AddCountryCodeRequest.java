package com.tobeto.a.spring.intro.services.dtos.phoneCountryCode.requests;

import lombok.Data;

import java.util.PrimitiveIterator;

@Data
public class AddCountryCodeRequest {
    private String name;
    private String code;
}
