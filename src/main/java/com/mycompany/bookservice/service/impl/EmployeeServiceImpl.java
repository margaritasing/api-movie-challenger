package com.mycompany.bookservice.service.impl;

import com.mycompany.bookservice.dto.EmployeeDTO;
import com.mycompany.bookservice.repository.EmployeeRepository;
import com.mycompany.bookservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl  implements EmployeeService {


    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDTO addEmployeee(EmployeeDTO employeeDTO) {
        return null;
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO, Long empId) {
        return null;
    }

    @Override
    public void deleteEmployee(Long empId) {

    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        return null;
    }

    @Override
    public EmployeeDTO getEmployee(Long empId) {
        return null;
    }
}
