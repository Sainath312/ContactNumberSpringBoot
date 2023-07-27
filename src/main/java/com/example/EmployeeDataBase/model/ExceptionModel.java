package com.example.EmployeeDataBase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionModel {
    private String status;
    private String errorMessage;
    private String path;

}
