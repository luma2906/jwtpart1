package com.example.mapstruct.service.employee;

import com.example.mapstruct.model.Employee;

public interface IEmployeeService {
     Iterable<Employee> getAll();
     Employee save(Employee employee);
}
