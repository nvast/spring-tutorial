package com.wfls.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Address")
public class AddressDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String postalCode;
    private String city;
    private String state;
    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    private List<EmployeeDAO> employeeDAO;

    public AddressDAO(String street, String postalCode, String city, String state) {
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.state = state;
    }
}
