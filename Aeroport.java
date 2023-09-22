public class Aeroport {
    private String IATA;
    private String name;
    private String country;
    private double latitude;
    private double longitude;

    public Aeroport(String IATA, String name, String country, double latitude, double longitude) {
        this.IATA = IATA;
        this.name = name;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
    }

  
    public String getIata() {
        return this.IATA;
    }

    public String getName() {
        return this.name;
    }

    public String getCountry() {
        return this.country;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setIata(String IATA) {
        this.IATA = IATA;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String toString()
    {
    	return "IATA : "+this.IATA+"  Name : "+this.name+"  Country : "+this.country+"  Latitude : "+this.latitude+" Longitude : "+this.longitude;
    }

}