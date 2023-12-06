package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.Customer;
import com.tobeto.a.spring.intro.entities.CustomerPhone;
import com.tobeto.a.spring.intro.entities.PhoneCountryCode;
import com.tobeto.a.spring.intro.repositories.CustomerPhoneRepository;
import com.tobeto.a.spring.intro.repositories.CustomerRepository;
import com.tobeto.a.spring.intro.repositories.PhoneCountryCodeRepository;
import com.tobeto.a.spring.intro.services.abstracts.CustomerPhoneService;
import com.tobeto.a.spring.intro.services.abstracts.CustomerService;
import com.tobeto.a.spring.intro.services.abstracts.PhoneCountryCodeService;
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
    private  final CustomerService customerService;
    //private final CustomerRepository customerRepository; // Wrong. u can implement only services in service layer or 1 repo own kind
    //private final PhoneCountryCodeService phoneCountryCodeService;
    private final PhoneCountryCodeRepository phoneCountryCodeRepository; //WRONG

    public CustomerPhoneManager(CustomerPhoneRepository customerPhoneRepository, CustomerService customerService, PhoneCountryCodeRepository phoneCountryCodeRepository) {
        this.customerPhoneRepository = customerPhoneRepository;
        this.customerService = customerService;
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
        GetCustomerResponse customer = customerService.getById(id);
        return customerPhoneRepository.findByCustomer(customer);
    }

    @Override
    public List<GetCustomerPhoneResponse> getByCountryCode(Integer id) {
        PhoneCountryCode countryCode = phoneCountryCodeRepository.findById(id).orElseThrow();//Wrong usage
        return customerPhoneRepository.findByCountry(countryCode);
    }
}
