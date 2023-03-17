package com.CRUD.demoCRUD.Repository;

import com.CRUD.demoCRUD.DTO.CustomerDTO;
import com.CRUD.demoCRUD.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    Customer getCustomerById(UUID id);
}
