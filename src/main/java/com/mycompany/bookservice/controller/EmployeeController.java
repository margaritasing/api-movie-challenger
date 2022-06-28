package com.mycompany.bookservice.controller;

import com.mycompany.bookservice.dto.EmployeeDTO;
import com.mycompany.bookservice.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    @Autowired
    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employee")
    public EmployeeDTO save(@RequestBody EmployeeDTO employeeDTO){
        employeeService.addEmployeee(employeeDTO);
        return employeeDTO;
    }
}
