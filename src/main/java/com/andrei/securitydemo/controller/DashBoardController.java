package com.andrei.securitydemo.controller;

import com.andrei.securitydemo.domain.User;
import com.andrei.securitydemo.service.AdminService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashBoardController {

    private final AdminService adminService;

    public DashBoardController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/dashboard")
    public String getDashboard (@AuthenticationPrincipal User user, ModelMap model) {

        model.addAttribute("user", user);

        //Should work just for users with ROLE_ADMIN
//        adminService.getAllUserAccounts();

        return "dashboard";
    }


    @GetMapping("/leaders")
    public String showLeaders (@AuthenticationPrincipal User user, ModelMap model) {

        model.addAttribute("user", user);

        //Should work just for users with ROLE_ADMIN
//        adminService.getAllUserAccounts();

        return "leaders";
    }

    @GetMapping("/systems")
    public String showSystem (@AuthenticationPrincipal User user, ModelMap model) {

        model.addAttribute("user", user);

        //Should work just for users with ROLE_ADMIN
//        adminService.getAllUserAccounts();

        return "systems";
    }

}
