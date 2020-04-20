/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Sell
 * Author:   hxq
 * Date:     2020/4/20 21:48
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hxq.maoapp.entity;

import javax.persistence.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *data class SellModel(val id:Long,val storeId:Long,val storeName:String,
 * val userPhone:String,val userId: Long,val userName: String,val name:String,
 * val price:Float,val monthSell:Int,val introduction:String,val description:String,
 * val imageOne: String,val imageTwo: String,val imageThree: String)
 * @author hxq
 * @create 2020/4/20
 * @since 1.0.0
 */
@Entity
@Table(name="sell")
public class Sell {
    @Id
    @GeneratedValue
    private Long id;

    private Long storeId;
    private String storeName;
    private String userPhone;
    private Long userId;
    private String userName;
    private String name;
    private Float price;
    private Integer monthSell;
    private String introduction;
    private String description;
    private String imageOne;
    private String imageTwo;
    private String imageThree;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getMonthSell() {
        return monthSell;
    }

    public void setMonthSell(Integer monthSell) {
        this.monthSell = monthSell;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageOne() {
        return imageOne;
    }

    public void setImageOne(String imageOne) {
        this.imageOne = imageOne;
    }

    public String getImageTwo() {
        return imageTwo;
    }

    public void setImageTwo(String imageTwo) {
        this.imageTwo = imageTwo;
    }

    public String getImageThree() {
        return imageThree;
    }

    public void setImageThree(String imageThree) {
        this.imageThree = imageThree;
    }

    @Override
    public String toString() {
        return "Sell{" +
                "id=" + id +
                ", storeId=" + storeId +
                ", storeName='" + storeName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", monthSell=" + monthSell +
                ", introduction='" + introduction + '\'' +
                ", description='" + description + '\'' +
                ", imageOne='" + imageOne + '\'' +
                ", imageTwo='" + imageTwo + '\'' +
                ", imageThree='" + imageThree + '\'' +
                '}';
    }
}

