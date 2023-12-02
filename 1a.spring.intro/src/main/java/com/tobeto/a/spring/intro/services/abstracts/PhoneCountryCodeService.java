package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.services.dtos.phoneCountryCode.requests.AddCountryCodeRequest;
import com.tobeto.a.spring.intro.services.dtos.phoneCountryCode.requests.UpdateCountryCodeRequest;
import com.tobeto.a.spring.intro.services.dtos.phoneCountryCode.responses.GetAllCountryCodesResponse;

import java.util.List;

public interface PhoneCountryCodeService {
    void add(AddCountryCodeRequest request);
    void update(UpdateCountryCodeRequest request);
    void  delete(Integer id);
    List<GetAllCountryCodesResponse> getByName(String name);
    List<GetAllCountryCodesResponse> orderByCode();
    List<GetAllCountryCodesResponse> getAll();
}
