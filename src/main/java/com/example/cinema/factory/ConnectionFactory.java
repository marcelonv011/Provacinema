package com.example.cinema.factory;

import java.sql.*;

public class ConnectionFactory {
        public Connection getConnection(){
            try{
                return DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "");
            }catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
