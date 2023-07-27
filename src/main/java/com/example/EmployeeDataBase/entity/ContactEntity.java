package com.example.EmployeeDataBase.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Table(name = "Contacts")
public class ContactEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "contactId")
    private long contactId;
    @NotEmpty(message = "First Name Should Not Be Null")
    @Column(name = "firstName")
    private String firstName;
    @NotEmpty(message = "Last Name Should Not Be Null")
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL)
    public List<NumberEntity> phoneNumber= new ArrayList<>();

    @Email(message = "Enter Valid EmailID")
    @NotEmpty(message = "a")
    private String emailId;

}