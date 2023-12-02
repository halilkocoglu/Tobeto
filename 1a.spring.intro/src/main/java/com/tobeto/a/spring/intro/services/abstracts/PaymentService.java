package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.services.dtos.payment.requests.AddPaymentRequest;
import com.tobeto.a.spring.intro.services.dtos.payment.requests.UpdatePaymentRequest;
import com.tobeto.a.spring.intro.services.dtos.payment.responses.GetAllPaymentsResponses;
import com.tobeto.a.spring.intro.services.dtos.payment.responses.GetPaymentResponse;

import java.util.List;

public interface PaymentService {
    void add(AddPaymentRequest request);
    void update(UpdatePaymentRequest request);
    void delete(Integer id);
    GetPaymentResponse getByReservationId(Integer id);
    List<GetAllPaymentsResponses> getAll();
}
