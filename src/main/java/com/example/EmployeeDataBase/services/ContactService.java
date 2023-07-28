package com.example.EmployeeDataBase.services;

import com.example.EmployeeDataBase.entity.ContactEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ContactService {
    ContactEntity newContact(ContactEntity con);
    List<ContactEntity> listContents();
    List<ContactEntity> sortByUserFirstName();
    ResponseEntity<String> findContactById(Long id);
}

