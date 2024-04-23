package com.sales.swift.controllers;

import com.sales.swift.entities.Leads;
import com.sales.swift.service.LeadsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/leads")
public class LeadsController {

    private LeadsService leadsService;

    @Autowired
    public LeadsController(LeadsService theLeadsService){
        leadsService = theLeadsService;
    }

    @GetMapping("/list")
    public String listLeads(Model theModel){

        List<Leads> theLeads = leadsService.findAll();

        theModel.addAttribute("leads",theLeads);

        return "leads/lead-list";
    }

    @GetMapping("/newLeadForm")
    public String newLeadForm(Model theModel){

        //creating model attribute to bind the data
        Leads theLeads = new Leads();

        theModel.addAttribute("leads",theLeads);

        return "leads/addLead-form";

    }

    @GetMapping("/updateLead")
    public String updateLead(@RequestParam("leadId") Long theId, Model theModel){


        Leads theLeads = leadsService.findById(theId);
        theModel.addAttribute("leads",theLeads);

        return "leads/addLead-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("leadId") Long theId, Model theModel){

        leadsService.deleteById(theId);

        return "redirect:/leads/list";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("leads") Leads theLeads){

        leadsService.save(theLeads);

        return "redirect:/leads/list";
    }

}
