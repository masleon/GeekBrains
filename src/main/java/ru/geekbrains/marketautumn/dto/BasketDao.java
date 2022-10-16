package ru.geekbrains.marketautumn.dto;

import org.hibernate.Session;
import ru.geekbrains.marketautumn.SessionFactoryUtis;

import java.util.List;

public class BasketDao {
    SessionFactoryUtis sessionFactoryUtis;

    public BasketDao(SessionFactoryUtis sessionFactoryUtis) {
        this.sessionFactoryUtis = sessionFactoryUtis;
    }

    public Basket findById(Long id){
        try(Session session = sessionFactoryUtis.getSession()){
            session.beginTransaction();
            Basket basket = session.get(Basket.class,id);
            session.getTransaction().commit();
            return basket;
        }
    }
    public List<Basket> findAll(){
        try(Session session = sessionFactoryUtis.getSession()){
            session.beginTransaction();
            List<Basket> baskets = session.createQuery("select b from basket b").getResultList();
            session.getTransaction().commit();
            return baskets;
        }
    }
}
