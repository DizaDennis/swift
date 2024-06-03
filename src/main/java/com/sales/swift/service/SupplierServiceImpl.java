package com.sales.swift.service;

import com.sales.swift.entities.Supplier;
import com.sales.swift.repositories.SupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class SupplierServiceImpl implements SupplierService {

    private SupplierRepo supplierRepo; //bringing in the repo for the DB lookups

    @Autowired
    public SupplierServiceImpl(SupplierRepo theSupplierRepo){
        supplierRepo = theSupplierRepo;
    }



    @Override
    public List<Supplier> findAll() {
        return supplierRepo.findAll();
    }

    @Override
    public Supplier findById(Long theId) {

        /*
        Using the SupplierRepo to check the DB
        Optional helps in cases where the id/supplier may not be found in the db
         */
        Optional<Supplier> result = supplierRepo.findById(theId);

        Supplier theSupplier = null;

        if(result.isPresent()){

            theSupplier = result.get();
        }
        else{
            throw new RuntimeException(theId + " was not found");
        }


        return theSupplier;
    }

    @Override
    public Supplier save(Supplier supplier) {
        return supplierRepo.save(supplier);
    }

    @Override
    public void deleteById(Long id) {
        supplierRepo.deleteById(id);

    }


}
