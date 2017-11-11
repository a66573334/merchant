package com.software.dao;

import com.software.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hasee on 2017/11/6.
 */
public interface UserDao extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
