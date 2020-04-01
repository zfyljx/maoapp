/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: QiniuController
 * Author:   hxq
 * Date:     2020/4/1 23:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hxq.maoapp.controllers;

import cn.hutool.core.util.IdUtil;
import com.hxq.maoapp.utils.Result;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author hxq
 * @create 2020/4/1
 * @since 1.0.0
 */
@Controller
public class QiniuController {

    @Value("${qiniu.accessKey}")
    private String accessKey;

    @Value("${qiniu.secretKey}")
    private String secretKey;

    @Value("${qiniu.bucket}")
    private String bucket;

    @GetMapping("/androidgettoken")
    @ResponseBody
    public Result getToken(HttpServletRequest request) {

        Auth auth = Auth.create(accessKey, secretKey);
        HashMap<String, String> object = new HashMap<>();
        object.put("token", auth.uploadToken(bucket));
        object.put("uuid", IdUtil.simpleUUID());

        return new Result(200, "获取token成功", object);
    }

}

