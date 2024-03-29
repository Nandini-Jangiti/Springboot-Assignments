package com.ust.assignment.service;

import com.ust.assignment.entity.Employee;
import com.ust.assignment.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository emprepo;
    @Override
    public List<Employee> getall() {
        return emprepo.findAll();
    }

    @Override
    public Employee createEmployee(Employee emp) {
        return emprepo.save(emp);
    }
}
