package com.absdev.model;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String title;
    private List<Employee> employees = new ArrayList<>();


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Company(String title) {
        if (title == null) throw new IllegalArgumentException("Название компании не может быть null");
        this.title = title;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        if (employee == null) throw new IllegalArgumentException("Employee не может быть null");
        employees.add(employee);
    }
}
