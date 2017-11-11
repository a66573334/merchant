package com.software.service;

import com.software.domain.User;
import com.software.domain.User;

/**
 * Created by hasee on 2017/11/6.
 */
public interface UserService {

    User findById(int id);

    User findByUsername(String number);

    int addUser(User user, boolean throwEx);

    void deleteUserById(int id);

    User updateUser(User user);

    User saveUserWithRollBack(User user);

    User saveUserWithoutRollBack(User user);

}
