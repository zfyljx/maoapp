/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Share
 * Author:   hxq
 * Date:     2020/4/6 0:53
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
import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author hxq
 * @create 2020/4/6
 * @since 1.0.0
 */
@Entity
@Table(name="share")
public class Share {

    /**
     * 用户id
     * 自增长
     */
    @Id
    @GeneratedValue
    private Long id;


    private Long userId;
    private String userName;
    private String message;
    private String address;

    private String imageOneUrl;

    private String imageTwoUrl;

    private String imageThreeUrl;

    private Date creatTime;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImageOneUrl() {
        return imageOneUrl;
    }

    public void setImageOneUrl(String imageOneUrl) {
        this.imageOneUrl = imageOneUrl;
    }

    public String getImageTwoUrl() {
        return imageTwoUrl;
    }

    public void setImageTwoUrl(String imageTwoUrl) {
        this.imageTwoUrl = imageTwoUrl;
    }

    public String getImageThreeUrl() {
        return imageThreeUrl;
    }

    public void setImageThreeUrl(String imageThreeUrl) {
        this.imageThreeUrl = imageThreeUrl;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    @Override
    public String toString() {
        return "Share{" +
                "id=" + id +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", message='" + message + '\'' +
                ", address='" + address + '\'' +
                ", imageOneUrl='" + imageOneUrl + '\'' +
                ", imageTwoUrl='" + imageTwoUrl + '\'' +
                ", imageThreeUrl='" + imageThreeUrl + '\'' +
                ", creatTime=" + creatTime +
                '}';
    }
}

