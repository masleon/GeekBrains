package ru.geekbrains.marketautumn.dto;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.geekbrains.marketautumn.SessionFactoryUtis;

import java.util.List;

public class ProductDao {

    SessionFactoryUtis sessionFactoryUtis;

    public ProductDao(SessionFactoryUtis sessionFactoryUtis) {
        this.sessionFactoryUtis = sessionFactoryUtis;
    }

    public Product findById(Long id){
        try(Session session = sessionFactoryUtis.getSession()){
            session.beginTransaction();
            Product product = session.get(Product.class,id);
            session.getTransaction().commit();
            return product;
        }
    }

    public List<Product> findAll(){
        try(Session session = sessionFactoryUtis.getSession()){
            session.beginTransaction();
            List<Product> products = session.createQuery("select p from Product p").getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    public void saveOrUpdate(Product product){

    }
    public void deleteByID(Long id){
        try(Session session = sessionFactoryUtis.getSession()){
            session.beginTransaction();
            session.createQuery("delete Product where id = :id")
                    .setParameter("id",id)
                    .executeUpdate();
            session.getTransaction().commit();
        }
    }
    public void save(Product product){
        try(Session session = sessionFactoryUtis.getSession()){
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }
    }
}
