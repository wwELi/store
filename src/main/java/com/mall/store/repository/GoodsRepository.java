package com.mall.store.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mall.store.model.Goods;

public interface GoodsRepository extends JpaRepository<Goods, Long> {
    Optional<Goods> findByName(String name);
}
