package com.sales.swift.repositories;

import com.sales.swift.entities.Leads;

import com.sales.swift.entities.Leads;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeadsRepo extends JpaRepository<Leads, Long> {

    List<Leads> findAllByOrderByCompanyNameAsc();
}
