package juego;

public class karta {
	private String kolorea;
	private  String balioa;
	private int fitxak;
	
	public karta(String pKolorea, String pBalioa, int pFitxak) {
		this.kolorea= pKolorea;
		this.balioa= pBalioa;
		this.fitxak=pFitxak;

	}
	
	public String getKolorea() {
		return this.kolorea;
	}
	
	public String getBalioa() {
		return this.balioa;
	}
	public int getFitxak() {
		return this.fitxak;
	}
}
