/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: RegisterController
 * Author:   hxq
 * Date:     2020/3/19 13:18
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
 * @create 2020/3/19
 * @since 1.0.0
 */
@Controller
public class RegisterController {

    @Autowired
    private UserRepostory userRepostory;

    @PostMapping("/postandroidregister")
    @ResponseBody
    public Result register(@RequestParam("phoneNumber")String phoneNumber,
                        @RequestParam("password")String password,
                        @RequestParam("userName")String userName){
        User user=new User();
        Result res=new Result();
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        user.setUserName(userName);
        User userInfo=userRepostory.save(user);
        if (userInfo != null){
            res.setMessage("注册成功");
            res.setStatus(200);
            res.setData(userInfo);

        }else {
            res.setMessage("注册失败");
            res.setStatus(204);
        }
        return res;
    }

    @GetMapping("/getandroidusernameisonly")
    @ResponseBody
    public Result userNameIsOnly(@RequestParam("userName")String userName){

        Result res = new Result();
        Optional<User> userOptional=userRepostory.findByUserName(userName);
        if (!userOptional.isPresent()){
            res.setMessage("验证成功，用户名第一次使用");
            res.setStatus(200);


        }else {
            res.setStatus(204);
            res.setMessage("用户名已被注册");

        }
        return res;
    }

}

