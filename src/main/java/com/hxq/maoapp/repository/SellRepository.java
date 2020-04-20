package com.hxq.maoapp.repository;

import com.hxq.maoapp.entity.Sell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hxq on 2020/4/20.
 */
@Repository
public interface SellRepository extends JpaRepository<Sell,Long> {

    @Query(value = "select * from sell AS s where s.user_id=:uid  ORDER BY s.id DESC ",nativeQuery = true)
    List<Sell> findAllByUserId(@Param("uid")Long userId);

    @Query(value = "select * from sell where id=:uid",nativeQuery = true)
    Sell findSellById(@Param("uid")Long id);

}

