package com.shandov.project1jdbc.dao;


import lombok.Getter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

public abstract class GenericDAO<T, ID> {

     public abstract Class<T> getEntityClass();

     @Getter
     private final EntityManager entityManager;

     GenericDAO(){
         EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-test");
         this.entityManager = entityManagerFactory.createEntityManager();
     }

     public void save (T entity){
         EntityManager em = getEntityManager();
         em.getTransaction().begin();
         em.persist(entity);
         em.getTransaction().commit();
         em.close();
     }


     public void update(T entity, ID id){
         EntityManager em = getEntityManager();
         em.getTransaction().begin();
         T entityFromDB = em.find(getEntityClass(), id);
         em.merge(entity);
         em.persist(entityFromDB);
         em.getTransaction().commit();
         em.close();
     }


     public void delete(ID id){
         EntityManager em = getEntityManager();
         em.getTransaction().begin();
         T entityFromDB = em.find(getEntityClass(), id);
         em.remove(entityFromDB);
         em.getTransaction().commit();
         em.close();
     }

     public Optional<T> findById(ID id){
         EntityManager em = getEntityManager();
         T entityFromDB = em.find(getEntityClass(), id);
         em.close();
         return Optional.ofNullable(entityFromDB);
     }
}
