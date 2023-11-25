package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.OptionalExpansion;
import com.tobeto.a.spring.intro.repositories.OptionalExpansionRepository;
import com.tobeto.a.spring.intro.services.abstracts.OptionalExpansionService;
import com.tobeto.a.spring.intro.services.dtos.optionalExpansions.requests.AddExpansionsRequest;
import com.tobeto.a.spring.intro.services.dtos.optionalExpansions.requests.UpdateExpansionsRequest;
import org.springframework.stereotype.Service;

@Service
public class OptionalExpansionManager  implements OptionalExpansionService {
    private final OptionalExpansionRepository optionalExpansionRepository;
    public OptionalExpansionManager(OptionalExpansionRepository optionalExpansionRepository) {
        this.optionalExpansionRepository = optionalExpansionRepository;
    }

    @Override
    public void add(AddExpansionsRequest request) {
        OptionalExpansion optionalExpansion = new OptionalExpansion();
        optionalExpansion.setName(request.getName());
        optionalExpansion.setPrice(request.getPrice());
        optionalExpansionRepository.save(optionalExpansion);
    }

    @Override
    public void update(UpdateExpansionsRequest request) {
        OptionalExpansion optionalExpansion = optionalExpansionRepository.findById(request.getId()).orElseThrow();
        optionalExpansion.setName(request.getName());
        optionalExpansion.setPrice(request.getPrice());
        optionalExpansionRepository.save(optionalExpansion);
    }

    @Override
    public void delete(Integer id) {
        OptionalExpansion optionalExpansion = optionalExpansionRepository.findById(id).orElseThrow();
        optionalExpansionRepository.delete(optionalExpansion);
    }
}
