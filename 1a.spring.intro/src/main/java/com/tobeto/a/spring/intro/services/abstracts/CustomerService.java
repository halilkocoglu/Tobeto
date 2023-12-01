package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.a.spring.intro.services.dtos.customer.requests.UpdateCustomerRequest;
import com.tobeto.a.spring.intro.services.dtos.customer.responses.GetCustomerResponse;

import java.util.List;

public interface CustomerService {
    void add(AddCustomerRequest request);
    void update(UpdateCustomerRequest request);
    void delete(Integer id);
    GetCustomerResponse getById(Integer id);
    List<GetCustomerResponse> getAll();
}
