package com.sales.swift.service;

import com.sales.swift.entities.Targets;
import com.sales.swift.repositories.TargetsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TargetsServiceImpl implements TargetsService{

    @Autowired
    private TargetsRepo theTargetsRepo;

    public TargetsServiceImpl(TargetsRepo theTargetsRepo) {
        theTargetsRepo = theTargetsRepo;
    }


    @Override
    public List<Targets> findAll() {
        return theTargetsRepo.findAll();
    }

    @Override
    public Targets findById(Long theId) {
        Optional<Targets> result = theTargetsRepo.findById(theId);

        Targets theTargets = null;

        if(result.isPresent()){

            theTargets = result.get();

        }
        else {
            throw new RuntimeException(theId + " was not found");
        }

        return theTargets;
    }

    @Override
    public Targets save(Targets theTargets) {
        return theTargetsRepo.save(theTargets);
    }

    @Override
    public void delete(Long theId) {
        theTargetsRepo.deleteById(theId);
    }

    @Override
    public Integer getTargetsCount() {
        return theTargetsRepo.getTotalShipments();
    }

    @Override
    public Double getTargetRevenue() {
        return theTargetsRepo.getTargetRevenue();
    }

    @Override
    public Integer getTargetCustomers() {
        return theTargetsRepo.getTargetCustomers();
    }


}
