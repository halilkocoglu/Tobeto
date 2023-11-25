package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.PhoneCountryCode;
import com.tobeto.a.spring.intro.repositories.PhoneCountryCodeRepository;
import com.tobeto.a.spring.intro.services.abstracts.PhoneCountryCodeService;
import com.tobeto.a.spring.intro.services.dtos.phoneCountryCode.requests.AddCountryCodeRequest;
import com.tobeto.a.spring.intro.services.dtos.phoneCountryCode.requests.UpdateCountryCodeRequest;
import org.springframework.stereotype.Service;

@Service
public class PhoneCountryCodeManager implements PhoneCountryCodeService {
    private final PhoneCountryCodeRepository phoneCountryCodeRepository;

    public PhoneCountryCodeManager(PhoneCountryCodeRepository phoneCountryCodeRepository) {
        this.phoneCountryCodeRepository = phoneCountryCodeRepository;
    }

    @Override
    public void add(AddCountryCodeRequest request) {
        PhoneCountryCode countryCode = new PhoneCountryCode();
        countryCode.setName(request.getName());
        countryCode.setCode(request.getCode());
        phoneCountryCodeRepository.save(countryCode);
    }

    @Override
    public void update(UpdateCountryCodeRequest request) {
        PhoneCountryCode countryCode = phoneCountryCodeRepository.findById(request.getId()).orElseThrow();
        countryCode.setName(request.getName());
        countryCode.setCode(request.getCode());
        phoneCountryCodeRepository.save(countryCode);
    }

    @Override
    public void delete(Integer id) {
        PhoneCountryCode countryCode = phoneCountryCodeRepository.findById(id).orElseThrow();
        phoneCountryCodeRepository.delete(countryCode);
    }
}
