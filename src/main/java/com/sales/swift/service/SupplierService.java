package com.sales.swift.service;

import com.sales.swift.entities.Supplier;

import java.util.List;

public interface SupplierService {


    List<Supplier> findAll();
    Supplier findById(Long id);
    Supplier save(Supplier supplier);
    void deleteById(Long id);


}
