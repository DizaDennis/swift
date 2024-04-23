package com.sales.swift.controllers;

import com.sales.swift.entities.Prospect;
import com.sales.swift.service.ProspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 Flow of data:
 ProspectController <--> ProspectService <--> ProspectRepository <--> DB
Controller class has the different mappings, depending on what's required
 Uses @ModelAttribute to bind form data. Simply put, it binds an HTML form's input fields to the properties of the object
@author dennisdiza
 */
@Controller
@RequestMapping("/prospects") //base mapping
public class ProspectController {

    private ProspectService prospectService;

   //Autowire is optional because it's only 1 constructor
    @Autowired
    public ProspectController(ProspectService theProspectService){
        prospectService = theProspectService;
    }

    //mapping for listing the prospects
    @GetMapping("/list")
    public String listProspects(Model theModel){

        //get the prospects from the db
        List<Prospect> theProspect = prospectService.findAll();

        //add them to the spring model
        theModel.addAttribute("prospect", theProspect);
        return "prospects/prospect-list";

    }
    //Mapping to show the form used to add prospects
    @GetMapping("/showAddForm")
    public String showAddForm(Model theModel){
        //creating model attribute to bind the data
        Prospect theProspect = new Prospect();
        theModel.addAttribute("prospect", theProspect);

        return "prospects/addProspect-form";

    }

    /**
     * Code to update a prospect
     * prospectId brought in by (prospectId=${tempProspect.id})
     * Method looks in the DB for the prospect, using the id above
     * @RequestParam reads data FROM the form and binds it to whatever parameter is in the method
     */
    @GetMapping("/showUpdateForm")
    public String showUpdateForm(@RequestParam("prospectId") Long theId, Model theModel){

        //get prospect from the service (db)
        Prospect theProspect = prospectService.findById(theId);

        //set prospect as a model attribute to prepopulate the form
        theModel.addAttribute("prospect", theProspect);

        //send over to the form

        //returns the same "add prospect list with prepoulated fields"
        return "prospects/addProspect-form";

    }

    @GetMapping("/delete")
    public String delete(@RequestParam("prospectId") Long theId){

        //delete prospect
        prospectService.deleteById(theId);

        //redirect back to the prospect list
        return "redirect:/prospects/list";
    }


    //Code to save the prospect to the DB
    @PostMapping("/save")
    public String saveProspect(@ModelAttribute("prospect") Prospect theProspect){

        prospectService.save(theProspect);
        return "redirect:/prospects/list";
    }

}
