package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.entities.Payment;
import com.tobeto.a.spring.intro.repositories.PaymentRepository;
import com.tobeto.a.spring.intro.services.abstracts.PaymentService;
import com.tobeto.a.spring.intro.services.dtos.payment.requests.AddPaymentRequest;
import com.tobeto.a.spring.intro.services.dtos.payment.requests.UpdatePaymentRequest;
import com.tobeto.a.spring.intro.services.dtos.payment.responses.GetAllPaymentsResponses;
import com.tobeto.a.spring.intro.services.dtos.payment.responses.GetPaymentResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payments")
public class PaymentsController {
    private final PaymentService paymentService;

    public PaymentsController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public void addPayment(@RequestBody AddPaymentRequest request) {
        paymentService.add(request);
    }
    @DeleteMapping("{id}")
    public void deletePayment (@PathVariable Integer id){
        paymentService.delete(id);
    }
    @PutMapping("{id}")
    public void updatePayment (@RequestBody UpdatePaymentRequest request){
        paymentService.update(request);
    }
    @GetMapping("dto-getBy-reservation-id")
    GetPaymentResponse getByReservationId(@RequestParam Integer id){
        return  paymentService.getByReservationId(id);
    }
    @GetMapping
    List<GetAllPaymentsResponses> getAll(){
        return paymentService.getAll();
    }
}
