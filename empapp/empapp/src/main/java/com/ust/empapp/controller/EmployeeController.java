package com.ust.empapp.controller;
import com.ust.empapp.entity.Employee;
import com.ust.empapp.exception.NotFoundException;
import com.ust.empapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmp();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable  Long id) {
        try {
            return employeeService.getEmployeeById(id);
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/byDepartment")
    public Page<Employee> getEmployeesByDepartment(@RequestParam String department,
                                                      @RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "10") int size) {
        return employeeService.getEmployeesByDepartment(department, PageRequest.of(page, size));
    }
}

