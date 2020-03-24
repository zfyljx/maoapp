/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: LoginController
 * Author:   hxq
 * Date:     2020/3/18 22:50
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hxq.maoapp.controllers;

import com.hxq.maoapp.entity.User;
import com.hxq.maoapp.repository.UserRepostory;
import com.hxq.maoapp.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author hxq
 * @create 2020/3/18
 * @since 1.0.0
 */
@Controller
public class LoginController {

    @Autowired
    private UserRepostory userRepostory;


    @GetMapping("/getandroidlogin")
    @ResponseBody
    public Result Login(@RequestParam("phoneNumber")String phoneNumber,
                        @RequestParam("password")String password){

        Result res = new Result();
        Optional<User> userOptional=userRepostory.findByPhoneNumber(phoneNumber);
        if (userOptional.isPresent()){
            if (userOptional.get().getPassword().equals(password)){
                res.setData(userOptional.get());
                res.setMessage("登陆成功");
                res.setStatus(200);
            }else {
                res.setMessage("登陆失败，密码错误");
                res.setStatus(203);

            }
        }else {
            res.setStatus(204);
            res.setMessage("登陆失败，手机号未注册");

        }
        return res;
    }

    @PostMapping("/postandroidresetpassword")
    @ResponseBody
    public Result resetPassword(@RequestParam("phoneNumber")String phoneNumber,
                     @RequestParam("password")String password){
        Result res = new Result();
        Optional<User> userOptional=userRepostory.findByPhoneNumber(phoneNumber);
        if (userOptional.isPresent()){
           User user=userOptional.get();
           user.setPassword(password);
           User userInfo=userRepostory.save(user);
           if (userInfo != null){
               res.setData(userOptional.get());
               res.setMessage("重置密码成功");
               res.setStatus(200);

           }else {
               res.setMessage("重置密码失败");
               res.setStatus(204);

           }
        }
        return res;
    }

    @GetMapping("/getandroidphonenumberisonly")
    @ResponseBody
    public Result phoneNumberIsOnly(@RequestParam("phoneNumber")String phoneNumber){

        Result res = new Result();
        Optional<User> userOptional=userRepostory.findByPhoneNumber(phoneNumber);
        if (userOptional.isPresent()){
                res.setMessage("验证成功，手机号码第一次使用");
                res.setStatus(200);


        }else {
            res.setStatus(204);
            res.setMessage("手机号已被注册");

        }
        return res;
    }
}

