package com.software.dao;

import com.software.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by hasee on 2017/11/6.
 */
@Repository
public class UserDaoImpl{
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    public User getById(int id) {
//        //find by primary key
//        return this.entityManager.find(User.class,id);
//    }
//
//    @Override
//    public User getByNumber(String number) {
//        Query query = this.entityManager.createQuery("from User u where u.number=:number",User.class);
//        query.setParameter("number",number);
//        User user = (User)query.getSingleResult();
//        return user;
//    }
//
//    @Override
//    public int addUser(User user) {
//        this.entityManager.persist(user);
//        //print the id
//        System.out.println(user.getId());
//        return user.getId();
//    }
//
//    @Override
//    public void deleteUserById(int id) {
//        User user = this.entityManager.find(User.class,id); //关联到记录，方可删除
//        this.entityManager.remove(user);
//    }
//
//    @Override
//    public User updateUser(User user) {
//        User userNew = this.entityManager.merge(user);
//        return userNew;
//    }
}
