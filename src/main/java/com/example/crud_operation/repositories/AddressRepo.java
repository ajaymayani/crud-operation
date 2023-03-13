package com.example.crud_operation.repositories;

import com.example.crud_operation.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address,Integer> {
}
