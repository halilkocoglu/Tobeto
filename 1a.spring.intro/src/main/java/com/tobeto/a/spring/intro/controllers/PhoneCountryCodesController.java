package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.entities.PhoneCountryCode;
import com.tobeto.a.spring.intro.repositories.PhoneCountryCodeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/phones/country-codes")
public class PhoneCountryCodesController {
    private final PhoneCountryCodeRepository phoneCountryCodeRepository;

    public PhoneCountryCodesController(PhoneCountryCodeRepository phoneCountryCodeRepository) {
        this.phoneCountryCodeRepository = phoneCountryCodeRepository;
    }
    @GetMapping
    public List<PhoneCountryCode> getAll () {
        return phoneCountryCodeRepository.findAll();
    }
    @GetMapping("{id}")
    public PhoneCountryCode getById (@PathVariable Integer id) {
        return  phoneCountryCodeRepository.findById(id).orElseThrow();
    }
    @PostMapping
    public void addPhoneCountryCode (@RequestBody PhoneCountryCode phoneCountryCode){
        phoneCountryCodeRepository.save(phoneCountryCode);
    }
    @DeleteMapping("{id}")
    public void deletePhoneCountryCode(@PathVariable Integer id){
        PhoneCountryCode phoneCountryCodeToDelete = phoneCountryCodeRepository.findById(id).orElseThrow();
        phoneCountryCodeRepository.delete(phoneCountryCodeToDelete);
    }
    @PutMapping("{id}")
    public void updatePhoneCountryCode(@RequestBody PhoneCountryCode phoneCountryCode){
        PhoneCountryCode phoneCountryCodeToUpdate = phoneCountryCodeRepository.findById(phoneCountryCode.getId()).orElseThrow();
        phoneCountryCodeToUpdate.setName(phoneCountryCode.getName());
        phoneCountryCodeToUpdate.setCode(phoneCountryCode.getCode());
        phoneCountryCodeRepository.save(phoneCountryCodeToUpdate);
    }
}
