package com.mall.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mall.store.model.Supplier;
import com.mall.store.repository.SupplierRepository;

@Service
public class SupplierService {
    @Autowired
    SupplierRepository supplierRepository;

    public void addSupplier() {
        Supplier supplier = new Supplier();
        supplier.setName("供应商A");
        supplierRepository.save(supplier);
    }
}
