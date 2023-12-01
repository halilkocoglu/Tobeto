package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.Customer;
import com.tobeto.a.spring.intro.entities.CustomerPhone;
import com.tobeto.a.spring.intro.entities.PhoneCountryCode;
import com.tobeto.a.spring.intro.services.dtos.customer.responses.GetCustomerResponse;
import com.tobeto.a.spring.intro.services.dtos.customerPhone.responses.GetCustomerPhoneResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerPhoneRepository extends JpaRepository<CustomerPhone, Integer> {
    @Query("SELECT new com.tobeto.a.spring.intro.services.dtos.customerPhone.responses.GetCustomerPhoneResponse"
            + "(c.id, c.customer, c.phoneCountryCode, c.phone)"
            + "FROM CustomerPhone c WHERE c.phoneCountryCode = :countryCode")
    List<GetCustomerPhoneResponse> findByCountry(PhoneCountryCode countryCode);
    @Query("SELECT new com.tobeto.a.spring.intro.services.dtos.customerPhone.responses.GetCustomerPhoneResponse"
            + "(cp.id, cp.customer, cp.phoneCountryCode, cp.phone)"
            + "FROM CustomerPhone cp "
            + "WHERE cp.customer = :customer")
    List<GetCustomerPhoneResponse> findByCustomer(Customer customer);
}
