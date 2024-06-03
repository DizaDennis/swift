package com.sales.swift.service;

public interface DataService {

    //Used for card data
    long getCustomerCount();
    long getProspectCount();
    long getLeadCount();
    long getCurrentMonthShipments();
    double getCurrentMonthRevenue();

    //Using for chart
    Integer getOvernightData();
    Integer getDocumentData();
    Integer getTenderData();
    Integer getEconomyData();
    Integer getSamedayData();
    Integer getRoadfreightData();

    //Using values to populate the chart
    Double getOvernightValue();
    Double getDocumentValue();
    Double getTenderValue();
    Double getEconomyValue();
    Double getSamedayValue();
    Double getRoadValue();




}
