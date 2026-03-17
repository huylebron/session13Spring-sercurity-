package com.example.session13homework.controller;

import com.example.session13homework.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @GetMapping("/api/v1/employees")
    public List<Employee> getEmployees() {
        return List.of(

                new Employee(1L , "huy", 15000.0),
                new Employee(2L , "huyen", 16000.0),
                new Employee(3L , "hong", 17000.0)
        );
    }
}
