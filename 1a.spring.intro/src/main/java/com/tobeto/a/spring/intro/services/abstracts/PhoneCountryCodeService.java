package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.services.dtos.phoneCountryCode.requests.AddCountryCodeRequest;
import com.tobeto.a.spring.intro.services.dtos.phoneCountryCode.requests.UpdateCountryCodeRequest;

public interface PhoneCountryCodeService {
    void add(AddCountryCodeRequest request);
    void update(UpdateCountryCodeRequest request);
    void  delete(Integer id);
}
