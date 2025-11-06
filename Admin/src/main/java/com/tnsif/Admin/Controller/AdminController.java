package com.tnsif.Admin.Controller;



import com.tnsif.Admin.Entity.Admin;
import com.tnsif.Admin.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*") // allows access from Postman / frontend
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    // ✅ CREATE - POST
    @PostMapping
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminRepository.save(admin);
    }

    // ✅ READ ALL - GET
    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    // ✅ READ ONE - GET by ID
    @GetMapping("/{id}")
    public Admin getAdminById(@PathVariable Long id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found with id: " + id));
    }

    // ✅ UPDATE - PUT
    @PutMapping("/{id}")
    public Admin updateAdmin(@PathVariable Long id, @RequestBody Admin updatedAdmin) {
        Admin existingAdmin = adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found with id: " + id));

        existingAdmin.setName(updatedAdmin.getName());
        existingAdmin.setEmail(updatedAdmin.getEmail());
        existingAdmin.setPassword(updatedAdmin.getPassword());
        existingAdmin.setDepartment(updatedAdmin.getDepartment());
        existingAdmin.setRole(updatedAdmin.getRole());
        existingAdmin.setStatus(updatedAdmin.getStatus());
        existingAdmin.setPhoneNumber(updatedAdmin.getPhoneNumber());

        return adminRepository.save(existingAdmin);
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public String deleteAdmin(@PathVariable Long id) {
        if (!adminRepository.existsById(id)) {
            throw new RuntimeException("Admin not found with id: " + id);
        }
        adminRepository.deleteById(id);
        return "Admin with ID " + id + " deleted successfully.";
    }
}
