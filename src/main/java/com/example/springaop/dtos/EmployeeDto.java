package com.example.springaop.dtos;

import com.example.springaop.entity.Employee;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeDto {

    private String name;
    private String add;


    public static Employee toEmployee(EmployeeDto dto){
        Employee emp = new Employee();
        emp.setAdd(dto.getAdd());
        emp.setName(dto.getName());
        return emp;
    }

    public static EmployeeDto toDto(Employee emp){
        EmployeeDto dto = new EmployeeDto();
        dto.setAdd(emp.getAdd());
        dto.setName(emp.getName());
        return dto;
    }

}
