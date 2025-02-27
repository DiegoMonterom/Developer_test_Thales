package com.thales.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thales.employee.model.Employee;
import com.thales.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeRepository.fetchAllEmployees();
        employees.forEach(emp -> emp.setEmployee_annual_salary(emp.getEmployee_salary() * 12));
        return employees;
    }

    public Employee getEmployeeById(Long id) {
        Employee employee = employeeRepository.fetchEmployeeById(id);
        if (employee != null) {
            employee.setEmployee_annual_salary(employee.getEmployee_salary() * 12);
        }
        return employee;
    }
}
