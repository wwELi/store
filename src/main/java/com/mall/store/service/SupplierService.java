package com.mall.store.service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

    public List<Supplier> upload(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new RuntimeException("no file upload");
        }

        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setSkipHeaderRecord(true)
                .setHeader("name", "address", "tell")
                .build();

        ArrayList<Supplier> suppliers = new ArrayList<>();
        try (Reader reader = new InputStreamReader(file.getInputStream());
                CSVParser csvParser = new CSVParser(reader, csvFormat)) {
            for (CSVRecord csvRecord : csvParser.getRecords()) {
                Supplier supplier = new Supplier();
                supplier.setCreateTime(new Date());
                supplier.setName(csvRecord.get("name"));
                supplier.setAddress(csvRecord.get("address"));
                supplier.setTell(csvRecord.get("tell"));
                suppliers.add(supplier);
            }
        }

        Collection<Supplier> list = suppliers.stream()
                .collect(Collectors.toMap(Supplier::getName, it -> it, (existing, replacement) -> existing))
                .values();

        List<String> names = list.stream().map(Supplier::getName).collect(Collectors.toList());
        List<Supplier> supplierList = supplierRepository.findByNameIn(names.toArray(new String[names.size()]));
        Set<String> nameSet = supplierList.stream().map(Supplier::getName).collect(Collectors.toSet());
        List<Supplier> savedSuppliers = list.stream().filter(it -> !nameSet.contains(it.getName())).toList();

        supplierRepository.saveAll(savedSuppliers);
        return savedSuppliers;
    }
}
