package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.entities.OptionalExpansion;
import com.tobeto.a.spring.intro.repositories.OptionalExpansionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payments/optional-expansions")
public class OptionalExpansionsController {
    private final OptionalExpansionRepository optionalExpansionRepository;

    public OptionalExpansionsController(OptionalExpansionRepository optionalExpansionRepository) {
        this.optionalExpansionRepository = optionalExpansionRepository;
    }
    @GetMapping
    public List<OptionalExpansion> getAll () {
        return optionalExpansionRepository.findAll();
    }
    @GetMapping("{id}")
    public OptionalExpansion getById(@PathVariable Integer id) {
        return optionalExpansionRepository.findById(id).orElseThrow();
    }
    @PostMapping
    public void addOptionalExpansion (@RequestBody OptionalExpansion optionalExpansion) {
        optionalExpansionRepository.save(optionalExpansion);
    }
    @DeleteMapping("{id}")
    public  void deleteOptionalExpansion (@PathVariable Integer id) {
        OptionalExpansion optionalExpansionToDelete = optionalExpansionRepository.findById(id).orElseThrow();
    }
    @PutMapping("{id}")
    public void updateOptionalExpansion (@RequestBody OptionalExpansion optionalExpansion) {
        OptionalExpansion optionalExpansionToUpdate = optionalExpansionRepository.findById(optionalExpansion.getId()).orElseThrow();
        optionalExpansionToUpdate.setName(optionalExpansion.getName());
        optionalExpansionToUpdate.setPrice(optionalExpansion.getPrice());
        optionalExpansionRepository.save(optionalExpansionToUpdate);
    }
}
