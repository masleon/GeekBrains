package ru.geekbrains.marketautumn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;


public class SessionFactoryUtis {

    private SessionFactory factory;

    public void init(){
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

    }

    public Session getSession(){
        return factory.getCurrentSession();
    }

    public void shutdown(){
        if (factory!=null){
            factory.close();
        }
    }
}
