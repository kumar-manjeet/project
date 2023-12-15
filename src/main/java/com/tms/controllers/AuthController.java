package com.tms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
	
	
    @GetMapping("/signin")
    public String signin() {
    	return "login";
    }
    
    @GetMapping("/home")
    public String home(Model model) {
    	model.addAttribute("content", "dashboard");
    	return "home";
    }
    
}

