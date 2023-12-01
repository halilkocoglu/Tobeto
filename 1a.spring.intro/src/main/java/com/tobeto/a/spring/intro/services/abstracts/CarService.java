package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.services.dtos.car.requests.AddCarRequest;
import com.tobeto.a.spring.intro.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.a.spring.intro.services.dtos.car.responses.GetCarResponse;

import java.util.List;

public interface CarService {
    void add(AddCarRequest request);
    void update(UpdateCarRequest request);
    void delete(Integer id);
    GetCarResponse getById(Integer id);
    List<GetCarResponse> getAll();
    List<GetCarResponse> findByStatus();
    List<GetCarResponse> orderByModelYear();
    List<GetCarResponse> greaterThanPrice(Double price);
}
