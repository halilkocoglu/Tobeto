package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.CarInsurance;
import com.tobeto.a.spring.intro.repositories.CarInsuranceRepository;
import com.tobeto.a.spring.intro.services.abstracts.CarInsuranceService;
import com.tobeto.a.spring.intro.services.dtos.carInsurances.requests.AddCarInsuranceRequest;
import com.tobeto.a.spring.intro.services.dtos.carInsurances.requests.UpdateCarInsuranceRequest;
import com.tobeto.a.spring.intro.services.dtos.carInsurances.responses.GetCarInsuranceResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CarInsuranceManager implements CarInsuranceService {
    private final CarInsuranceRepository carInsuranceRepository;

    public CarInsuranceManager(CarInsuranceRepository carInsuranceRepository) {
        this.carInsuranceRepository = carInsuranceRepository;
    }

    @Override
    public void add(AddCarInsuranceRequest request) {


        CarInsurance carInsurance = new CarInsurance();
        carInsurance.setExpirationDate(request.getExpirationDate());
        carInsurance.setInsuranceCompany(request.getInsuranceCompanyId());
        carInsurance.setCar(request.getCarId());
        carInsuranceRepository.save(carInsurance);
    }

    @Override
    public void update(UpdateCarInsuranceRequest request) {
        CarInsurance carInsurance = carInsuranceRepository.findById(request.getId()).orElseThrow();
        carInsurance.setCar(request.getCarId());
        carInsurance.setInsuranceCompany(request.getInsuranceCompanyId());
        carInsurance.setExpirationDate(request.getExpirationDate());
        carInsuranceRepository.save(carInsurance);
    }

    @Override
    public void delete(Integer id) {
    CarInsurance carInsurance = carInsuranceRepository.findById(id).orElseThrow();
    carInsuranceRepository.delete(carInsurance);
    }

    @Override
    public GetCarInsuranceResponse getById(Integer id) {
        return carInsuranceRepository.findByID(id);
    }

    @Override
    public List<GetCarInsuranceResponse> getAll() {
       return carInsuranceRepository.findAll()
               .stream()
               .map((carInsurance -> new GetCarInsuranceResponse(carInsurance.getId(),carInsurance.getInsuranceCompany(),carInsurance.getExpirationDate(),carInsurance.getCar()))).toList();

    }

}
