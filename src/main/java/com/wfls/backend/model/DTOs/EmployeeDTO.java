package com.wfls.backend.model.DTOs;

import com.wfls.backend.model.AddressDAO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {
    private String firstName;
    private String lastName;
    private String emailId;
    private String phoneNumber;
    private AddressDTO address;
}
