package com.mall.store.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mall.store.service.SupplierService;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @PostMapping
    public void create() {
        supplierService.addSupplier();
    }

    @PostMapping("/upload")
    public void upload(@RequestParam("file")  MultipartFile file) throws IOException {
        supplierService.upload(file);
    }
        
}
