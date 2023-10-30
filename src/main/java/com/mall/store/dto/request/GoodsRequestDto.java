package com.mall.store.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GoodsRequestDto {

    @NotNull(message = "must name must have")
    @NotBlank
    private String name;   
}
