package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.services.dtos.carInsurances.requests.AddCarInsuranceRequest;
import com.tobeto.a.spring.intro.services.dtos.carInsurances.requests.UpdateCarInsuranceRequest;
import com.tobeto.a.spring.intro.services.dtos.carInsurances.responses.GetAllCarInsurancesResponse;
import com.tobeto.a.spring.intro.services.dtos.carInsurances.responses.GetCarInsuranceByIdResponse;

import java.util.List;

public interface CarInsuranceService {
    void add (AddCarInsuranceRequest request);
    void update(UpdateCarInsuranceRequest request);
    void delete(Integer id);
    GetCarInsuranceByIdResponse getById(Integer id);
    List<GetAllCarInsurancesResponse> getAll();
}
