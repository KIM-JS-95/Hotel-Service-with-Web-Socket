package com.HotelService.repository;

import com.HotelService.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository extends JpaRepository<Long, Goods> {

    Goods findByItems(String item);
}
