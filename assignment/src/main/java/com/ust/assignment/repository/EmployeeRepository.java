package com.ust.assignment.repository;

import com.ust.assignment.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//to connecting the db we are using the repository
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
