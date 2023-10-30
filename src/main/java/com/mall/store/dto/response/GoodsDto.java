package com.mall.store.dto.response;

import java.util.Date;

import com.mall.store.model.Goods;
import com.mall.store.model.Supplier;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GoodsDto {
    private Long id;
    private String name;
    private Date createTime;
    private Supplier supplier;

    public static GoodsDto form(Goods goods) {
        return GoodsDto.builder()
        .id(goods.getId())
        .name(goods.getName())
        .createTime(goods.getCreateTime())
        .supplier(goods.getSupplier())
        .build();
    }
}
