package com.tobeto.a.spring.intro.services.dtos.phoneCountryCode.responses;

import lombok.Data;

@Data
public class GetAllCountryCodesResponse {
    private Integer id;
    private String name;
    private String code;
}
