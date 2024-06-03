package com.sales.swift.service;


import com.sales.swift.entities.CardData;
import com.sales.swift.repositories.CardDataRepo;
import com.sales.swift.repositories.CustomerRepo;
import com.sales.swift.repositories.LeadsRepo;
import com.sales.swift.repositories.ProspectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataServiceImpl implements DataService{


    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ProspectRepo prospectRepo;

    @Autowired
    private LeadsRepo leadsRepo;





    @Override
    public long getCustomerCount() {
        return customerRepo.count();
    }

    @Override
    public long getProspectCount() {
        return prospectRepo.count();
    }

    @Override
    public long getLeadCount() {
        return leadsRepo.count();
    }

    @Override
    public long getCurrentMonthShipments() {
        return customerRepo.getCurrentMonthShipments();
    }

    @Override
    public double getCurrentMonthRevenue() {
        return customerRepo.getCurrentInvoiceValue();
    }

    @Override
    public Integer getOvernightData() {
        return customerRepo.getOvernightData();
    }

    @Override
    public Integer getDocumentData() {
        return customerRepo.getDocumentData();
    }

    @Override
    public Integer getTenderData() {
        return customerRepo.getTenderData();
    }

    @Override
    public Integer getEconomyData() {
        return customerRepo.getEconomyData();
    }

    @Override
    public Integer getSamedayData() {
        return customerRepo.getSameDayData();
    }

    @Override
    public Integer getRoadfreightData() {
        return customerRepo.getRoadData();
    }

    @Override
    public Double getOvernightValue() {
        return customerRepo.getOvernightValue();
    }

    @Override
    public Double getDocumentValue() {
        return customerRepo.getDocumentValue();
    }

    @Override
    public Double getTenderValue() {
        return customerRepo.getTenderValue();
    }

    @Override
    public Double getEconomyValue() {
        return customerRepo.getEconomyValue();
    }

    @Override
    public Double getSamedayValue() {
        return customerRepo.getSameDayValue();
    }

    @Override
    public Double getRoadValue() {
        return customerRepo.getRoadValue();
    }
}
