/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: OrderController
 * Author:   hxq
 * Date:     2020/4/20 22:10
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hxq.maoapp.controllers;

import com.hxq.maoapp.entity.Order;
import com.hxq.maoapp.repository.OrderRepository;
import com.hxq.maoapp.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *  fun buildOrder(@Query("storeId")storeId:Long,@Query("storeName")storeName:Long,
 *  @Query("name")name:String,@Query("userId")userId:Long,@Query("userName")userName:String,
 *  @Query("userPhone")userPhone:String,@Query("userAddress")userAddress:String,
 *  @Query("imagePath")imagePath:String,@Query("price")price:Float,@Query("number")number:Int,
 *  @Query("totalPrice")totalPrice:Float)
 * @author hxq
 * @create 2020/4/20
 * @since 1.0.0
 */
@Controller
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/postandroidbuildorder")
    @ResponseBody
    public Result saveShare(@RequestParam("storeId")Long storeId,
                            @RequestParam("goodId")Long goodId,
                            @RequestParam("storeName")String storeName,
                            @RequestParam("name")String name,
                            @RequestParam("userId")Long userId,
                            @RequestParam("userName")String userName,
                            @RequestParam("userPhone")String userPhone,
                            @RequestParam("userAddress")String userAddress,
                            @RequestParam("imagePath")String imagePath,
                            @RequestParam("price")Float price,
                            @RequestParam("number")Integer number,
                            @RequestParam("totalPrice")Float totalPrice){
        Result res=new Result();
        Order order=new Order();
        order.setCreateTime(getStringDate());
        order.setImageOne(imagePath);
        order.setGoodId(goodId);
        order.setName(name);
        order.setNumber(number);
        order.setPrice(price);
        order.setStatus(0);
        order.setStoreId(storeId);
        order.setStoreName(storeName);
        order.setUserId(userId);
        order.setUserAddress(userAddress);
        order.setUserPhone(userPhone);
        order.setUserName(userName);
        order.setTotalPrice(totalPrice);
        Order orderInfo=orderRepository.save(order);
        if (orderInfo != null){
            res.setMessage("支付成功");
            res.setStatus(200);

        }else {
            res.setMessage("支付失败");
            res.setStatus(204);
        }
        return res;
    }

    @GetMapping("/getandroidorderdetail")
    @ResponseBody
    public Result findOrderById(@RequestParam("orderId")Long id){
        Result res=new Result();
        Optional<Order> order=orderRepository.findById(id);
        if (order.isPresent()){
            res.setMessage("查找订单成功");
            res.setData(order.get());
            res.setStatus(200);

        }else {
            res.setMessage("查找订单无结果");
            res.setStatus(204);
        }
        return res;
    }


    @PostMapping("/postandroidorderstatus")
    @ResponseBody
    public Result resetPassword(@RequestParam("orderId")Long orderId){
        Result res = new Result();
        Optional<Order> orderOptional=orderRepository.findById(orderId);
        if (orderOptional.isPresent()){
            Order order=orderOptional.get();
            order.setStatus(1);
            order.setDeadTime(getStringDate());
            Order orderInfo=orderRepository.save(order);
            if (orderInfo != null){
                res.setMessage("收货成功");
                res.setStatus(200);

            }else {
                res.setMessage("收货失败");
                res.setStatus(204);

            }
        }
        return res;
    }

    @GetMapping("/getandroidmyorder")
    @ResponseBody
    public Result findAllOrdersByUserId(@RequestParam("userId")Long userId){
        Result res=new Result();
        List<Order> orders=orderRepository.findAllByUserId(userId);
        if (orders.size() > 0){
            res.setMessage("查找订单成功");
            res.setData(orders);
            res.setStatus(200);

        }else {
            res.setMessage("查找订单无结果");
            res.setData(orders);
            res.setStatus(204);
        }
        return res;
    }

    public static String getStringDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
}

