package com.sales.swift.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller class that will be used to manage the custom login & registration pages
 * @author dennisdiza
 */

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
