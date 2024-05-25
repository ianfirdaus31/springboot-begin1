package com.ianfirdaus.springboot1.repositories;

import com.ianfirdaus.springboot1.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepositoryInterface extends JpaRepository<Employee, Long> {
}
