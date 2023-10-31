package com.mall.store.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mall.store.model.Goods;
import com.mall.store.repository.GoodsRepository;

@ExtendWith(MockitoExtension.class)
public class GoodsServiceTest {
    @InjectMocks
    private GoodsService goodsService;

    @Mock
    GoodsRepository goodsRepository;

    @Test
    public void should_return_names_string_when_get_name() {
        when(goodsRepository.findAll()).thenReturn(List.of());
        String names = goodsService.genGoodsName();
        assertEquals("", names);

        Goods goods1 = new Goods();
        Goods goods2 = new Goods();
        goods1.setName("name1");
        goods2.setName("name2");

        when(goodsRepository.findAll()).thenReturn(List.of(goods1, goods2));
        String names2 = goodsService.genGoodsName();
        assertEquals("name1,name2", names2);
    }
}
