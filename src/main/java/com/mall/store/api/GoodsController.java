package com.mall.store.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mall.store.dto.request.GoodsRequestDto;
import com.mall.store.dto.response.GoodsDto;
import com.mall.store.service.GoodsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/goods")
@Validated
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @GetMapping
    public List<GoodsDto> getGoods() {
        return goodsService.getGoods();
    }

    @PostMapping
    public void create(@Valid @RequestBody GoodsRequestDto goodsRequestDto) {
        goodsService.createGood(goodsRequestDto);
    }
}
