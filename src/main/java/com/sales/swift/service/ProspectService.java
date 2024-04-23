package com.sales.swift.service;

import com.sales.swift.entities.Prospect;

import java.util.List;

/**
 * Prospect interface defining methods required by the business logic
 * @author dennisdiza
 */

public interface ProspectService {

    List<Prospect> findAll();

    Prospect findById(Long theId);

    Prospect save(Prospect theProspect);

    void deleteById(Long theId);
}
