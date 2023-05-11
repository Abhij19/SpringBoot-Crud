package com.jpa.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.backend.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
