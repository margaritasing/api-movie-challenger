package com.mycompany.bookservice.controller;

import com.mycompany.bookservice.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/greetings")
public class GreetingsController {

    @GetMapping
    public String greet(){
        return "Hola como estas te saludo desde un endpoint?";
    }

    /*@GetMapping("/withname/{name11}/{lname}")
    public String greetWithName(@PathVariable("name11") String name, @PathVariable String lname){
        return "How are you "+name+" "+lname+"?";
    }*/

    /*@GetMapping("/withnamerp")
    public String greetWithName(@RequestParam("name11") String name, @RequestParam String lname){
        return "How are you "+name+" "+lname+"?";
    }*/

    @GetMapping("/withnamerppv/{empId}")
    public String greetWithName(@PathVariable("empId") Long employeeId, @RequestParam("name11") String name, @RequestParam String lname){
        return "How are you "+name+" "+lname+" "+employeeId+"?";
    }

    //http://localhost:8080/api/v1/greetings/save-employee
    @PostMapping("/save-employee")
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        return employeeDTO;
    }
}
