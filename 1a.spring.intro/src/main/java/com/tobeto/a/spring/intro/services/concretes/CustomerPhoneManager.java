package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.Customer;
import com.tobeto.a.spring.intro.entities.CustomerPhone;
import com.tobeto.a.spring.intro.entities.PhoneCountryCode;
import com.tobeto.a.spring.intro.repositories.CustomerPhoneRepository;
import com.tobeto.a.spring.intro.repositories.CustomerRepository;
import com.tobeto.a.spring.intro.repositories.PhoneCountryCodeRepository;
import com.tobeto.a.spring.intro.services.abstracts.CustomerPhoneService;
import com.tobeto.a.spring.intro.services.dtos.customer.responses.GetCustomerResponse;
import com.tobeto.a.spring.intro.services.dtos.customerPhone.requests.AddCustomerPhoneRequest;
import com.tobeto.a.spring.intro.services.dtos.customerPhone.requests.UpdateCustomerPhoneRequest;
import com.tobeto.a.spring.intro.services.dtos.customerPhone.responses.GetCustomerPhoneResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerPhoneManager  implements CustomerPhoneService {
    private final CustomerPhoneRepository customerPhoneRepository;
    private final CustomerRepository customerRepository;
    private final PhoneCountryCodeRepository phoneCountryCodeRepository;

    public CustomerPhoneManager(CustomerPhoneRepository customerPhoneRepository, CustomerRepository customerRepository, PhoneCountryCodeRepository phoneCountryCodeRepository) {
        this.customerPhoneRepository = customerPhoneRepository;
        this.customerRepository = customerRepository;
        this.phoneCountryCodeRepository = phoneCountryCodeRepository;
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
    public GetCustomerPhoneResponse getById(Integer id) {
        CustomerPhone customerPhone = customerPhoneRepository.findById(id).orElseThrow();
        GetCustomerPhoneResponse response = new GetCustomerPhoneResponse();
        response.setCustomer(customerPhone.getCustomer());
        response.setPhoneCountryCode(customerPhone.getPhoneCountryCode());
        response.setPhone(customerPhone.getPhone());
        return response;
    }

    @Override
    public List<GetCustomerPhoneResponse> getAll() {
        List<CustomerPhone> customerPhoneList = customerPhoneRepository.findAll();
        List<GetCustomerPhoneResponse> responseList = new ArrayList<>();
        for (CustomerPhone customerPhone : customerPhoneList) {
            GetCustomerPhoneResponse response = new GetCustomerPhoneResponse();
            response.setId(customerPhone.getId());
            response.setCustomer(customerPhone.getCustomer());
            response.setPhoneCountryCode(customerPhone.getPhoneCountryCode());
            response.setPhone(customerPhone.getPhone());
            responseList.add(response);
        }
        return responseList;
    }

    @Override
    public List<GetCustomerPhoneResponse> getByCustomer(Integer id) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        return customerPhoneRepository.findByCustomer(customer);
    }

    @Override
    public List<GetCustomerPhoneResponse> getByCountryCode(Integer id) {
        PhoneCountryCode countryCode = phoneCountryCodeRepository.findById(id).orElseThrow();
        return customerPhoneRepository.findByCountry(countryCode);
    }
}
