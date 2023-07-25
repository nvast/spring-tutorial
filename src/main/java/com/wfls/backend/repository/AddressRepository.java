package com.wfls.backend.repository;

import com.wfls.backend.model.AddressDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressDAO, Long> {
}
