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
}
