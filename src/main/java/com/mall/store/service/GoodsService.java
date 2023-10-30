package com.mall.store.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mall.store.dto.request.GoodsRequestDto;
import com.mall.store.dto.response.GoodsDto;
import com.mall.store.model.Goods;
import com.mall.store.model.Supplier;
import com.mall.store.repository.GoodsRepository;
import com.mall.store.repository.SupplierRepository;

@Service
public class GoodsService {

    @Autowired
    GoodsRepository goodsRepository;

    @Autowired
    SupplierRepository supplierRepository;

    public List<GoodsDto> getGoods() {
        return goodsRepository.findAll()
                .stream()
                .filter(it -> it.getName() != null)
                .map(GoodsDto::form)
                .collect(Collectors.toList());
    }

    public void createGood(GoodsRequestDto goodsDto) {
        String name = goodsDto.getName();

        Optional<Goods> optional = goodsRepository.findByName(name);

        if (optional.isPresent()) {
            throw new RuntimeException("good has created");
        }

        String supplierId = goodsDto.getSupplierId();

        Optional<Supplier> optionalSupplier = supplierRepository.findById(supplierId);

        if (optionalSupplier.isEmpty()) {
            throw new RuntimeException("not found supplier");
        }

        Goods goods = new Goods();
        goods.setName(goodsDto.getName());
        goods.setGoodsPrice(goodsDto.getPrice());
        goods.setCreateTime(new Date());
        goods.setSupplier(optionalSupplier.get());
        goodsRepository.save(goods);
    }

    public String genGoodsName() {
        String names = goodsRepository.findAll()
                .stream()
                .map(Goods::getName)
                .collect(Collectors.joining(","));
        return names;
    }
}
