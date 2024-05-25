package com.ianfirdaus.springboot1.services;

import com.ianfirdaus.springboot1.exceptions.ResourceNotFoundException;
import com.ianfirdaus.springboot1.models.Employee;
import com.ianfirdaus.springboot1.repositories.EmployeeRepositoryInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceInterface {
    private EmployeeRepositoryInterface empRepo;

    public EmployeeService(EmployeeRepositoryInterface empRepo) {
        super();
        this.empRepo = empRepo;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return empRepo.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return empRepo.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        return empRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "Id", "id")
        );
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        Employee existingEmployee = empRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "Id", id)
        );

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());

        empRepo.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        Employee existingEmployee = empRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "Id", id)
        );

        empRepo.delete(existingEmployee);
    }
}
