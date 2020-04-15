/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ShareController
 * Author:   hxq
 * Date:     2020/4/6 0:52
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hxq.maoapp.controllers;

import com.hxq.maoapp.entity.Share;
import com.hxq.maoapp.repository.ShareRepository;
import com.hxq.maoapp.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author hxq
 * @create 2020/4/6
 * @since 1.0.0
 */
@Controller
public class ShareController {


    @Autowired
    private ShareRepository shareRepostory;


    @PostMapping("/postandroidsaveshare")
    @ResponseBody
    public Result saveShare(@RequestParam("id")Long userId,
                            @RequestParam("userName")String userName,
                           @RequestParam("message")String message,
                           @RequestParam("address")String address,
                           @RequestParam("imageOne")String imageOne,
                           @RequestParam("imageTwo")String imageTwo,
                           @RequestParam("imageThree")String imageThree){
        Result res=new Result();
        Share share=new Share();
        share.setAddress(address);
        share.setUserName(userName);
        share.setUserId(userId);
        share.setImageOneUrl(imageOne);
        share.setMessage(message);
        share.setImageTwoUrl(imageTwo);
        share.setImageThreeUrl(imageThree);
        share.setCreatTime(new Date());
        Share userInfo=shareRepostory.save(share);
        if (userInfo != null){
            res.setMessage("发布成功");
            res.setStatus(200);

        }else {
            res.setMessage("发布失败");
            res.setStatus(204);
        }
        return res;
    }


    @GetMapping("/postandroidallsharebyone")
    @ResponseBody
    public Result findAllShareByUserId(@RequestParam("userId")Long userId){
        Result res=new Result();
        List<Share> shares=shareRepostory.findAllByUserId(userId);
        if (shares.size() > 0){
            res.setMessage("查找个人发布成功");
            res.setData(shares);
            res.setStatus(200);

        }else {
            res.setMessage("查找个人发布无结果");
            res.setData(shares);
            res.setStatus(204);
        }
        return res;
    }

    @GetMapping("/postandroidallshares")
    @ResponseBody
    public Result findAllShare(){
        Result res=new Result();
        //TODO
        List<Share> shares=shareRepostory.findAll();
        if (shares.size() > 0){
            res.setMessage("查找所有发布成功");
            res.setData(shares);
            res.setStatus(200);

        }else {
            res.setMessage("查找所有发布无结果");
            res.setData(shares);
            res.setStatus(204);
        }
        return res;
    }
}

