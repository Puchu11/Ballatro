package juego;

import java.util.ArrayList;

public class Mahaia {
	private int ciega;
	private int dirua;
	private int eskuak;
	private int deskartes;
	private int fitxak=0;
	private int multiplikadorea=1;
	private int puntuazioa=0;
	private Eskua eskua=new Eskua();
	private jokatutakoKartak JokatutakoKartak=new jokatutakoKartak();
	private Mazo Mazo=new Mazo();
	public Mahaia(int pCiega, int pDirua,int pEskuak,int pDeskartes) { 
		this.ciega=pCiega;
		this.dirua=pDirua;
		this.eskuak=pEskuak;
		this.deskartes=pDeskartes;
	}
	//HASIERAKO ESKUA LORTU//
	public void getMazo() {
		Mazo.SortuMazo();
	}
	public void getEskua() {
		int i;
		i=1;
		while (i<=8){
			karta a=Mazo.AteraKartaBat();
			eskua.gehituKarta(a);
			i=i+1;
		}
		eskua.Ordenatu();
	}
	
	//HASIERAKO ESKUA LORTZEKO//
	public int getEskuKant() {
		return this.eskuak;
	}
	
	
	//DATUAK IMPRIMATU//
	private void DatuakImprimatu() {
		System.out.print("DESKARTES: "+this.deskartes);
		System.out.print(" ");
		System.out.print("MANOS: "+ this.eskuak);
		System.out.print(" ");
		System.out.print("DIRUA: "+ this.dirua);
		System.out.print(" ");
		System.out.print("CIEGA: "+ this.ciega);
		System.out.println("");
		System.out.print("PUNTUAZIOA: "+ puntuazioa);
		System.out.println("");
		System.out.println("************************************************************");
	}
	
	//DESKARTEKO RONDA//
	public void rondaDeskarteak() {
		eskua.Imprimatu();
		DatuakImprimatu();
		Teklatua t= Teklatua.getTeklatua();
		System.out.println("RONDA DE DESKARTES");
		if (this.deskartes==0) {	System.out.println("no quedan deskartes");}
		else {
		boolean erantzuna1 = t.irakurriBaiEz("Kartaren bat deskartatu nahi duzu?","Bai","Ez");
		boolean saltar=false;
		boolean saltar2=false;
			if (erantzuna1) {
				while (this.deskartes!=0 && !saltar){
						int i=5;
						i=5;
						System.out.println("Aldatu nahi duzun kartaren posizioa idatzi, bost karta deskartatu ditzakezu");
						System.out.println("Bost karta deskartatu ez nahi baduzu idatzi saltar");
						while (i>=0) {
							if (i==0 || saltar2) {
								if (i!=5){
								setDeskarteak(this.deskartes-1);}
								saltar2=false;
								i=-1;
							}else {
								String deskarteak = t.irakurriString();
								while (!deskarteak.equals("8") &&!deskarteak.equals("7")  &&!deskarteak.equals("6")  &&!deskarteak.equals("5")  &&!deskarteak.equals("4")  &&!deskarteak.equals("3")   &&!deskarteak.equals("2")  &&!deskarteak.equals("1") &&!deskarteak.equals("saltar")) {	
									System.out.println("elige un numero del 1 al 8");
									System.out.println("si no quieres seguir deskartando escribe saltar");
									System.out.println("oraindik ahal duzu deskartatu " + this.deskartes + "karta");
									deskarteak = t.irakurriString();}
								if (deskarteak.equals("saltar")) {
										saltar2=true;
									}else {
									int deskarte = Integer.parseInt(deskarteak);
									//si se pone algo que no se debe//
									deskartea(deskarte-1);
									i=i-1;}
							}
						}
						System.out.println("Esku berria auh da: ");
						eskua.Ordenatu();
						eskua.Imprimatu();
						if (this.deskartes!=0) {
						System.out.println("DESKARTES: "+ this.deskartes);
						//se comprueba si se han utilizado todos los deskartes y se pregunta si se quiere seguir deskartando//
							boolean erantzuna2 = t.irakurriBaiEz("Segui nahi duzu deskartatzen?","Bai","Ez");
							if (!erantzuna2) {saltar=true;}}
					
						}
				}
	System.out.println("se acabo ronda de deskartes te quedan "+ this.deskartes+ " deskartes");
	System.out.println("************************************************************");
	}}
	
	private void deskartea(int kant) {
		karta a=Mazo.AteraKartaBat();
		eskua.Sustituir(kant,a);
	}
	
	//AMAITU DESKARTEAK//
	public void setEskuak(int a) {
		this.eskuak=a;
	}
	public void setDeskarteak(int a) {
		this.deskartes=a;
	}
	
	
	//RONDA MANO//
	public void rondaMano() {
		Teklatua t= Teklatua.getTeklatua();
		System.out.println("RONDA DE MANO");
		eskua.Ordenatu();
		eskua.Imprimatu();
		DatuakImprimatu();
		boolean aukeratua=false;	
		boolean saltar=false;
		while (!aukeratua){
			int i=5;
			while ((i>=0)) {
				if (i==5) {
					System.out.println("Aukeratu erabiliko duzun kartak, 5 karta max");
				}
				if (i==0 || saltar) {
					System.out.println("Erabiliko duzun eskua ahu da: ");
					Puntuazioa();
					boolean erantzuna=t.irakurriBaiEz("esku honekin geratu nahi zara?", "Bai", "Ez");
					if (erantzuna) {
						setEskuak(this.eskuak-1);
						puntuazioa=((fitxak*multiplikadorea)+puntuazioa);
						int luzera=JokatutakoKartak.luzera();
						while (luzera>0) {
							luzera=luzera-1;
							int g = sustituirKartak(luzera);
							deskartea(g);}
						aukeratua=true;
						i=-1;
						JokatutakoKartak.kartakEzabatu();
						eskua.Imprimatu();
					}else {
						JokatutakoKartak.kartakEzabatu();
						fitxak=0;
						multiplikadorea=0;
						i=5;
					}
						
				}else {
					String Aukeratua = t.irakurriString();
					while (!Aukeratua.equals("8") && !Aukeratua.equals("7") && !Aukeratua.equals("6") && !Aukeratua.equals("5") && !Aukeratua.equals("4") && !Aukeratua.equals("3")  && !Aukeratua.equals("2") && !Aukeratua.equals("1") && !Aukeratua.equals("Saltar")) {	
						System.out.println("porfavor escoja un numero del 1 al 8 o si no quiere deskartar mas kartas elija saltar");
						Aukeratua = t.irakurriString();}
						if (Aukeratua.equals("Saltar")) {
							saltar=true;
						}else {
						int aukeratuak = Integer.parseInt(Aukeratua);
						erabilkoEskua(aukeratuak-1);
						i=i-1;}
				}}
			}
	}
	private int sustituirKartak(int j) {
		karta karta = JokatutakoKartak.getKarta(j);
		int i = eskua.kartarenPosisioa(karta);
		return i;
	}
	private void erabilkoEskua(int kant) {
		karta erabili = eskua.lortuNahiDuzunKarta(kant);
		JokatutakoKartak.gehituKarta(erabili);
	}
	// se acaba la ronda de mano//
	
	
	//PUNTUAZIOA LORTU//
	private void Puntuazioa() {
		JokatutakoKartak.Ordenatu();
		JokatutakoKartak.Imprimatu();
		String Eskua = JokatutakoKartak.zeEskuDa();
		LortuPuntuazioa(Eskua);
		System.out.println("zure eskua da: "+ Eskua);
		System.out.print("FITXAK: |" +fitxak+"| MULTIPLIKADOREA |"+multiplikadorea+"| LORTUTAKO PUNTUAZIOA: ");
		System.out.print((fitxak*multiplikadorea)+puntuazioa);
		System.out.println(" ");
		
		}
	private void LortuPuntuazioa(String Eskua) {
		if(Eskua.equals("Kolore Eskailera")) {
			fitxak=50;
			multiplikadorea=10;
		}else if(Eskua.equals("Poker")) {
			fitxak=40;
			multiplikadorea=8;
		}else if(Eskua.equals("Full")) {
			fitxak=35;
			multiplikadorea=6;
		}else if(Eskua.equals("Kolorea")) {
			fitxak=30;
			multiplikadorea=5;
		}else if(Eskua.equals("Eskailera")) {
			fitxak=30;
			multiplikadorea=4;
		}else if(Eskua.equals("Trio")) {
			fitxak=25;
			multiplikadorea=4;
		}
		else if(Eskua.equals("Doble Pareja")) {
			fitxak=20;
			multiplikadorea=3;
		}else if(Eskua.equals("Pareja")) {
			fitxak=15;
			multiplikadorea=2;
		}else if(Eskua.equals("Karta Altua")) {
			fitxak=10;
			multiplikadorea=1;
		}
	}
	}

	