package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.services.abstracts.OptionalExpansionService;
import com.tobeto.a.spring.intro.services.dtos.optionalExpansions.requests.AddExpansionsRequest;
import com.tobeto.a.spring.intro.services.dtos.optionalExpansions.requests.UpdateExpansionsRequest;
import com.tobeto.a.spring.intro.services.dtos.optionalExpansions.responses.GetAllExpansionsResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payments/optional-expansions")
public class OptionalExpansionsController {
    private final OptionalExpansionService optionalExpansionService;

    public OptionalExpansionsController(OptionalExpansionService optionalExpansionService) {
        this.optionalExpansionService = optionalExpansionService;
    }

    @PostMapping
    public void addOptionalExpansion (@RequestBody AddExpansionsRequest request) {
        optionalExpansionService.add(request);
    }
    @PutMapping("{id}")
    public void updateOptionalExpansion (@RequestBody UpdateExpansionsRequest request) {
        optionalExpansionService.update(request);
    }
    @DeleteMapping("{id}")
    public  void deleteOptionalExpansion (@PathVariable Integer id) {
        optionalExpansionService.delete(id);
    }
    @GetMapping("dto-getName")
    public List<GetAllExpansionsResponse> getByName(@RequestParam String name){
        return optionalExpansionService.getByName(name);
    }
    @GetMapping("dto-orderByPrice")
    public List<GetAllExpansionsResponse> orderByPrice(){
        return optionalExpansionService.getByPriceOrderBy();
    }
}
