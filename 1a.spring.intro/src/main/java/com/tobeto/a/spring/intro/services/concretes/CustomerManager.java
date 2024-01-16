package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.Customer;
import com.tobeto.a.spring.intro.repositories.CustomerRepository;
import com.tobeto.a.spring.intro.services.abstracts.CustomerService;
import com.tobeto.a.spring.intro.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.a.spring.intro.services.dtos.customer.requests.UpdateCustomerRequest;
import com.tobeto.a.spring.intro.services.dtos.customer.responses.GetCustomerResponse;
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
        customer.setPassword(request.getPassword());
        customerRepository.save(customer);
    }

    @Override
    public void update(UpdateCustomerRequest request) {
        Customer customer = customerRepository.findById(request.getId()).orElseThrow();
        customer.setFirstname(request.getFirstname());
        customer.setLastname(request.getLastname());
        customer.setEmail(request.getEmail());
        customer.setAge(request.getAge());
        customer.setPassword(request.getPassword());
        customerRepository.save(customer);
    }

    @Override
    public void delete(Integer id) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        customerRepository.delete(customer);
    }

    @Override
    public GetCustomerResponse getById(Integer id) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        GetCustomerResponse response = new GetCustomerResponse();
        response.setId(customer.getId());
        response.setFirstname(customer.getFirstname());
        response.setLastname(customer.getLastname());
        response.setEmail(customer.getEmail());
        response.setAge(customer.getAge());
        return response;
    }

    @Override
    public GetCustomerResponse getByEmail(String email) {
        Customer customer = customerRepository.findByEmail(email).orElseThrow();
        GetCustomerResponse response = new GetCustomerResponse();
        response.setId(customer.getId());
        response.setFirstname(customer.getFirstname());
        response.setLastname(customer.getLastname());
        response.setEmail(customer.getEmail());
        response.setAge(customer.getAge());
        return response;
    }

    @Override
    public List<GetCustomerResponse> getAll() {
        List<Customer> customerList = customerRepository.findAll();
        List<GetCustomerResponse> responseList = new ArrayList<>();
        for (Customer customer : customerList) {
            GetCustomerResponse response = new GetCustomerResponse();
            response.setId(customer.getId());
            response.setFirstname(customer.getFirstname());
            response.setLastname(customer.getLastname());
            response.setEmail(customer.getEmail());
            response.setAge(customer.getAge());
            responseList.add(response);
        }
        return responseList;
    }

    @Override
    public List<GetCustomerResponse> getByAgeGreaterThan(Short age) {
        List<Customer> customerList = customerRepository.findByAgeGreaterThan(age);
        List<GetCustomerResponse> responseList = new ArrayList<>();
        for (Customer c: customerList) {
            GetCustomerResponse response = new GetCustomerResponse();
            response.setId(c.getId());
            response.setFirstname(c.getFirstname());
            response.setLastname(c.getLastname());
            response.setAge(c.getAge());
            responseList.add(response);
        }
        return responseList;
    }

    @Override
    public List<GetCustomerResponse> getAdultCustomers() {
        return customerRepository.findAdultCustomer();
    }
}
