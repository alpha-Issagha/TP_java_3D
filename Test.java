public class Test{

	public static void main(String[] args){
		/*Aeroport A = new Aeroport("CKY","Ahmed Sekou Touré","Guinea",9.5755,13.6199);
		System.out.println(A.toString());*/
		World w = new World ("data/airport-codes_no_comma.csv");
        System.out.println("Found : "+w.getList().size()+" airports.");
	}
}
