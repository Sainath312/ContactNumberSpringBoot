package com.example.EmployeeDataBase.repository;

import com.example.EmployeeDataBase.entity.NumberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NumberRepo extends JpaRepository<NumberEntity,Long> {
}
