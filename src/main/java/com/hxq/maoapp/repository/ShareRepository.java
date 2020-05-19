/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ShareRepository
 * Author:   hxq
 * Date:     2020/4/6 0:56
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hxq.maoapp.repository;

import com.hxq.maoapp.entity.Share;
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
 * @create 2020/4/6
 * @since 1.0.0
 */
@Repository
public interface ShareRepository extends JpaRepository<Share,Long> {
    @Query(value = "select * from share AS s where s.user_id=:uid  ORDER BY s.id DESC ",nativeQuery = true)
    List<Share> findAllByUserId(@Param("uid")Long userId);

//    @Query(value = "select id,user_id,user_name,message,address,creat_time,image_one_url,image_two_url,image_three_url from share  s where s.message like '%:mea%' or s.address like '%:mea%' or s.user_name like '%:mea%'")
//    List<Share> findAllByMessageOrAddressLike(@Param("mea")String mea);

    @Query(value = "select * from share AS s where s.message like %:msa% or s.address like %:msa% or s.user_name like %:msa%  ORDER BY s.id DESC ",nativeQuery = true)
    List<Share> findAllByMessageLike(@Param("msa") String msa);

    @Query(value = "select * from share AS s where s.address like %:msa% ORDER BY s.id DESC ",nativeQuery = true)
    List<Share> findAllByAddressLike(@Param("msa")String msa);

    @Query(value = "select * from share AS s where s.user_name like %:msa%  ORDER BY s.id DESC ",nativeQuery = true)
    List<Share> findAllByUserNameLike(@Param("msa")String msa);


}

