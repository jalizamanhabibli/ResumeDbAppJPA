/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.impl;

import com.company.entity.User;
import com.company.inter.UserInter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Alizaman
 */
public class UserImpl implements UserInter {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.company.ResumeDbAppJPAJar");

    @Override
    public List<User> getAllUsers() {
        EntityManager manager = factory.createEntityManager();
        Query query = manager.createNamedQuery("User.findAll");
        List<User> list = query.getResultList();
        manager.clear();
        return list;
    }

    @Override
    public boolean updateUser(User user) {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.merge(user);
        manager.getTransaction().commit();
        manager.close();
        return true;
    }

    @Override
    public boolean deleteUser(int id) {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        User user = manager.find(User.class, id);
        manager.remove(user);
        manager.getTransaction().commit();
        manager.clear();
        return true;
    }

    @Override
    public boolean insertUser(User user) {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(user);
        manager.getTransaction().commit();
        manager.clear();
        return true;
    }

    @Override
    public User getById(int id) {
        EntityManager manager = factory.createEntityManager();
        User user = manager.find(User.class, id);
        manager.clear();
        return user;
    }

    @Override
    public List<User> searchAllUser(String name, String surname) {
        EntityManager manager = factory.createEntityManager();
        Query query = manager.createQuery("SELECT u FROM User u WHERE u.name LIKE :name AND u.surname LIKE :surname");
        if(name==null){
            name="";
        }
        if(surname==null){
            surname="";
        }
        query.setParameter("name","%" + name + "%");
        query.setParameter("surname", "%" + surname + "%");
        List<User> list = query.getResultList();
        manager.close();
        return list;
    }

}
