package com.HotelServices.service;


import com.HotelService.entity.Goods;
import com.HotelService.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    private GoodsRepository goodsRepository;

    public String decomposition(String content) {

        List<Goods> goodsList = new ArrayList<>();

        String[] arr = content.split(" ");
        String[] items = new String[arr.length / 2];
        String[] value = new String[arr.length / 2];

        for(String val : arr)
        System.out.print(val + " ");
//        // 상품
//        for (int i = 0; i < arr.length; i += 2)
//            items[i] = arr[i];
//
//        //갯수
//        for (int i = 1; i <= arr.length; i += 2)
//            value[i] = arr[i];
//
//        if(items != null && value != null) {
//            for (int i = 0; i < items.length; i++) {
//                String item = items[i];
//                Goods goods = goodsRepository.findByItems(item);
//                goodsList.add(goods);
//            }
//        }
//
//        System.out. println(goodsList.get(0));

        return null;
    }
}
