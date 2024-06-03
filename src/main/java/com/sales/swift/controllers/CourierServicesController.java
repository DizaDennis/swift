package com.sales.swift.controllers;


import com.sales.swift.entities.CourierServices;
import com.sales.swift.entities.Prospect;
import com.sales.swift.entities.Supplier;
import com.sales.swift.service.CourierServicesService;
import com.sales.swift.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/courierServices")
public class CourierServicesController {

private CourierServicesService courierServicesService;
private SupplierService supplierService;

@Autowired
    public CourierServicesController(CourierServicesService theCourierServicesService, SupplierService theSupplierService){


    courierServicesService = theCourierServicesService;

    supplierService = theSupplierService;
}

    @GetMapping("/list")
    public String courierServices(Model theModel){

    List<CourierServices> theCourier = courierServicesService.findAll();

    theModel.addAttribute("courierServices", theCourier);

    return "services/service-list";

    }

    @GetMapping("/addServiceForm")
    public String addServiceForm(Model theModel){

    CourierServices theCourierServices = new CourierServices();

    theModel.addAttribute("courierServices", theCourierServices);

    return "services/addServices-form";

    }

    @GetMapping("/update")
    public String updateForm(@RequestParam("courierServicesId")Long courierServicesId,Model theModel){

    //theSupplier variable set to the id from requestParam is then used to query the DB
    CourierServices theCourierServices = courierServicesService.findById(courierServicesId);

   // SupplierService theSupplier = (SupplierService) supplierService.findById(supplierId);


    //theModel.addAttribute("supplier",theSupplier);
    theModel.addAttribute("courierServices", theCourierServices);

    return "services/addServices-form";

    }

    @GetMapping("/delete")
    public String deleteService(@RequestParam("courierServicesId") Long theId){

    courierServicesService.deleteById(theId);

    return "redirect:/courierServices/list";

    }

    @PostMapping("/save")
    public String saveCourierService(@ModelAttribute("courierServices") CourierServices theCourierServices){

    courierServicesService.save(theCourierServices);

    return "redirect:/courierServices/list";
    }

}
