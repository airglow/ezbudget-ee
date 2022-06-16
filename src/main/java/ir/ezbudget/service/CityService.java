package ir.ezbudget.service;

import ir.ezbudget.entity.City;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class CityService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<City> list() {
        return entityManager.createQuery("from City c", City.class).getResultList();
    }

}
