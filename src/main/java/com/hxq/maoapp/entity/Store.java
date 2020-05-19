/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Store
 * Author:   hxq
 * Date:     2020/4/29 23:37
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
 *
 * @author hxq
 * @create 2020/4/29
 * @since 1.0.0
 */
@Entity
@Table(name="store")
public class Store {

    @Id
    @GeneratedValue
    private Long id;


    private String name;
    private String phoneNumber;

    private String storeName;

    private Long storeId;

    private String password;
}

