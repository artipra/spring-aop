package com.example.springaop.service;


import com.example.springaop.entity.Employee;
import com.example.springaop.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee save(Employee emp){
        return employeeRepository.save(emp);
    }

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }


}
