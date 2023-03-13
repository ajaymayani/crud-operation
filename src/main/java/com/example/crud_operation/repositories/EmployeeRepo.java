package com.example.crud_operation.repositories;

import com.example.crud_operation.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepo extends CrudRepository<Employee,Integer> {
}
