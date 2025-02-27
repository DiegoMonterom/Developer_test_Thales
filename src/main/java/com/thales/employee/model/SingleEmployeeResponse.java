package com.thales.employee.model;

public class SingleEmployeeResponse {
    
    private String status;
    private Employee data;
    private String message;


    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Employee getData() {
        return this.data;
    }

    public void setData(Employee data) {
        this.data = data;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
