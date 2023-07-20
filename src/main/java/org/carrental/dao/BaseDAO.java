package org.carrental.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
    static private String DB_URL ="jdbc:mysql://localhost:3306/car_rental";
    static private String USER   ="root";
    static private String PASS   ="Stepway@123+";

    Connection conn;

    BaseDAO(){
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        }catch (SQLException e){
                e.printStackTrace();
        }


    }
}
