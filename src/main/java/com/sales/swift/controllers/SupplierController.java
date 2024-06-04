package com.sales.swift.controllers;


import com.sales.swift.entities.Supplier;
import com.sales.swift.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Flow of data:
 *  ProspectController <--> ProspectService <--> ProspectRepository <--> DB
 *  Class to manage courier suppliers
 */
@Controller
@RequestMapping("/suppliers")
public class SupplierController {

    //Bringing in the Supplier service to access its methods
    private SupplierService supplierService;
    //Bringing in the Supplier service to access its methods
    @Autowired
    public SupplierController(SupplierService theSupplierService){
        supplierService = theSupplierService;
    }

    @GetMapping("/list")
    public String supplierList(Model theModel){

        //Using the method defined in the service to query the DB
        List<Supplier> theSupplier = supplierService.findAll();

        theModel.addAttribute("supplier",theSupplier);

        return "suppliers/supplier-list";

    }

    //Mapping to the new supplier form
    @GetMapping("/newSupplierForm")
    public String newSupplierForm(Model theModel){
        Supplier theSupplier = new Supplier();
        theModel.addAttribute("supplier",theSupplier);

        return "suppliers/addSupplier-form";
    }
    @GetMapping("/updateSupplier")
    //using @RequestParam to take in the id
    public String updateSupplier(@RequestParam("supplierId")Long theId, Model theModel){
        //theSupplier variable set to the id from requestParam is then used to query the DB
        Supplier theSupplier = supplierService.findById(theId);
        //using the model to prepopulate the form
        theModel.addAttribute("supplier",theSupplier);

        return"suppliers/addSupplier-form";
    }

    @GetMapping("/delete")
    public String deleteSupplier(@RequestParam("supplierId")Long theId){

        //calling the delete method in the service clas
        supplierService.deleteById(theId);

        return"redirect:/suppliers/list";
    }

    @PostMapping("/save")
    public String saveSupplier(@ModelAttribute("supplier") Supplier theSupplier){

        //calling the save method in the supplier service class
        supplierService.save(theSupplier);

        return "redirect:/suppliers/list";
    }




}
