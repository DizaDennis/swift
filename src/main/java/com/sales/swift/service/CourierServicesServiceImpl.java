package com.sales.swift.service;

import com.sales.swift.entities.CourierServices;
import com.sales.swift.repositories.CourierServicesRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourierServicesServiceImpl implements CourierServicesService{

    private  CourierServicesRepo courierServicesRepo;


    public CourierServicesServiceImpl(CourierServicesRepo theCourierServicesRepo){
        courierServicesRepo = theCourierServicesRepo;
    }


    @Override
    public List<CourierServices> findAll() {
        return courierServicesRepo.findAll();
    }

    @Override
    public CourierServices findById(Long theId) {

        Optional<CourierServices> result = courierServicesRepo.findById(theId);

        CourierServices theCourierServices = null;

        if(result.isPresent()){
            theCourierServices = result.get();
        }
        else{
            throw new RuntimeException(theId + "Courier Service Was not found");
        }


        return theCourierServices;
    }

    @Override
    public CourierServices save(CourierServices theCourierServices) {
        return courierServicesRepo.save(theCourierServices);
    }

    @Override
    public void deleteById(Long theId) {
        courierServicesRepo.deleteById(theId);
    }
}
