package com.ust.assignment.service;

import com.ust.assignment.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getall();
    Employee createEmployee(Employee emp);
}
