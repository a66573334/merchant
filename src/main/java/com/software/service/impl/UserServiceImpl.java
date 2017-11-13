package com.software.service.impl;

import com.software.dao.UserDao;
import com.software.domain.PageVO;
import com.software.domain.User;
import com.software.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hasee on 2017/11/6.
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public User findById(int id) {
        return userDao.findOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public int addUser(User user, boolean throwEx) {
        User user1 = this.userDao.save(user);
        if (throwEx) {
            throw new RuntimeException("throw a ex");
        }
        return user1.getId();
    }

    @Override
    public void deleteUserById(int id) {
        this.userDao.delete(id);
    }

    @Override
    public User updateUser(User user) {
        return this.userDao.save(user);
    }

    @Transactional(rollbackFor = {IllegalArgumentException.class})
    @Override
    public User saveUserWithRollBack(User user) {
        User p = userDao.save(user);
        if (user.getUsername().equals("sang")) {
            throw new IllegalArgumentException("sang 已存在，数据将回滚");
        }
        return p;
    }

    @Transactional(noRollbackFor = {IllegalArgumentException.class})
    @Override
    public User saveUserWithoutRollBack(User user) {
        User p = userDao.save(user);
        if (user.getUsername().equals("sang")) {
            throw new IllegalArgumentException("sang已存在，但数据不会回滚");
        }
        return p;
    }

    @Transactional(readOnly = true)
    @Override
    public Page<User> getAll(int page, int rows) {
        Sort sort = new Sort(Sort.Direction.ASC,"id");
        Pageable pageable = new PageRequest(page - 1, rows,sort);
        Page<User> pageResult = userDao.findAll(pageable);
        return pageResult;
    }

    @Transactional(readOnly = true)
    @Override
    public Page<User> getAllByUsername(User user, PageVO page) {
        Sort sort = new Sort(Sort.Direction.ASC,"id");
        Pageable pageable = new PageRequest(page.getPage() - 1, page.getRows(),sort);
//        Page<User> pageResult = userDao.findAllByUsername(user.getUsername(),pageable);
        Page<User> pageResult = userDao.findByUsernameContainingAllIgnoringCase(user.getUsername(),pageable);
        return pageResult;
    }
}
