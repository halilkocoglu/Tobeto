package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.entities.Customer;
import com.tobeto.a.spring.intro.entities.PhoneCountryCode;
import com.tobeto.a.spring.intro.services.dtos.customerPhone.requests.AddCustomerPhoneRequest;
import com.tobeto.a.spring.intro.services.dtos.customerPhone.requests.UpdateCustomerPhoneRequest;
import com.tobeto.a.spring.intro.services.dtos.customerPhone.responses.GetCustomerPhoneResponse;

import java.util.List;

public interface CustomerPhoneService {
    void add(AddCustomerPhoneRequest request);
    void update(UpdateCustomerPhoneRequest request);
    void delete(Integer id);
    GetCustomerPhoneResponse getById(Integer id);
    List<GetCustomerPhoneResponse> getAll();
    List<GetCustomerPhoneResponse> getByCustomer(Integer id);
    List<GetCustomerPhoneResponse> getByCountryCode(Integer id);
}
