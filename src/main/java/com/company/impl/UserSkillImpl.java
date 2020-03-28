package com.company.impl;

import com.company.entity.User;
import com.company.entity.UserSkill;
import com.company.inter.UserSkillInter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserSkillImpl implements UserSkillInter{
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.company.ResumeDbAppJPAJar");
    @Override
    public List<UserSkill> getAllUserSkills(User user) {
        return user.getUserSkillList();
    }

    @Override
    public boolean insertUserSkill(UserSkill userSkill) {
        EntityManager manager=factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(userSkill);
        manager.getTransaction().commit();
        manager.close();
        return true;
    }

    @Override
    public boolean updateUserSkill(UserSkill userSkill) {
        EntityManager manager=factory.createEntityManager();
        manager.getTransaction().begin();
        manager.merge(userSkill);
        manager.getTransaction().commit();
        manager.close();
        return true;
    }

    @Override
    public boolean deleteUserSkill(int userSkillId) {
        EntityManager manager=factory.createEntityManager();
        manager.getTransaction().begin();
        UserSkill userSkill = manager.find(UserSkill.class, userSkillId);
        manager.remove(userSkill);
        manager.getTransaction().commit();
        manager.close();
        return true;
    }
    
}
