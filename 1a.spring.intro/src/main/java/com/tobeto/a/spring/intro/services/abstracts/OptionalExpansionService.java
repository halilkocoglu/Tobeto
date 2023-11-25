package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.services.dtos.optionalExpansions.requests.AddExpansionsRequest;
import com.tobeto.a.spring.intro.services.dtos.optionalExpansions.requests.UpdateExpansionsRequest;

public interface OptionalExpansionService {
    void add(AddExpansionsRequest request);
    void update(UpdateExpansionsRequest request);
    void delete(Integer id);
}
