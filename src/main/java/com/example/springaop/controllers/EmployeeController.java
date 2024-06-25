package com.example.springaop.controllers;

import com.example.springaop.dtos.EmployeeDto;
import com.example.springaop.entity.Employee;
import com.example.springaop.service.EmployeeService;
import com.example.springaop.dtos.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping()
    public ResponseEntity<ResponseDto> create(@RequestBody EmployeeDto employeeDto){
        Employee emp = employeeDto.toEmployee(employeeDto);
        Employee savedEmp =  employeeService.save(emp);
        ResponseDto dto = new ResponseDto();
        dto.setMessage("Employee is saved");
        dto.setHttpStatus(HttpStatus.OK);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/")
    public ResponseEntity<List<EmployeeDto>> employees(){
        List<Employee> employees = employeeService.getAllEmployee();
        List<EmployeeDto> dtos = new ArrayList<>();
        for(Employee emp : employees){
            dtos.add(EmployeeDto.toDto(emp));
        }
        return ResponseEntity.ok(dtos);
    }
}
