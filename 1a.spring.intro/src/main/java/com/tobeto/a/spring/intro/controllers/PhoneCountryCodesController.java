package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.entities.PhoneCountryCode;
import com.tobeto.a.spring.intro.repositories.PhoneCountryCodeRepository;
import com.tobeto.a.spring.intro.services.abstracts.PhoneCountryCodeService;
import com.tobeto.a.spring.intro.services.dtos.phoneCountryCode.requests.AddCountryCodeRequest;
import com.tobeto.a.spring.intro.services.dtos.phoneCountryCode.requests.UpdateCountryCodeRequest;
import com.tobeto.a.spring.intro.services.dtos.phoneCountryCode.responses.GetAllCountryCodesResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/phones/country-codes")
public class PhoneCountryCodesController {
    private final PhoneCountryCodeService phoneCountryCodeService;

    public PhoneCountryCodesController(PhoneCountryCodeService phoneCountryCodeService) {
        this.phoneCountryCodeService = phoneCountryCodeService;
    }

    @PostMapping
    public void addPhoneCountryCode (@RequestBody AddCountryCodeRequest request){
        phoneCountryCodeService.add(request);
    }
    @PutMapping("{id}")
    public void updatePhoneCountryCode(@RequestBody UpdateCountryCodeRequest request){
        phoneCountryCodeService.update(request);
    }
    @DeleteMapping("{id}")
    public void deletePhoneCountryCode(@PathVariable Integer id){
        phoneCountryCodeService.delete(id);
    }
    @GetMapping("dto-getByName")
    List<GetAllCountryCodesResponse> getByName(@RequestParam String name){
        return phoneCountryCodeService.getByName(name);
    }
    @GetMapping("dto-orderByCode")
    List<GetAllCountryCodesResponse> orderByCode(){
        return phoneCountryCodeService.orderByCode();
    }
    @GetMapping
    List<GetAllCountryCodesResponse> getAll(){
        return phoneCountryCodeService.getAll();
    }
}
