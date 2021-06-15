package com.HotelService.repository;

import com.HotelService.entity.Goods;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface GoodsRepository extends CrudRepository<Goods, Long> {


}
