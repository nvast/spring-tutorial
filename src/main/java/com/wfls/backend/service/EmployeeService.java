package com.wfls.backend.service;

import com.wfls.backend.model.DTOs.EmployeeDTO;
import com.wfls.backend.model.EmployeeDAO;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface EmployeeService {
    ResponseEntity<?> createEmployee (EmployeeDTO employeeDTO);
    List<EmployeeDAO> getAllEmployees();
    ResponseEntity<EmployeeDAO> getEmployeeById(Long id);


}
