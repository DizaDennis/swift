package com.sales.swift.service;

import com.sales.swift.entities.CourierServices;

import java.util.List;

public interface CourierServicesService {

    List<CourierServices> findAll();

    CourierServices findById(Long theId);

    CourierServices save(CourierServices theCourierServices);

    void deleteById(Long theId);
}
