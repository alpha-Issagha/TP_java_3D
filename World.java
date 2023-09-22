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
	/*public double distance()
	{

	}*/
}