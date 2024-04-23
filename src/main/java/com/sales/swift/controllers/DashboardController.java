package com.sales.swift.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class DashboardController {
    @GetMapping("/")
    public String rootView(){
        return "dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(){

        return "dashboard";
    }



}
