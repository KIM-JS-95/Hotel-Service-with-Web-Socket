package com.HotelService.service;


import com.HotelService.entity.Goods;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class OrderService {

//    private GoodsRepository goodsRepository;
//
//    @Autowired
//    public OrderService(GoodsRepository goodsRepository) {
//        this.goodsRepository = goodsRepository;
//    }

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
//        for (String val : value) {
//            System.out.print(val + " ");
//        }
//
//        for (String val : items) {
//            System.out.print(val + " ");
//        }

        int cnt=0;
        List<Goods> goods = new ArrayList<>();

        if(items != null) {
            while(!items.isEmpty()){
             // goodsRepository.saveAll(items);
            cnt++;
            }
        }else{
            return "해당 상품은 존재하지 않습니다.";
        }

        System.out.print(goods.get(0));


        return null;
    }
}
