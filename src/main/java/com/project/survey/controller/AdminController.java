package com.project.survey.controller;

import com.project.survey.model.Admin;
import com.project.survey.model.User;
import com.project.survey.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/addAdmin")
    public Admin addAdmin(@RequestBody Admin admin) {
        return adminService.saveAdmin(admin);
    }

    @PostMapping("/addAdmins")
    public List<Admin> addAdmins(@RequestBody List<Admin> Admins) {
        return adminService.saveAdmins(Admins);
    }
    @GetMapping("/adminById/{id}")
    public Admin findAdminById(@PathVariable int id) {
        return adminService.getAdminById(id);
    }

    @GetMapping("/allAdmins")
    public ResponseEntity<List<Admin>> findAllAdmins(){
        List<Admin> admins = adminService.allAdmins();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }

}
