package com.sales.swift.service;

import com.sales.swift.entities.Leads;

import com.sales.swift.repositories.LeadsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeadsServiceImpl implements LeadsService {

    private LeadsRepo leadsRepo;

    @Autowired
    public LeadsServiceImpl(LeadsRepo theLeadsRepo) {
        leadsRepo = theLeadsRepo;
    }

    @Override
    public List<Leads> findAll() {
        return leadsRepo.findAllByOrderByCompanyNameAsc();
    }

    @Override
    public Leads findById(Long theId) {

        Optional<Leads> result = leadsRepo.findById(theId);

        Leads theLeads = null;

        if(result.isPresent()){

            theLeads = result.get();
        }
        else{
            throw new RuntimeException(theId+ " Lead not found");
        }

        return theLeads;
    }

    @Override
    public Leads save(Leads theLeads) {
        return leadsRepo.save(theLeads);
    }

    @Override
    public void deleteById(Long theId) {
    leadsRepo.deleteById(theId);
    }
}
