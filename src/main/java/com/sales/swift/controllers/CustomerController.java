package com.sales.swift.controllers;

import com.sales.swift.entities.Customer;
import com.sales.swift.entities.Targets;
import com.sales.swift.service.CustomerService;
import com.sales.swift.service.TargetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;
    private TargetsService targetsService;

    @Autowired //Optional because there's only 1 constructor
    public CustomerController(CustomerService theCustomerService, TargetsService theTargetsService) {
        customerService = theCustomerService;
        targetsService = theTargetsService;
    }

    @GetMapping("/list")
    public String listCustomers(Model theModel){
        //pull the list of customers from the DB
        List<Customer> theCustomer = customerService.findAll();

        //adding the list of customers to the model
        theModel.addAttribute("customer",theCustomer);


        List<Targets> theTargets = targetsService.findAll();

        theModel.addAttribute("targets",theTargets);

        return "customers/customer-list";
    }

    //mapping to show the form to add a customer
    @GetMapping("/newCustomerForm")
    public String newCustomerForm(Model theModel){
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer", theCustomer);

        return "customers/addCustomer-form";
    }


    /*
    Code to update the customer -> same approach as updating a prospect
     customerId is brought in by (customerId=${tempCustomer.id}) in the frontend
     @RequestParam takes in customerId and uses it to search the DB
     */
    @GetMapping("/updateCustomer")
    public String updateCustomer(@RequestParam("customerId")Long theId, Model theModel){

        //this will use customerService to search the DB
        Customer theCustomer = customerService.findById(theId);

        //Setting the model to prepopulate the customer form
        theModel.addAttribute("customer",theCustomer);

        return "customers/addCustomer-form";

    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("customerId") Long theId){

        customerService.deleteById(theId);

        return "redirect:/customers/list"; //redirecting to the /customers/list endpoint
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){
        customerService.save(theCustomer);

        return "redirect:/customers/list";
    }



}
