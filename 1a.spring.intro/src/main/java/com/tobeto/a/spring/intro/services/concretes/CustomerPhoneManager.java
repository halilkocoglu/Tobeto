package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.CustomerPhone;
import com.tobeto.a.spring.intro.repositories.CustomerPhoneRepository;
import com.tobeto.a.spring.intro.services.abstracts.CustomerPhoneService;
import com.tobeto.a.spring.intro.services.dtos.customerPhone.requests.AddCustomerPhoneRequest;
import com.tobeto.a.spring.intro.services.dtos.customerPhone.requests.UpdateCustomerPhoneRequest;
import com.tobeto.a.spring.intro.services.dtos.customerPhone.responses.GetAllCustomerPhoneResponse;
import com.tobeto.a.spring.intro.services.dtos.customerPhone.responses.GetCustomerPhoneByIdResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerPhoneManager  implements CustomerPhoneService {
    private final CustomerPhoneRepository customerPhoneRepository;

    public CustomerPhoneManager(CustomerPhoneRepository customerPhoneRepository) {
        this.customerPhoneRepository = customerPhoneRepository;
    }

    @Override
    public void add(AddCustomerPhoneRequest request) {
        CustomerPhone customerPhone = new CustomerPhone();
        customerPhone.setCustomer(request.getCustomer());
        customerPhone.setPhoneCountryCode(request.getPhoneCountryCode());
        customerPhone.setPhone(request.getPhone());
        customerPhoneRepository.save(customerPhone);
    }

    @Override
    public void update(UpdateCustomerPhoneRequest request) {
        CustomerPhone customerPhone = customerPhoneRepository.findById(request.getId()).orElseThrow();
        customerPhone.setCustomer(request.getCustomer());
        customerPhone.setPhoneCountryCode(request.getCountryCode());
        customerPhone.setPhone(request.getPhone());
        customerPhoneRepository.save(customerPhone);
    }

    @Override
    public void delete(Integer id) {
        CustomerPhone customerPhone = customerPhoneRepository.findById(id).orElseThrow();
        customerPhoneRepository.delete(customerPhone);
    }

    @Override
    public GetCustomerPhoneByIdResponse getById(Integer id) {
        CustomerPhone customerPhone = customerPhoneRepository.findById(id).orElseThrow();
        GetCustomerPhoneByIdResponse response = new GetCustomerPhoneByIdResponse();
        response.setCustomer(customerPhone.getCustomer());
        response.setPhoneCountryCode(customerPhone.getPhoneCountryCode());
        response.setPhone(customerPhone.getPhone());
        return response;
    }

    @Override
    public List<GetAllCustomerPhoneResponse> getAll() {
        List<CustomerPhone> customerPhoneList = customerPhoneRepository.findAll();
        List<GetAllCustomerPhoneResponse> responseList = new ArrayList<>();
        for (CustomerPhone customerPhone : customerPhoneList) {
            GetAllCustomerPhoneResponse  response = new GetAllCustomerPhoneResponse();
            response.setId(customerPhone.getId());
            response.setCustomer(customerPhone.getCustomer());
            response.setPhoneCountryCode(customerPhone.getPhoneCountryCode());
            response.setPhone(customerPhone.getPhone());
            responseList.add(response);
        }
        return responseList;
    }
}
