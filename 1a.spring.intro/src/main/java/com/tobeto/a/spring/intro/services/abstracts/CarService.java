package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.services.dtos.car.requests.AddCarRequest;
import com.tobeto.a.spring.intro.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.a.spring.intro.services.dtos.car.responses.GetAllCarResponse;
import com.tobeto.a.spring.intro.services.dtos.car.responses.GetCarByIdResponse;

import java.util.List;

public interface CarService {
    void add(AddCarRequest request);
    void update(UpdateCarRequest request);
    void delete(Integer id);
    GetCarByIdResponse getById(Integer id);
    List<GetAllCarResponse> getAll();
}
