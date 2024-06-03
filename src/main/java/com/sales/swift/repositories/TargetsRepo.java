package com.sales.swift.repositories;

import com.sales.swift.entities.Targets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TargetsRepo extends JpaRepository<Targets, Long> {
/*
    @Query("SELECT SUM(c.currentMonthShipments) FROM Customer c")
    long getCurrentMonthShipments();

 */

    @Query("SELECT SUM(t.targetShipments) FROM Targets t")
    Integer getTotalShipments();

    @Query("SELECT SUM(r.targetRevenue) FROM Targets r")
    Double getTargetRevenue();

    @Query("SELECT SUM(n.newCustomers) FROM Targets n")
    Integer getTargetCustomers();


}
