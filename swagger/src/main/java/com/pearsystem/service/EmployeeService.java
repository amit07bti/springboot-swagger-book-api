package com.pearsystem.service;

import com.pearsystem.model.Employee;
import com.pearsystem.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo repo;

    public String saveEmployee(Employee employee){
        repo.save(employee);
        return "new Employee added with id "+employee.getId();

    }

    public Employee  getEmployee(int id){
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    public List<Employee> deleteEmployee(int id){
        repo.deleteById(id);
        return repo.findAll();

    }
}
