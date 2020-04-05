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

    List<Share> findAllByUserId(Long userId);
}

