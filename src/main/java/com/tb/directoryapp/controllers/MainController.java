package com.tb.directoryapp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @GetMapping("/auth/login")
    public String Login() {
        return "Login";
    }

    @GetMapping("/")
    public String Index() {
        return "redirect:/admin";
    }

//    @GetMapping("/")
//    public String Index() {
//        return "redirect:/adminstrator/users";
//    }

//    @GetMapping("/admin")
//    public String Admin_Dashboard() {
//        return "indexADMIN";
//    }
//
//    @GetMapping("/group/admin/crm/home")
//    public String CRM_Dashboard() {
//        return "indexCRM";
//    }

}


//    @GetMapping("/user")
//    public String userIndex() {
//        return "user/index";
//    }

