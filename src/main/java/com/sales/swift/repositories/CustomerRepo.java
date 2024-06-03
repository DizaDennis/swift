package com.sales.swift.repositories;

import com.sales.swift.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Customer Repo to interact with the DB and pull a list of customers in ascending order
 */


public interface CustomerRepo extends JpaRepository<Customer, Long > {

    List<Customer>findAllByOrderByCompanyNameAsc();

    @Query("SELECT SUM(c.currentMonthShipments) FROM Customer c")
    long getCurrentMonthShipments();

    @Query("SELECT SUM(r.currentInvoiceValue) FROM Customer r")
    double getCurrentInvoiceValue();

    //Queries for chart volumes
    @Query("SELECT SUM(o.overnightVolume) FROM CourierServices o")
    Integer getOvernightData();

    @Query("SELECT SUM(e.economyVolume) FROM CourierServices e")
    Integer getEconomyData();

    @Query("SELECT SUM(d.documentVolume) FROM CourierServices d")
    Integer getDocumentData();

    @Query("SELECT SUM(t.tenderVolume) FROM CourierServices  t")
    Integer getTenderData();

    @Query("SELECT SUM(a.roadVolume) FROM CourierServices a")
    Integer getRoadData();

    @Query("SELECT SUM(s.sameDayVolume) FROM CourierServices s")
    Integer getSameDayData();

    //Queries for chart values by service
    @Query("SELECT SUM(o.overnightValue) FROM CourierServices o")
    Double getOvernightValue();

    @Query("SELECT SUM(e.economyValue) FROM CourierServices e")
    Double getEconomyValue();

    @Query("SELECT SUM(d.documentValue) FROM CourierServices d")
    Double getDocumentValue();

    @Query("SELECT SUM(t.tenderValue) FROM CourierServices t")
    Double getTenderValue();

    @Query("SELECT SUM(a.roadValue) FROM CourierServices a")
    Double getRoadValue();

    @Query("SELECT SUM(s.sameDayValue) FROM CourierServices s")
    Double getSameDayValue();

}
