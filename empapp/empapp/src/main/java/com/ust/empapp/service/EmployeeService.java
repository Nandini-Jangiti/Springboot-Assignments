package com.ust.empapp.service;

import com.ust.empapp.entity.Employee;
import com.ust.empapp.exception.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee emp);
    List<Employee> getAllEmp();
    Employee getEmployeeById(Long id) throws NotFoundException;
    Employee updateEmployee(Long id, Employee employee);

    void deleteEmployee(Long id);

    Page<Employee> getEmployeesByDepartment(String department, Pageable pageable);


}
