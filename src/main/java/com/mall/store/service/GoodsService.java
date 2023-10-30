package com.mall.store.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mall.store.dto.request.GoodsRequestDto;
import com.mall.store.dto.response.GoodsDto;
import com.mall.store.model.Goods;
import com.mall.store.repository.GoodsRepository;

@Service
public class GoodsService {
    
    @Autowired
    GoodsRepository goodsRepository;

    public List<GoodsDto> getGoods() {
         return goodsRepository.findAll()
            .stream()
            .filter(it -> it.getName() != null)
            .map(it -> GoodsDto.builder().id(it.getId()).name(it.getName()).build())
            .collect(Collectors.toList());
    }

    public void createGood(GoodsRequestDto goodsDto) {
        String name = goodsDto.getName();

        Optional<Goods> optional = goodsRepository.findByName(name);

        if (optional.isPresent()) {
            throw new RuntimeException("good has created");
        }

        Goods goods = new Goods();
        goods.setName(goodsDto.getName());
        goods.setCreateTime(new Date());
        goodsRepository.save(goods);
    }
}
