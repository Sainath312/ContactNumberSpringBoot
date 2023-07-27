package com.example.EmployeeDataBase.controller;

import com.example.EmployeeDataBase.entity.ContactEntity;
import com.example.EmployeeDataBase.services.ContactServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContactController {
    @Autowired
    ContactServices services;

    @PostMapping("/newContact")
    public ContactEntity addContent(@RequestBody @Valid ContactEntity contact){
        return services.newContact(contact);
    }
    @GetMapping("/listContacts")
    public List<ContactEntity> listOfContact(){
        return services.listContents();
    }
    @GetMapping("/sortByUserName")
    public List<ContactEntity> sortUserName(){
        return services.sortByUserFirstName();
    }

    @GetMapping("/getByUser/{id}")
    public ResponseEntity<String> getByUserId(@PathVariable Long id){
        return services.findContactById(id);
    }





}
