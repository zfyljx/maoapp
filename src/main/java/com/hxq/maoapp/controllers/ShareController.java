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
import org.springframework.data.domain.Sort;
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
 *@RequestParam("message")String message,
 *
 * @author jmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
 * @create 2020/4/6
 * @since 1.0.0
 */
@Controller
public class ShareController {


    @Autowired
    private ShareRepository shareRepostory;


    @PostMapping("/postandroidsaveshare")
    @ResponseBody
    public Result saveShare(@RequestParam("userId")Long userId,
                            @RequestParam("userName")String userName,
                           @RequestParam("message")String message,
                           @RequestParam("address")String address,
                           @RequestParam("imageOne")String imageOne,
                           @RequestParam("imageTwo")String imageTwo,
                           @RequestParam("imageThree")String imageThree,
                            @RequestParam("classification")Integer classification,
                            @RequestParam("userImage")String userImage){
        Result res=new Result();
        Share share=new Share();
        share.setAddress(address);
        share.setUserName(userName);
        share.setUserId(userId);
        share.setImageOne(imageOne);
        share.setMessage(message);
        share.setImageTwo(imageTwo);
        share.setImageThree(imageThree);
        share.setCreateTime(getStringDate());
        share.setClassification(classification);
        share.setUserImage(userImage);
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


    @GetMapping("/getandroidmineshares")
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

    @GetMapping("/getandroidusershares")
    @ResponseBody
    public Result findShareByUserId(@RequestParam("userId")Long userId){
        Result res=new Result();
        List<Share> shares=shareRepostory.findAllByUserId(userId);
        if (shares.size() > 0){
            res.setMessage("查找用户发布成功");
            res.setData(shares);
            res.setStatus(200);

        }else {
            res.setMessage("查找用户发布无结果");
            res.setData(shares);
            res.setStatus(204);
        }
        return res;
    }

    @GetMapping("/getandroidshares")
    @ResponseBody
    public Result findAllShare(){
        Result res=new Result();
        //TODO

        List<Share> shares=shareRepostory.findAll(Sort.by(Sort.Direction.DESC,"id"));
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

    @GetMapping("/getandroidqueryshares")
    @ResponseBody
    public Result findAllShareByQuery(@RequestParam("query")String query){
        Result res=new Result();
        List<Share> shares=shareRepostory.findAllByMessageLike(query);
        if (shares.size() > 0){
            res.setMessage("查找发布成功");
            res.setData(shares);
            res.setStatus(200);

        }else {
            res.setMessage("查找发布无结果");
            res.setData(shares);
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


    @PostMapping("/postandroidsharestatus")
    @ResponseBody
    public Result updateShare(@RequestParam("id")Long id
                                ){
        Result res = new Result();
        Optional<Share> share=shareRepostory.findById(id);
        if (share.isPresent()){
            Share share1=share.get();
            share1.setStatus(1);
           Share share2=shareRepostory.save(share1);
            if (share2 != null){
                res.setMessage("认领确认成功");
                res.setStatus(200);

            }else {
                res.setMessage("认领确认失败");
                res.setStatus(204);

            }
        }
        return res;
    }
}

