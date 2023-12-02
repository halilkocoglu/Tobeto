package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.PhoneCountryCode;
import com.tobeto.a.spring.intro.repositories.PhoneCountryCodeRepository;
import com.tobeto.a.spring.intro.services.abstracts.PhoneCountryCodeService;
import com.tobeto.a.spring.intro.services.dtos.phoneCountryCode.requests.AddCountryCodeRequest;
import com.tobeto.a.spring.intro.services.dtos.phoneCountryCode.requests.UpdateCountryCodeRequest;
import com.tobeto.a.spring.intro.services.dtos.phoneCountryCode.responses.GetAllCountryCodesResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<GetAllCountryCodesResponse> getByName(String name) {
        List<PhoneCountryCode> countryCodeList = phoneCountryCodeRepository.findByNameStartingWith(name);
        List<GetAllCountryCodesResponse> responseList = new ArrayList<>();
        for (PhoneCountryCode code:countryCodeList) {
            GetAllCountryCodesResponse response = new GetAllCountryCodesResponse();
            response.setId(code.getId());
            response.setName(code.getName());
            response.setCode(code.getCode());
            responseList.add(response);
        }
        return responseList;
    }

    @Override
    public List<GetAllCountryCodesResponse> orderByCode() {
        return phoneCountryCodeRepository.orderByCode();
    }

    @Override
    public List<GetAllCountryCodesResponse> getAll() {
        return phoneCountryCodeRepository.findAllCodes();
    }
}
