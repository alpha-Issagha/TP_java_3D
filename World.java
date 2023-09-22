import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class World{
	private ArrayList<Aeroport> list = new ArrayList<>();

	public World (String fileName){
	    try{
	        BufferedReader buf = new BufferedReader(new FileReader(fileName));
        	String s = buf.readLine();
	        while(s!=null){
				s=s.replaceAll("\"","");
				//Enleve les guillemets qui s ́eparent les champs de donn ́ees GPS.
				String fields[]=s.split(",");
				// Une bonne id ́ee : placer un point d'arr^et ici pour du debuggage.
				if (fields[1].equals("large_airport")){ // A continuer
                    double latitude = Double.parseDouble(fields[11]);
                    double longitude = Double.parseDouble(fields[12]);

                    // Crée un objet Aeroport et ajoute-le à la liste
                    Aeroport airport = new Aeroport(fields[9],fields[2],fields[5],latitude,longitude);
                    list.add(airport);
				}
				s = buf.readLine();
			}
		}
		catch (Exception e){
		    System.out.println("Maybe the file isn't there ?");
		    System.out.println(list.get(list.size()-1));
		    e.printStackTrace();
		}
	}

	public ArrayList<Aeroport> getList() {
        return list;
    }

    public Aeroport findNearestAirport(double latitude,double longitude){
    	int a = 0;
    	double distance = distance(longitude,latitude,getList().get(0).getLongitude(),getList().get(0).getLatitude());
    	for(int i=0;i<getList().size();i++){
    		if (distance >= distance(longitude,latitude,getList().get(i).getLongitude(),getList().get(i).getLatitude()))
    		{
    			a = i;
    			distance = distance(longitude,latitude,getList().get(i).getLongitude(),getList().get(i).getLatitude());
    		} 
    	}
    	return getList().get(a);
    }

    public double distance(double longitude1,double latitude1,double longitude2,double latitude2){
    	return Math.pow((latitude2 - latitude1),2)+Math.pow(((longitude2-longitude1)*Math.cos(Math.toRadians((latitude2 - latitude1)/2))),2);
    }


	public Aeroport findByCode(String iata)
	{
		boolean a = false;
		int i =0;
		while(!a)
		{
			if(getList().get(i).getIata().equals(iata))
			{
				a = true;
			}
			else 
				i++;
		}
		return getList().get(i);
	}
}