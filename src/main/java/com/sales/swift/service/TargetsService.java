package com.sales.swift.service;


import com.sales.swift.entities.Targets;

import java.util.List;

public interface TargetsService {

    List<Targets> findAll();

    Targets findById(Long theId);

    Targets save(Targets theTargets);

    void delete(Long theId);

    Integer getTargetsCount();

    Double getTargetRevenue();

    Integer getTargetCustomers();
}
