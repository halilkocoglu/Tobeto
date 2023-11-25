package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.Payment;
import com.tobeto.a.spring.intro.repositories.PaymentRepository;
import com.tobeto.a.spring.intro.services.abstracts.PaymentService;
import com.tobeto.a.spring.intro.services.dtos.payment.requests.AddPaymentRequest;
import com.tobeto.a.spring.intro.services.dtos.payment.requests.UpdatePaymentRequest;
import org.springframework.stereotype.Service;

@Service
public class PaymentManager implements PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentManager(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void add(AddPaymentRequest request) {
        Payment payment = new Payment();
        payment.setReservation(request.getReservation());
        payment.setAmount(request.getAmount());
        payment.setLastPaymentDate(request.getLastPaymentDate());
        paymentRepository.save(payment);
    }

    @Override
    public void update(UpdatePaymentRequest request) {
        Payment payment = paymentRepository.findById(request.getId()).orElseThrow();
        payment.setReservation(request.getReservation());
        payment.setAmount(request.getAmount());
        payment.setLastPaymentDate(request.getLastPaymentDate());
        paymentRepository.save(payment);
    }

    @Override
    public void delete(Integer id) {
        Payment payment = paymentRepository.findById(id).orElseThrow();
        paymentRepository.delete(payment);
    }
}
