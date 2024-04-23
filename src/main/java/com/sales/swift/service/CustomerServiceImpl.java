package com.sales.swift.service;


import com.sales.swift.entities.Customer;
import com.sales.swift.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepo customerRepo;

    /*
    This constructor uses @Autowired to automatically create an instance of CustomerRepo, when creating an instance of CustomerServiceImpl
     */
    @Autowired
    public CustomerServiceImpl(CustomerRepo theCustomerRepo){
        customerRepo = theCustomerRepo;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepo.findAllByOrderByCompanyNameAsc();
    }

    @Override
    public Customer findById(Long theId) {
        /*
        Leveraging the customer repo to query the DB
        Optional for cases where the customer isn't found
        result if used as a flag of sort to indicate if the customer is there 'is.present()' or not
         */
        Optional<Customer> result = customerRepo.findById(theId);
        /*
        If statement to look for theCustomer in the db
         */
        Customer theCustomer = null;

        if(result.isPresent()){
            theCustomer = result.get();
        }
        else{
            throw new RuntimeException(theId+ " was not found");
        }

        return theCustomer;
    }

    @Override
    public Customer save(Customer theCustomer) {
        return customerRepo.save(theCustomer);
    }

    @Override
    public void deleteById(Long theId) {
        customerRepo.deleteById(theId);
    }
}
