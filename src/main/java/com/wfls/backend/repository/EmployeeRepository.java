package com.wfls.backend.repository;

import com.wfls.backend.model.EmployeeDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDAO, Long> {
}
