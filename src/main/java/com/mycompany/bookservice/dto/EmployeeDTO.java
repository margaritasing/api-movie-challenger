package com.mycompany.bookservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class EmployeeDTO {
    private Long empId;
    private String fname;
    private String lname;
}
