package ru.gb.current.server;

import server.DatabaseConnector;

import java.sql.*;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class AuthenticationService {

    public Optional<String> findUsernameByLoginAndPassword(String login, String password) {
         try {
             Connection connection = DatabaseConnector.getConnection();
             Statement statement = connection.createStatement();
             String queryText = "SELECT username FROM chatusers WHERE login = '" + login + "' AND password = '" + password+"'";
             ResultSet rs = statement.executeQuery(queryText);
             if (rs.next()){
                 String username = rs.getString("username");
                 return Optional.of(username);
             }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

}
