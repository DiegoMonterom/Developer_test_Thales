package com.thales.employee.model;

public class Employee {
    
    private Long id;
    private String employee_name;
    private double employee_salary;
    private String employee_age;
    private String profile_image;
    private double employee_annual_salary;

    public Employee(){

    }

    public Employee(Long id, String employee_name, double employee_salary, String employee_age, String profile_image, double employee_annual_salary){
        this.id = id;
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.employee_age = employee_age;
        this.profile_image = profile_image;
        this.employee_annual_salary = employee_annual_salary;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployee_name() {
        return this.employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public double getEmployee_salary() {
        return this.employee_salary;
    }

    public void setEmployee_salary(double employee_salary) {
        this.employee_salary = employee_salary;
    }

    public String getEmployee_age() {
        return this.employee_age;
    }

    public void setEmployee_age(String employee_age) {
        this.employee_age = employee_age;
    }

    public String getProfile_image() {
        return this.profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public double getEmployee_annual_salary() {
        return this.employee_annual_salary;
    }

    public void setEmployee_annual_salary(double employee_annual_salary) {
        this.employee_annual_salary = employee_annual_salary;
    }

}
