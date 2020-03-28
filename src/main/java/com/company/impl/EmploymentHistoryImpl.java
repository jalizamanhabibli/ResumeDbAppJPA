package com.company.impl;

import com.company.entity.EmploymentHistory;
import com.company.entity.User;
import com.company.inter.EmploymentHistoryInter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmploymentHistoryImpl implements EmploymentHistoryInter {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.company.ResumeDbAppJPAJar");

    @Override
    public List<EmploymentHistory> getAllEmploymentHistorys(User user) {
        return user.getEmploymentHistoryList();
    }

    @Override
    public boolean insertEmploymentHistory(EmploymentHistory history) {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(history);
        manager.getTransaction().commit();
        manager.close();
        return true;
    }

    @Override
    public boolean deleteEmploymentHistory(int EmploymentId) {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        EmploymentHistory history=manager.find(EmploymentHistory.class, EmploymentId);
        manager.remove(history);
        manager.getTransaction().commit();    
        manager.close();
        return true;
    }

    @Override
    public boolean updateEmploymentHistory(EmploymentHistory history) {
        EntityManager manager=factory.createEntityManager();
        manager.getTransaction().begin();
        manager.merge(history);
        manager.getTransaction().commit();
        manager.close();
        return true;
    }

}
