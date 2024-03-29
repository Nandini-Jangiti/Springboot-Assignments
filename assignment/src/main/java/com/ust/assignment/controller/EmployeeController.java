package com.ust.assignment.controller;

import com.ust.assignment.entity.Employee;
import com.ust.assignment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService empservice;


    @GetMapping("/get")
    public List<Employee> getall(){
        return empservice.getall();
    }
    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp){
        return ResponseEntity.status(HttpStatus.CREATED).body(empservice.createEmployee(emp));
    }
}
