package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.Customer;
import com.tobeto.a.spring.intro.repositories.CustomerRepository;
import com.tobeto.a.spring.intro.services.abstracts.CustomerService;
import com.tobeto.a.spring.intro.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.a.spring.intro.services.dtos.customer.requests.UpdateCustomerRequest;
import com.tobeto.a.spring.intro.services.dtos.customer.responses.GetAllCustomerResponse;
import com.tobeto.a.spring.intro.services.dtos.customer.responses.GetCustomerByIdResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerManager implements CustomerService {
    private  final CustomerRepository customerRepository;

    public CustomerManager(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void add(AddCustomerRequest request) {
        Customer customer = new Customer();
        customer.setFirstname(request.getFirstname());
        customer.setLastname(request.getLastname());
        customer.setEmail(request.getEmail());
        customer.setAge(request.getAge());
        customerRepository.save(customer);
    }

    @Override
    public void update(UpdateCustomerRequest request) {
        Customer customer = customerRepository.findById(request.getId()).orElseThrow();
        customer.setFirstname(request.getFirstname());
        customer.setLastname(request.getLastname());
        customer.setEmail(request.getEmail());
        customer.setAge(request.getAge());
        customerRepository.save(customer);
    }

    @Override
    public void delete(Integer id) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        customerRepository.delete(customer);
    }

    @Override
    public GetCustomerByIdResponse getById(Integer id) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        GetCustomerByIdResponse response = new GetCustomerByIdResponse();
        response.setFirstname(customer.getFirstname());
        response.setLastname(customer.getLastname());
        response.setEmail(customer.getEmail());
        response.setAge(customer.getAge());
        return response;
    }

    @Override
    public List<GetAllCustomerResponse> getAll() {
        List<Customer> customerList = customerRepository.findAll();
        List<GetAllCustomerResponse> responseList = new ArrayList<>();
        for (Customer customer : customerList) {
            GetAllCustomerResponse response = new GetAllCustomerResponse();
            response.setId(customer.getId());
            response.setFirstname(customer.getFirstname());
            response.setLastname(customer.getLastname());
            response.setEmail(customer.getEmail());
            response.setAge(customer.getAge());
            responseList.add(response);
        }
        return responseList;
    }
}
