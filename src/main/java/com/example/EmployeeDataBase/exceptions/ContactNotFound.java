package com.example.EmployeeDataBase.exceptions;

public class ContactNotFound extends RuntimeException{
    public ContactNotFound(String message) {
        super(message);
    }
}
