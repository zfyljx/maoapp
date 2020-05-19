package com.hxq.maoapp.repository;

import com.hxq.maoapp.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hxq on 2020/4/29.
 */
@Repository
public interface StoreRepository extends JpaRepository<Store,Long> {
}
