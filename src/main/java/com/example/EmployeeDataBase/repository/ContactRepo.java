package com.example.EmployeeDataBase.repository;

import com.example.EmployeeDataBase.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepo extends JpaRepository<ContactEntity,Long> {
}
