package se.lexicon.model;

public class City {
    
    private Integer id;
    private String name;
    private String code;
    private String district;
    private int population;
    
    public City(){}
    public City( Integer id, String name, String code, String district, int population ) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.district = district;
        this.population = population;
    }
    
    public City( String name, String code, String district, int population ) {
        this.name = name;
        this.code = code;
        this.district = district;
        this.population = population;
    }
    
    public City( String name, String code, String district ) {
        this.name = name;
        this.code = code;
        this.district = district;
    }
    
    public City( String name, int population ) {
        this.name = name;
        this.population = population;
    }
    
    public City( String name ) {
        this.name = name;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId( Integer id ) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName( String name ) {
        this.name = name;
    }
    
    public String getCode() {
        return code;
    }
    
    public void setCode( String code ) {
        this.code = code;
    }
    
    public String getDistrict() {
        return district;
    }
    
    public void setDistrict( String district ) {
        this.district = district;
    }
    
    public int getPopulation() {
        return population;
    }
    
    public void setPopulation( int population ) {
        this.population = population;
    }
    
    @Override
    public String toString() {
        return "CITY:\n" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", code = '" + code + '\'' +
                ", district = '" + district + '\'' +
                ", population = " + population;
    }
}
