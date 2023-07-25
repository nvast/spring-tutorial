package com.wfls.backend.controller;

import com.wfls.backend.model.DTOs.EmployeeDTO;
import com.wfls.backend.model.EmployeeDAO;
import com.wfls.backend.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
public class EmployeeController {

    private final EmployeeService service;

    //get all employees
    @GetMapping(value = "/employees")
    public List<EmployeeDAO> getAllEmployees() {

        return service.getAllEmployees();
    }

    @GetMapping(value = "/employees/{id}")
    public ResponseEntity<EmployeeDAO> getEmployeeById(@PathVariable Long id){
        return service.getEmployeeById(id);
    }

    //create employee
    @PostMapping("/employees")
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeDTO employee ) {
        return service.createEmployee(employee);
    }

//    @PutMapping("/employees/{id}")
//    public ResponseEntity<?> updateEmployee(@PathVariable Long id, EmployeeDAO employeeDAO){
//
//    }


}


