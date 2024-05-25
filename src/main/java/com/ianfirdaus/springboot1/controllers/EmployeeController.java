package com.ianfirdaus.springboot1.controllers;

import com.ianfirdaus.springboot1.models.Employee;
import com.ianfirdaus.springboot1.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    private final EmployeeService empService;

    public EmployeeController(EmployeeService empService) {
        this.empService = empService;
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return empService.getAllEmployees();
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId) {
        return new ResponseEntity<Employee>(empService.getEmployeeById(employeeId), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(empService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
        return new ResponseEntity<Employee>(empService.updateEmployee(employee, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {
        empService.deleteEmployee(id);
        return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
    }
}
