/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: SellController
 * Author:   hxq
 * Date:     2020/4/20 21:56
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hxq.maoapp.controllers;

import com.hxq.maoapp.entity.Sell;
import com.hxq.maoapp.repository.SellRepository;
import com.hxq.maoapp.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author hxq
 * @create 2020/4/20
 * @since 1.0.0
 */
@Controller
public class SellController {


    @Autowired
    private SellRepository sellRepository;

    @GetMapping("/getandroidallsells")
    @ResponseBody
    public Result findAllOrders(){
        Result res=new Result();
        //TODO

        List<Sell> sells=sellRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
        if (sells.size() > 0){
            res.setMessage("查找所有发布成功");
            res.setData(sells);
            res.setStatus(200);

        }else {
            res.setMessage("查找所有发布无结果");
            res.setData(sells);
            res.setStatus(204);
        }
        return res;
    }


    @GetMapping("/getandroidsell")
    @ResponseBody
    public Result findSellById(@RequestParam("sellId")Long id){
        Result res=new Result();
        Optional<Sell> sells=sellRepository.findById(id);
        if (sells.isPresent()){
            res.setMessage("查找商品成功");
            res.setData(sells.get());
            res.setStatus(200);

        }else {
            res.setMessage("查找商品无结果");
            res.setStatus(204);
        }
        return res;
    }

    @GetMapping("/getandroidsellsbyuserid")
    @ResponseBody
    public Result findAllSellsByUserId(@RequestParam("userId")Long userId){
        Result res=new Result();
        List<Sell> sells=sellRepository.findAllByUserId(userId);
        if (sells.size() > 0){
            res.setMessage("查找店家商品成功");
            res.setData(sells);
            res.setStatus(200);

        }else {
            res.setMessage("查找店家商品无结果");

            res.setStatus(204);
        }
        return res;
    }

    @GetMapping("/getandroidquerysells")
    @ResponseBody
    public Result findAllSellsQuery(@RequestParam("query")String query){
        Result res=new Result();
        List<Sell> sells=sellRepository.findAllByMessageLike(query);
        if (sells.size() > 0){
            res.setMessage("查找店家商品成功");
            res.setData(sells);
            res.setStatus(200);

        }else {
            res.setMessage("查找店家商品无结果");

            res.setStatus(204);
        }
        return res;
    }


}

