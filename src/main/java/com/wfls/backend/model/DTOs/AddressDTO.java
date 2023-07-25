package com.wfls.backend.model.DTOs;

import com.wfls.backend.model.EmployeeDAO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private String street;
    private String postalCode;
    private String city;
    private String state;

}
