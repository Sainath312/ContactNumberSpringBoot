package com.example.EmployeeDataBase.services;

import com.example.EmployeeDataBase.entity.ContactEntity;
import com.example.EmployeeDataBase.entity.NumberEntity;
import com.example.EmployeeDataBase.exceptions.ContactNotFound;
import com.example.EmployeeDataBase.repository.ContactRepo;
import com.example.EmployeeDataBase.repository.NumberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServices implements ContactService {
    @Autowired
    ContactRepo contentRepo;
    @Autowired
    NumberRepo numberRepo;

    public ContactEntity newContact(ContactEntity con) {
        return contentRepo.save(con);
    }
    public List<ContactEntity> listContents() {
        return contentRepo.findAll();

    }
    public List<ContactEntity> sortByUserFirstName() {
        Sort sort = Sort.by(Sort.Direction.ASC,"firstName");
        return contentRepo.findAll(sort);
    }

    public ResponseEntity<String> findContactById(Long id) {
        Optional<ContactEntity> contact = contentRepo.findById(id);
        if (contact.isPresent()) {
            ContactEntity foundContact = contact.get();
            StringBuilder response = new StringBuilder("Contact ID: " + foundContact.getContactId() + "\n" +
                    "First Name: " + foundContact.getFirstName() + "\n" +
                    "Last Name: " + foundContact.getLastName() + "\n" +
                    "Phone Numbers:" + "\n");

            for (NumberEntity phoneNumber : foundContact.getPhoneNumber()) {
                response.append("   Number: ").append(phoneNumber.getPhoneNumber()).append(", Type: ").append(phoneNumber.getType()).append("\n");
            }

            response.append("Email: ").append(foundContact.getEmailId()).append("\n");

            return ResponseEntity.ok().header("Content-type","application/json").body(response.toString());
        } throw new ContactNotFound("not found");
    }
}

