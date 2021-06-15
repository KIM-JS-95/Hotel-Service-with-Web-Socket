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

      //  List<Goods> goodsList = new ArrayList<>();

        String[] arr = content.split(" ");
        List<String> items = new ArrayList<String>();
        List<String> value = new ArrayList<String>();


//        for(int i=0; i< arr.length; i++){
//            System.out.println(i + ":" + arr[i]);
//        }

        for (int i = 1; i <= arr.length; i++) {
            if(i%2==0){
                value.add(arr[i-1]);
            }else
                items.add(arr[i-1]);
        }

        //apple 10 banana 1
        for (String val : value) {
            System.out.print(val + " ");
        }

        for (String val : items) {
            System.out.print(val + " ");
        }


        if(items != null && value != null) {
            for (int i = 0; i < items.length; i++) {
                String item = items[i];
                Goods goods = goodsRepository.findByItems(item);
                goodsList.add(goods);
            }
        }


        return null;
    }
}
