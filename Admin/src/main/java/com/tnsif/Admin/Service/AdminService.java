package com.tnsif.Admin.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tnsif.Admin.Entity.Admin;
import com.tnsif.Admin.Repository.AdminRepository;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Optional<Admin> getAdminById(Long id) {
        return adminRepository.findById(id);
    }

    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin updateAdmin(Long id, Admin adminDetails) {
        return adminRepository.findById(id).map(admin -> {
            admin.setName(adminDetails.getName());
            admin.setEmail(adminDetails.getEmail());
            admin.setPassword(adminDetails.getPassword());
            admin.setRole(adminDetails.getRole());
            return adminRepository.save(admin);
        }).orElseThrow(() -> new RuntimeException("Admin not found with id " + id));
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}
