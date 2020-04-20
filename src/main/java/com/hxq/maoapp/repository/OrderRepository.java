/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: OrderRepository
 * Author:   hxq
 * Date:     2020/4/20 21:45
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hxq.maoapp.repository;

import com.hxq.maoapp.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author hxq
 * @create 2020/4/20
 * @since 1.0.0
 */
@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    @Query(value = "select * from orders AS s where s.user_id=:uid  ORDER BY s.id DESC ",nativeQuery = true)
    List<Order> findAllByUserId(@Param("uid")Long userId);

}

