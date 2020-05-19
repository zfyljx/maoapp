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

    @Query(value = "select * from sell where classification=:uid",nativeQuery = true)
    List<Sell> findAllByClassification(@Param("uid")Long classification);

    @Query(value = "select * from sell AS s where s.name like %:msa% or s.description like %:msa% or s.introduction like %:msa% or s.store_name like %:msa% ORDER BY s.id DESC ",nativeQuery = true)
    List<Sell> findAllByMessageLike(@Param("msa") String msa);

}

