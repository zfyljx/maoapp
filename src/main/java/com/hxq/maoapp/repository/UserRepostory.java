package com.hxq.maoapp.repository;

import com.hxq.maoapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by hxq on 2020/3/18.
 */
@Repository
public interface UserRepostory extends JpaRepository<User,Long>{
    public Optional<User> findByPhoneNumber(String phoneNumber);

    public Optional<User> findByUserName(String userName);
}
