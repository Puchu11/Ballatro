package juego;
public class Main{
public static void main(String[] args) {
		int eskuak=3;
		int deskartes=3;
		int dirua=0;
		int ciega=300;
		boolean galdu=false;
		while (!galdu) {
		Mahaia jokoBerria=new Mahaia(ciega,dirua,eskuak,deskartes);
		jokoBerria.getMazo();
		jokoBerria.getEskua();
			while (jokoBerria.getEskuKant()!=0) {
				jokoBerria.rondaDeskarteak();
				jokoBerria.rondaMano();	
			}
		System.out.println("se acabo la ronda");
		ciega=ciega*2;
		}
}	
}

			




		



