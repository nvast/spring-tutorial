package com.wfls.backend.service;

import com.wfls.backend.model.AddressDAO;
import com.wfls.backend.model.DTOs.EmployeeDTO;
import com.wfls.backend.model.EmployeeDAO;
import com.wfls.backend.repository.AddressRepository;
import com.wfls.backend.repository.EmployeeRepository;
import com.wfls.backend.service.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImplementation implements EmployeeService {
    private final EmployeeRepository repository;
    private final AddressRepository addressRepository;

    @Override
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        if (employeeDTO == null) {
            return ResponseEntity.status(500).body("");
        }
        AddressDAO addressDAO = new AddressDAO(
                employeeDTO.getAddress().getStreet(),
                employeeDTO.getAddress().getPostalCode(),
                employeeDTO.getAddress().getCity(),
                employeeDTO.getAddress().getState());

        addressRepository.save(addressDAO);
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.setLastName(employeeDTO.getLastName());
        employeeDAO.setPhoneNumber(employeeDTO.getPhoneNumber());
        employeeDAO.setFirstName(employeeDTO.getFirstName());
        employeeDAO.setEmailId(employeeDTO.getEmailId());
        employeeDAO.setAddress(addressDAO);
        repository.save(employeeDAO);
        return ResponseEntity.ok(employeeDTO);
    }

    public List<EmployeeDAO> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity<EmployeeDAO> getEmployeeById(@PathVariable Long id){
        EmployeeDAO employeeDAO = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with id: " + id));
        return ResponseEntity.ok(employeeDAO);
    }


//    public ResponseEntity<EmployeeDAO> updateEmployee(Long id, EmployeeDAO employeeDAO){
//
//    }
}
