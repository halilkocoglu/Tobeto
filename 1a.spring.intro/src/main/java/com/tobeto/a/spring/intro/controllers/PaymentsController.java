package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.entities.Payment;
import com.tobeto.a.spring.intro.repositories.PaymentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payments")
public class PaymentsController {
    private final PaymentRepository paymentRepository;

    public PaymentsController(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }
    @GetMapping
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }
    @GetMapping("{id}")
    public Payment getById (@PathVariable Integer id) {
        return paymentRepository.findById(id).orElseThrow();
    }
    @PostMapping
    public void addPayment(@RequestBody Payment payment) {
        paymentRepository.save(payment);
    }
    @DeleteMapping("{id}")
    public void deletePayment (@PathVariable Integer id){
        Payment paymentToDelete = paymentRepository.findById(id).orElseThrow();
        paymentRepository.delete(paymentToDelete);
    }
    @PutMapping("{id}")
    public void updatePayment (@RequestBody Payment payment){
        Payment paymentToUpdate = paymentRepository.findById(payment.getId()).orElseThrow();
        paymentToUpdate.setReservation(payment.getReservation());
        paymentToUpdate.setAmount(payment.getAmount());
        paymentToUpdate.setLastPaymentDate(payment.getLastPaymentDate());
        paymentRepository.save(paymentToUpdate);
    }
}
