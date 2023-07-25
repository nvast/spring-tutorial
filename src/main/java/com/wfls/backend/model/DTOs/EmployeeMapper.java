package com.wfls.backend.model.DTOs;

import com.wfls.backend.model.AddressDAO;
import com.wfls.backend.model.EmployeeDAO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @Mapping(target = "street", source = "address.street")
    @Mapping(target = "postalCode", source = "address.postalCode")
    @Mapping(target = "city", source = "address.city")
    @Mapping(target = "state", source = "address.state")
    AddressDAO addressDTOToAddressDAO(AddressDTO address);

    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "emailId", source = "emailId")
    @Mapping(target = "phoneNumber", source = "phoneNumber")
    @Mapping(target = "address", expression = "java(EmployeeMapper.INSTANCE.addressDTOToAddressDAO(employeeDTO.getAddress()))")
    EmployeeDAO employeeDTOToEmployeeDAO(EmployeeDTO employeeDTO);
}