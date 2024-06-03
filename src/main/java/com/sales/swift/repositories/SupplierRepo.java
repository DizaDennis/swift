package com.sales.swift.repositories;

import com.sales.swift.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepo extends JpaRepository<Supplier,Long> {

}
