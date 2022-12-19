package se.lexicon.DAO.daoImplement;

import se.lexicon.DAO.CityDao;
import se.lexicon.MySQLConnection;
import se.lexicon.exception.DBConnectionException;
import se.lexicon.model.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDaoJDBC implements CityDao {
    
    public CityDaoJDBC() throws DBConnectionException {
    }
    
        @Override
        public City findById ( int id ){
        String query = "select * from city where id = ?";
        
        int cityId = 3048;
        try(
                Connection connection = MySQLConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)
                ) {
            
            preparedStatement.setInt(1, cityId);
            
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt("ID"));
                    System.out.println(resultSet.getString("Name"));
                    System.out.println(resultSet.getString("CountryCode"));
                    System.out.println(resultSet.getString("District"));
                    System.out.println(resultSet.getString("Population"));
                    System.out.println();
                }
            }
        }catch(DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
        
        @Override
        public List<City> findByCode ( String code ){
            List<City> list = new ArrayList<>();
            String query = "select * from city where CountryCode = ?";
            
            try(
                    Connection connection = MySQLConnection.getConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement(query)
                    ) {
                preparedStatement.setString(1, "SWE");
                
                try(ResultSet resultSet = preparedStatement.executeQuery()) {
                    
                    while (resultSet.next()) {
                        System.out.println(resultSet.getInt("ID"));
                        System.out.println(resultSet.getString("Name"));
                        System.out.println(resultSet.getString("CountryCode"));
                        System.out.println(resultSet.getString("District"));
                        System.out.println(resultSet.getString("Population"));
                        System.out.println();
                    }
                }
                
            }catch(DBConnectionException | SQLException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        return list;
    }
        
        @Override
        public List<City> findByName ( String name ){
            List<City> list = new ArrayList<>();
            String query = "select * from city where name = ?";
    
            try(
                    Connection connection = MySQLConnection.getConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement(query)
            ) {
                preparedStatement.setString(1, "Stockholm");
                
                try(ResultSet resultSet = preparedStatement.executeQuery()) {
                    
                    while (resultSet.next()) {
                        System.out.println(resultSet.getInt("ID"));
                        System.out.println(resultSet.getString("Name"));
                        System.out.println(resultSet.getString("CountryCode"));
                        System.out.println(resultSet.getString("District"));
                        System.out.println(resultSet.getString("Population"));
                        System.out.println();
                    }
                }
        
            } catch(DBConnectionException | SQLException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            
            return list;
    }
        
        @Override
        public List<City> findAll ( ) {
        List<City> list = new ArrayList<>();
                String query = "select * from city";
        
        try(
                Connection connection = MySQLConnection.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                ) {
            
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("ID"));
                System.out.println(resultSet.getString("Name"));
                System.out.println(resultSet.getString("CountryCode"));
                System.out.println(resultSet.getString("District"));
                System.out.println(resultSet.getString("Population"));
                System.out.println();
            }
            
        } catch(DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
        return list;
    }
//        Todo
        @Override
        public City add ( City city ){
        String queryCity = "insert into city(Name, CountryCode, District, Population) values (?,?,?,?)";
        String queryCountry = "insert into country (Code) values (?) where CountryCode = ?";
        
        try(
                Connection connection = MySQLConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(queryCity);
        ) {
            
            connection.setAutoCommit(false);
            
            preparedStatement.setString(1, "Test_Name");
            preparedStatement.setString(2, "TST");
            preparedStatement.setString(3, "Test_District");
            preparedStatement.setInt(4, 1);
            
            int newCity = preparedStatement.executeUpdate();
            System.out.println(newCity + " added");
            
            try(
                    PreparedStatement preparedStatementCountry = connection.prepareStatement(queryCountry)
                    ){
                
                preparedStatementCountry.setString(1, "TST");
                
                preparedStatementCountry.executeUpdate();
            }
            
            connection.commit();
            
        } catch(DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
        return city;
    }
        
        @Override
        public City update ( City city ){
            int cityId = 1;
            String query = "update city set(Name, CountryCode, District, Population) values (?,?,?,?) where id = ?";
            
            try (
                    Connection connection = MySQLConnection.getConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                ) {
                preparedStatement.setString(1, "Test_Name_Updated");
                preparedStatement.setString(2, "xxx");
                preparedStatement.setString(3, "Test_District_Updated");
                preparedStatement.setInt(4, 2);
                preparedStatement.setInt(1, cityId);
    
                int rowAffected = preparedStatement.executeUpdate();
                System.out.println(rowAffected);
    
                
                
            } catch(DBConnectionException | SQLException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            return city;
    }
        
        @Override
        public City delete ( City city ){
        int cityId = 2;
        String query = "delete from city where id = ?";
        
        try(
                Connection connection = MySQLConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
    
            preparedStatement.setInt(1, cityId);
    
            int rowAffected = preparedStatement.executeUpdate();
            System.out.println(rowAffected);
    
        } catch(DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return city;
    }
    
}