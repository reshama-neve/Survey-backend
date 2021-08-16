package com.project.survey.service;

import com.project.survey.model.Admin;
import com.project.survey.model.User;
import com.project.survey.repo.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final AdminRepo adminRepo;

    @Autowired
    public AdminService(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    public Admin saveAdmin(Admin admin) {
        return adminRepo.save(admin);
    }
    public List<Admin> saveAdmins(List<Admin> admins) {
        return adminRepo.saveAll(admins);
    }
    public Admin getAdminById(int id) {
        return adminRepo.findById(id).orElse(null);
    }

    public List<Admin> allAdmins() {
        return adminRepo.findAll();
    }

}
