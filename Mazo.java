package juego;

import java.util.Random;

public class Mazo extends ListaKartak {
	public Mazo() {
		super();
	}
	protected void kartaEzabatu() {
		super.kartakEzabatu();
	}
	public void SortuMazo(){
		super.kartakEzabatu();
		String balio="";
		for (int i=1;i!=5;i++) {
			String kolorea="";
			if (i==1){
				kolorea="♥";
			}
			if (i==2){
				kolorea="♦";
			}
			if (i==3){
				kolorea="♣";
			}
			if (i==4){
				kolorea="♠";
			}
			for (int j=1;j!=14;j++) {
				if (2<=j && j<=10){
				balio=String.valueOf(j);}
				else if(j==1) {
					balio="A";
				}
				else if(j==11) {
					balio="J";
				}
				else if(j==12) {
					balio="Q";
				}
				else if(j==13) {
					balio="K";
				}
				karta a=new karta(kolorea,balio,j);
				super.gehituKarta(a);
			}
		}
	}
	public karta AteraKartaBat() {
		Random random = new Random();
		karta a = super.getKarta(random.nextInt(super.luzera()));
		super.kartaEzabatu(a);
		return a;
	}
}
