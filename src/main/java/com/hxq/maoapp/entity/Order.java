/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Order
 * Author:   hxq
 * Date:     2020/4/20 21:37
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hxq.maoapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *data class OrderModel(val id:Long,val goodId:Long,val storeId:Long,val storeName:String,
 * val userPhone:String,val userId: Long,val userName: String,val userAddress:String,val name:String,
 * val price:Float,val number:Int,val totalPrice:Float,val status:Int,val imageOne: String,
 * val createTime: String,val deliveryCode: String,val deadTime:String)
 * @author hxq
 * @create 2020/4/20
 * @since 1.0.0
 */
@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue
    private Long id;

    private Long goodId;
    private Long storeId;
    private String storeName;
    private String userPhone;
    private Long userId;
    private String userName;
    private String userAddress;
    private String name;
    private Float price;
    private Integer number;
    private Float totalPrice;
    private Integer status;
    private String imageOne;
    private String createTime;
    private String deliveryCode;
    private String deadTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodId() {
        return goodId;
    }

    public void setGoodId(Long goodId) {
        this.goodId = goodId;
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

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getImageOne() {
        return imageOne;
    }

    public void setImageOne(String imageOne) {
        this.imageOne = imageOne;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getDeliveryCode() {
        return deliveryCode;
    }

    public void setDeliveryCode(String deliveryCode) {
        this.deliveryCode = deliveryCode;
    }

    public String getDeadTime() {
        return deadTime;
    }

    public void setDeadTime(String deadTime) {
        this.deadTime = deadTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", goodId=" + goodId +
                ", storeId=" + storeId +
                ", storeName='" + storeName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", number=" + number +
                ", totalPrice=" + totalPrice +
                ", status=" + status +
                ", imageOne='" + imageOne + '\'' +
                ", createTime='" + createTime + '\'' +
                ", deliveryCode='" + deliveryCode + '\'' +
                ", deadTime='" + deadTime + '\'' +
                '}';
    }
}

