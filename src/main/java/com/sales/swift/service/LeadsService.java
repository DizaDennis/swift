package com.sales.swift.service;

import com.sales.swift.entities.Leads;

import java.util.List;

public interface LeadsService {

    List<Leads> findAll();
    Leads findById(Long id);
    Leads save(Leads theLeads);

    void deleteById(Long theId);
}
