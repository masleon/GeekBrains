package ru.geekbrains.marketautumn.dto;

import ru.geekbrains.marketautumn.SessionFactoryUtis;

public class ClientDao {
    SessionFactoryUtis sessionFactoryUtis;

    public ClientDao(SessionFactoryUtis sessionFactoryUtis) {
        this.sessionFactoryUtis = sessionFactoryUtis;
    }

}
