package se.lexicon;

import se.lexicon.exception.DBConnectionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    
    private static final String JDBC_USER = "root";
    private static final String JDBC_PW = "root";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/world";
    
    public static Connection getConnection() throws DBConnectionException {
        try {
            return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PW);
        } catch(SQLException e) {
            throw new DBConnectionException("Database connection failure!");
        }
    }
    
}
