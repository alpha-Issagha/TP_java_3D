public class Test{

	public static void main(String[] args){
		World w = new World ("data/airport-codes_no_comma.csv");
 		System.out.println("Found "+w.getList().size()+" airports.\n");
        Aeroport paris = w.findNearestAirport(2.316,48.866);
        Aeroport cdg = w.findByCode("CDG");
        double distance = w.distance(2.316,48.866,paris.getLongitude(),paris.getLatitude());
        System.out.println(paris+"\n");
        System.out.println(distance+"\n");
        double distanceCDG = w.distance(2.316,48.866,cdg.getLongitude(),cdg.getLatitude());
        System.out.println(cdg+"\n");
        System.out.println(distanceCDG);

	}
}
