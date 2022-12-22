package se.lexicon;

import se.lexicon.DAO.daoImplement.CityDaoJDBC;
import se.lexicon.model.City;

public class App
{
    public static void main( String[] args )
    {
        CityDaoJDBC cityDaoJDBC = new CityDaoJDBC();
        
            cityDaoJDBC.findById(3048);
            cityDaoJDBC.findByCode("SWE");
            cityDaoJDBC.findByName("Stockholm");
            cityDaoJDBC.findAll();
            cityDaoJDBC.add(new City("Test_Name","NLD", "Test_District", 1));
            cityDaoJDBC.update(new City("Test_Name","NLD", "Test_District", 10));
            cityDaoJDBC.delete(new City("Test_Name","NLD", "Test_District", 10));
        
        
    }//main
}//class
