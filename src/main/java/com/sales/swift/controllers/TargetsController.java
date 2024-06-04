package com.sales.swift.controllers;

import com.sales.swift.entities.Targets;
import com.sales.swift.service.CustomerService;
import com.sales.swift.service.DataService;
import com.sales.swift.service.TargetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Flow of data:
 *  ProspectController <--> ProspectService <--> ProspectRepository <--> DB
 *  Created primarily to work the data required to populate the dashboard view
 *  Follow the same basic structure as the rest of the controller classes
 * @author dennisdiza
 */

@Controller
@RequestMapping("/targets")
public class TargetsController {

    private TargetsService targetsService;
    private DataService dataService;

    @Autowired
    public TargetsController(TargetsService theTargetsService){
        targetsService = theTargetsService;
    }

    @GetMapping("/list")
    public String targetsList(Model model){

        List<Targets> theTargets = targetsService.findAll();

        model.addAttribute("targets",theTargets);

        return "customers/customer-list";

    }
    @GetMapping("/newTargetForm")
    public String newTargetForm(Model model){

        Targets theTargets = new Targets();

        model.addAttribute("targets",theTargets);

        return "customers/customerTargets";
    }

    @GetMapping("/updateTargets")
    public String updateTargets(@RequestParam("targetsId")Long theId, Model model){

        Targets theTargets = targetsService.findById(theId);

        model.addAttribute("targets",theTargets);

        return "customers/customerTargets";
    }

    @PostMapping("/save")
    public String saveTarget(@ModelAttribute("targets") Targets theTargets){

        targetsService.save(theTargets);

        return "redirect:/customers/list";

    }

    @GetMapping("/delete")
    public String deleteTarget(@RequestParam("targetsId") Long theId){
        targetsService.delete(theId);

        return "redirect:/targets/list";
    }


}
