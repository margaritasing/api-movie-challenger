package com.mycompany.bookservice.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="EMPLOYEE")
@NoArgsConstructor
@Getter
@Setter
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long empId;
    @Column(length = 30)
    private String fname;
    private String lname;
}
