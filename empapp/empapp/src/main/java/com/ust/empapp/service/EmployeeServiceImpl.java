package com.ust.empapp.service;

import com.ust.empapp.entity.Address;
import com.ust.empapp.entity.Employee;
import com.ust.empapp.exception.NotFoundException;
import com.ust.empapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee createEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }

    @Override
    public List<Employee> getAllEmp() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) throws NotFoundException {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Employee not found with id: " + id));
    }


    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        if (!employeeRepository.existsById(id)) {
            try {
                throw new NotFoundException("Employee not found with id: " + id);
            } catch (NotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            try {
                throw new NotFoundException("Employee not found with id: " + id);
            } catch (NotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        employeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> getEmployeesByDepartment(String department, Pageable pageable) {
        return employeeRepository.findByDepartment(department, pageable);
    }


}
