package com.thales.employee.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.thales.employee.model.Employee;
import com.thales.employee.repository.EmployeeRepository;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    @Mock  // makes the repository simulation
    private EmployeeRepository employeeRepository;

    @InjectMocks  // Inject the mock in EmployeeService
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        // simulated data
        Employee emp1 = new Employee(1L, "Alice", 35000, "30", "", 4200000);
        Employee emp2 = new Employee(2L, "javier", 25000, "50", "", 3000000);

        List<Employee> mockEmployees = Arrays.asList(emp1, emp2);

        // Simulated repository response
        when(employeeRepository.fetchAllEmployees()).thenReturn(mockEmployees);
    }

    @Test
    void testGetAllEmployees() {
        // call to the method to test
        List<Employee> employees = employeeService.getAllEmployees();

        // not null and right size
        assertNotNull(employees);
        assertEquals(2, employees.size());

        // especific data validation
        assertEquals("Alice", employees.get(0).getEmployee_name());
        assertEquals("javier", employees.get(1).getEmployee_name());

        // verifiy that the method was called at least once in repository
        verify(employeeRepository, times(1)).fetchAllEmployees();
    }
}
