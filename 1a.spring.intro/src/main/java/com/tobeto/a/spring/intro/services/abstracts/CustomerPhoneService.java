package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.services.dtos.customerPhone.requests.AddCustomerPhoneRequest;
import com.tobeto.a.spring.intro.services.dtos.customerPhone.requests.UpdateCustomerPhoneRequest;
import com.tobeto.a.spring.intro.services.dtos.customerPhone.responses.GetAllCustomerPhoneResponse;
import com.tobeto.a.spring.intro.services.dtos.customerPhone.responses.GetCustomerPhoneByIdResponse;

import java.util.List;

public interface CustomerPhoneService {
    void add(AddCustomerPhoneRequest request);
    void update(UpdateCustomerPhoneRequest request);
    void delete(Integer id);
    GetCustomerPhoneByIdResponse getById(Integer id);
    List<GetAllCustomerPhoneResponse> getAll();
}
