package com.thales.employee.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeResponse {
    
    private String status;
    private List<Employee> data;


    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Employee> getData() {
        return this.data;
    }

    public void setData(List<Employee> data) {
        this.data = data;
    }

}
