package com.mall.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mall.store.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, String> {
    
}
