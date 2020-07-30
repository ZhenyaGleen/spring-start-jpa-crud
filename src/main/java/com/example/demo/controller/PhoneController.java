package com.example.demo.controller;

import com.example.demo.entity.Phone;
import com.example.demo.repo.PhoneRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/phone")
public class PhoneController {

    final
    PhoneRepo phoneRepo;

    public PhoneController(PhoneRepo phoneRepo) {
        this.phoneRepo = phoneRepo;
    }

    @GetMapping
    public List<Phone> getListPhone(){
        return phoneRepo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Phone> getPhoneById(@PathVariable int id){
        return phoneRepo.findById(id);
    }

    @PostMapping
    public Phone createPhone(@RequestBody Phone phone){
        return phoneRepo.save(phone);
    }

    @PutMapping("/{id}")
    public Phone updatePhone(@RequestBody Phone phone,@PathVariable int id){
        phoneRepo.findById(id).get();
        phone.setName(phone.getName());
        phone.setColor(phone.getColor());
        phone.setNumber(phone.getColor());
        phone.setDate(phone.getDate());
        phoneRepo.save(phone);
        return phone;
    }

    @DeleteMapping("/{id}")
    public String deletePhoneById(@PathVariable int id){
        phoneRepo.deleteById(id);

        return "Delete phone by id: " + id;
    }
}
