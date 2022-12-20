package se.lexicon;

import se.lexicon.DAO.daoImplement.CityDaoJDBC;
import se.lexicon.exception.DBConnectionException;
import se.lexicon.model.City;

public class App
{
    public static void main( String[] args )
    {
//                      findById
        /*try{
            CityDaoJDBC cityDaoJDBC = new CityDaoJDBC();
            cityDaoJDBC.findById(3048);
        } catch(DBConnectionException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }*/
        //-----------------------------------------------------
        
//                       findByCode
        /*try{
            CityDaoJDBC cityDaoJDBC = new CityDaoJDBC();
            cityDaoJDBC.findByCode("SWE");
        } catch(DBConnectionException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }*/
        //-----------------------------------------------------
        
//                      findByName
        /*try{
            CityDaoJDBC cityDaoJDBC = new CityDaoJDBC();
            cityDaoJDBC.findByName("Stockholm");
        } catch(DBConnectionException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }*/
        //-----------------------------------------------------
    
//                      findAll
        /*try{
            CityDaoJDBC cityDaoJDBC = new CityDaoJDBC();
            cityDaoJDBC.findAll();
        } catch(DBConnectionException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }*/
        //-----------------------------------------------------
    
//                      add
        City city = new City("Test_Name","TST", "Test_District", 1);
        try{
            CityDaoJDBC cityDaoJDBC = new CityDaoJDBC();
            cityDaoJDBC.add(city);
        } catch(DBConnectionException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
        
    }//main
}//class
