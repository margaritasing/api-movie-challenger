package com.mycompany.bookservice.service;

import com.mycompany.bookservice.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    public EmployeeDTO addEmployeee(EmployeeDTO employeeDTO);
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO, Long empId);
    public void deleteEmployee(Long bookId);
    public List<EmployeeDTO> getAllEmployee();
    public EmployeeDTO getEmployee(Long empId);

}
