package com.thales.employee.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.thales.employee.model.Employee;

@Repository
public interface EmployeeRepository {

    List<Employee> fetchAllEmployees();
    Employee fetchEmployeeById(Long id);
}
