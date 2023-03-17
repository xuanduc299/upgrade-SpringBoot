package com.CRUD.demoCRUD.Repository;

import com.CRUD.demoCRUD.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    Product getProductById(UUID id);
}
