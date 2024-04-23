package com.sales.swift.service;

import com.sales.swift.entities.Prospect;
import com.sales.swift.repositories.ProspectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * ProspectServiceImpl does the work "business logic"
 * It implements Prospect Service which has the basic findAll, findById ,save and delete methods
 * @author dennisdiza
 */

@Service
public class ProspectServiceImpl implements ProspectService{

private ProspectRepo prospectRepo;

@Autowired
public ProspectServiceImpl(ProspectRepo theProspectRepo){
    prospectRepo = theProspectRepo;
}
 @Override
 public List<Prospect> findAll() {
        return prospectRepo.findAllByOrderByCompanyNameAsc(); //custom method created in the repo
    }

    @Override
    public Prospect findById(Long theId) {
    Optional<Prospect> result = prospectRepo.findById(theId);

        Prospect theProspect = null;

        if(result.isPresent()){

            theProspect = result.get();
        }
        else {
            //this is if we don't find the prospect
            throw new RuntimeException(theId + " was not found");
        }

        return theProspect;
    }

    @Override
    public Prospect save(Prospect theProspect) {
        return prospectRepo.save(theProspect);
    }

    @Override
    public void deleteById(Long theId) {
    prospectRepo.deleteById(theId);

    }
}
