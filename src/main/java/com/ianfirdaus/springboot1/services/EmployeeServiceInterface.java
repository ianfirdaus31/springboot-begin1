package com.ianfirdaus.springboot1.services;

import com.ianfirdaus.springboot1.models.Employee;

import java.util.List;

public interface EmployeeServiceInterface {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(long id);
    Employee updateEmployee(Employee employee, long id);
    void deleteEmployee(long id);
}
