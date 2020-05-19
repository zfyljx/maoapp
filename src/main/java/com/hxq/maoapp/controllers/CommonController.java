/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: CommonController
 * Author:   hxq
 * Date:     2020/4/6 0:58
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hxq.maoapp.controllers;

import com.hxq.maoapp.entity.Sell;
import com.hxq.maoapp.utils.Result;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author hxq
 * @create 2020/4/6
 * @since 1.0.0
 */
@Controller
public class CommonController {

    @Value("${amap.key}")
    private String key;


    @ResponseBody
    @GetMapping(value = "/getandroidaddressdetail" )
    public Result findAddressByLat(@RequestParam(value = "latitude" ,required = false) String lat,
                                   @RequestParam(value = "longitude" ,required = false) String lng) throws IOException {
        StringBuilder resultData = new StringBuilder();
        StringBuilder https = new StringBuilder("http://restapi.amap.com/v3/geocode/regeo?key=");
//经纬度地址

        String amapKey="c2b28fbb3b43b8f57ee0b78f229752af";
        StringBuilder localhost = new StringBuilder("&location="+lng+","+lat);
        StringBuilder httpsTail = new StringBuilder("&poitype=&radius=&extensions=base&batch=true");
        String url = https.append(amapKey).append(localhost).append(httpsTail).toString();
        //拼接出来的地址
        //System.out.println(https1.append(key).append(localhost1).append(httpsTail).toString());
        // String url ="http://restapi.amap.com/v3/geocode/regeo?key=自己申请的key&location=116.310003,39.991957&poitype=&radius=&extensions=base&batch=true&roadlevel=";
        URL myURL = null;
        URLConnection httpsConn = null;
        try {
            myURL = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        InputStreamReader insr = null;
        BufferedReader br = null;
        try {
            httpsConn = myURL.openConnection();// 不使用代理
            if (httpsConn != null) {
                insr = new InputStreamReader(httpsConn.getInputStream(), "UTF-8");
                br = new BufferedReader(insr);
                String data = null;
                while ((data = br.readLine()) != null) {
                    resultData.append(data);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (insr != null) {
                insr.close();
            }
            if (br != null) {
                br.close();
            }
        }
        System.out.println(resultData);
        if (resultData.toString().indexOf("regeocodes") == 0) {
            return null;
        }
        String str = JSONObject.fromObject(resultData.toString()).getString("regeocodes");
//            String formatted_address = String.valueOf(str.indexOf("formatted_address"));
//            return formatted_address;
//        System.out.println(str);
//
        //城市切割
//            String[] strr = str.split("\",\"city\":\"");
//            if (strr.length < 2 && strr.length == 1) {
//                //直辖市
//                String[] sr = str.split("\"province\":\"");
//                String[] srr = sr[1].split("\",\"city");
//                return srr[0];
//            }
        //非直辖市
//            String[] strrr = strr[1].split("\",\"citycode\":");
//            return strrr[0];
//
        JSONArray jsonArray = new JSONArray().fromObject(str);
        Object formatted_address = jsonArray.getJSONObject(0).get("formatted_address");
        System.out.println(formatted_address);
        String s = formatted_address.toString();
        HashMap<String, String> object = new HashMap<>();
        object.put("address",s);

        return new Result(200,"获取位置成功",object);

    }


    @RequestMapping(value = "/pppp")
    public String fun(Model model){
        ArrayList<Sell> sells = new ArrayList<Sell>();
        Sell sell=new Sell();
        Sell sell1=new Sell();
        sell.setName("皇家幼年猫粮");
        sell.setIntroduction("皇家幼年猫粮适合1-6个月小猫");
        sell.setDescription("5000g;保质期12个月；适合11-6个月的猫咪食用；顺毛发；发腮");
        sell.setMonthSell(23);
        sell.setPrice(55.5f);
        sell1.setName("皇家成年猫粮");
        sell1.setIntroduction("皇家幼年猫粮适合大于6个月小猫");
        sell1.setDescription("5000g;保质期12个月；适合大于的猫咪食用；顺毛发；发腮；增肥");
        sell1.setMonthSell(23);
        sell1.setPrice(55.5f);
        sells.add(sell);
        sells.add(sell1);
        model.addAttribute("emps",sells);
        return "redirect:/pmain.html";
    }

    @RequestMapping(value = "/add")
    public String fun1111(Model model){
        return "redirect:/add.html";
    }
}

