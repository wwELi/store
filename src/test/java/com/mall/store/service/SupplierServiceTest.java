package com.mall.store.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.context.request.FacesRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.mall.store.model.Supplier;
import com.mall.store.repository.SupplierRepository;

@ExtendWith(MockitoExtension.class)
public class SupplierServiceTest {
    
    @InjectMocks
    SupplierService service;

    @Mock
    SupplierRepository repository;

    @Test
    public void should_save_no_repeat_supplier() throws IOException {
        byte[] content = "name,address,tell\n供应商A,address1,123\n供应商A,address1,123".getBytes();
        MultipartFile file = new MockMultipartFile("file", "file.csv", "text/plain", content);
        Supplier supplier = new Supplier();
        supplier.setName("供应商A");
        supplier.setAddress("address1");
        supplier.setTell("123");
        supplier.setCreateTime(new Date());
        
        List<Supplier> saved = service.upload(file);
        verify(repository, times(1)).saveAll(any());
        assertEquals(saved.size(), 1);
    }
}
