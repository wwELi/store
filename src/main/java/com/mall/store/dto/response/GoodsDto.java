package com.mall.store.dto.response;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GoodsDto {
    private Long id;
    private String name;
    private Date createTime;
}
