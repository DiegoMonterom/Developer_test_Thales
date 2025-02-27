package com.thales.employee.repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.thales.employee.model.Employee;
import com.thales.employee.model.EmployeeResponse;
import com.thales.employee.model.SingleEmployeeResponse;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final RestTemplate restTemplate;

    public EmployeeRepositoryImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private Map<Long, Employee> cache = new HashMap<>();

    @Override
    public List<Employee> fetchAllEmployees() {
        /*if (!cache.isEmpty()) {
            System.out.println("Return data from cache.");
            return new ArrayList<>(cache.values());
        }*/

        String url = "http://dummy.restapiexample.com/api/v1/employees";
        try {
            EmployeeResponse response = restTemplate.getForObject(url, EmployeeResponse.class);
            if (response != null && response.getData() != null) {
                return response.getData();
            } else {
                System.out.println("There's no data.");
            }
        } catch (HttpClientErrorException.TooManyRequests e) {
            System.out.println("Too Many Requests. Wait a few seconds.");
        } catch (RestClientException e) {
            System.out.println("Error fetching employees: " + e.getMessage());
        }

        return Collections.emptyList();
    }

    @Override
    public Employee fetchEmployeeById(Long id) {
        if (cache.containsKey(id)) {
            System.out.println("Return data from cache.");
            return cache.get(id);
        }

        String url = "http://dummy.restapiexample.com/api/v1/employee/" + id;
        try {
            SingleEmployeeResponse response = restTemplate.getForObject(url, SingleEmployeeResponse.class);
            if (response != null) {
                cache.put(id, response.getData());
                return response.getData();
            }
        } catch (HttpClientErrorException.TooManyRequests e) {
            System.out.println("Too Many Requests. Wait a few seconds.");
        }

        return null;
    }
}
