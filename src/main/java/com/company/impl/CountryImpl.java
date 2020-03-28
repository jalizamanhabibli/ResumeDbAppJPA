package com.company.impl;

import com.company.entity.Country;
import com.company.entity.User;
import com.company.inter.CountryInter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CountryImpl implements CountryInter {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.company.ResumeDbAppJPAJar");

    @Override
    public List<Country> getAllCountries() {
        EntityManager manager = factory.createEntityManager();
        Query query = manager.createNamedQuery("Country.findAll");
        List<Country> list=query.getResultList();
        manager.close();
        return list;
    }

    @Override
    public Country getCountryByUser(User user) {
        return user.getBirthplaceId();
    }

    @Override
    public boolean insertCountry(Country country) {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(country);
        manager.getTransaction().commit();
        manager.close();
        return true;      
    }

}
