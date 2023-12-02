package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.Customer;
import com.tobeto.a.spring.intro.services.dtos.customer.responses.GetCustomerResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByAgeGreaterThan(Short age);
    @Query("SELECT new com.tobeto.a.spring.intro.services.dtos.customer.responses.GetCustomerResponse"
            + "(c.id, c.firstname, c.lastname, c.email, c.age)"
            + "FROM Customer c WHERE c.age > 18")
    List<GetCustomerResponse> findAdultCustomer();
}
