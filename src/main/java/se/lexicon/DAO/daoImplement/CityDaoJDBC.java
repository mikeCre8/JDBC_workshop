package se.lexicon.DAO.daoImplement;

import se.lexicon.DAO.CityDao;
import se.lexicon.MySQLConnection;
import se.lexicon.exception.DBConnectionException;
import se.lexicon.model.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDaoJDBC implements CityDao {
    
    public CityDaoJDBC() {
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

        @Override
        public City add ( City city ){
            System.out.println("city = " + city);
    
            String queryCity = "insert into city(Name, CountryCode, District, Population) values (?,?,?,?)";
            
        try(
                Connection connection = MySQLConnection.getConnection();
                PreparedStatement preparedStatementCity = connection.prepareStatement(queryCity, Statement.RETURN_GENERATED_KEYS);
        ) {
            preparedStatementCity.setString(1, city.getName());
            preparedStatementCity.setString(2, city.getCode());
            preparedStatementCity.setString(3, city.getDistrict());
            preparedStatementCity.setInt(4, city.getPopulation());
            
            int newCity = preparedStatementCity.executeUpdate();
            System.out.println(newCity + " row added");
            
            try (
                    ResultSet resultSet = preparedStatementCity.getGeneratedKeys()
                    ){
                if(resultSet.next()){
                    city.setId(resultSet.getInt(1));
                }
            }
            
        } catch(DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return city;
    }
    
        @Override
        public City update ( City city ){
            int cityId = 4090;
            String query = "update city set Population = 20 where id = ?";
            
            try (
                    Connection connection = MySQLConnection.getConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                ) {
                
                preparedStatement.setInt(1, cityId);
    
                int rowAffected = preparedStatement.executeUpdate();
                System.out.println(rowAffected + " row updated!");
                
            } catch(DBConnectionException | SQLException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            return city;
    }
        
        @Override
        public City delete ( City city ){
        int cityId = 4091;
        String query = "delete from city where id = ?";
        
        try(
                Connection connection = MySQLConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
    
            preparedStatement.setInt(1, cityId);
    
            int rowAffected = preparedStatement.executeUpdate();
            System.out.println(rowAffected + " row deleted!");
    
        } catch(DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return city;
    }
    
}
