package com.company.impl;

import com.company.entity.Skill;
import com.company.inter.SkillInter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class SkillImpl implements SkillInter {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.company.ResumeDbAppJPAJar");

    @Override
    public List<Skill> getAllSkills() {
        EntityManager manager = factory.createEntityManager();
        Query query = manager.createNamedQuery("Skill.findAll");
        List<Skill> list = query.getResultList();
        manager.close();
        return list;
    }

    @Override
    public boolean insertSkill(Skill skill) {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(skill);
        manager.getTransaction().commit();
        manager.close();
        return true;
    }

    @Override
    public boolean deleteSkill(int id) {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        Skill skill = manager.find(Skill.class, id);
        manager.remove(skill);
        manager.getTransaction().commit();
        manager.close();
        return true;
    }

}
