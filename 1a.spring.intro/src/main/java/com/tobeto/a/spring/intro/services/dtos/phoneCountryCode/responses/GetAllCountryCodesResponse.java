package com.tobeto.a.spring.intro.services.dtos.phoneCountryCode.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCountryCodesResponse {
    private Integer id;
    private String name;
    private String code;
}
