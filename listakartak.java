package juego;

import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;
public class ListaKartak {
	private ArrayList<karta> lista;
	
	public ListaKartak() {this.lista=new ArrayList<karta>();}
	
	private Iterator<karta> getIterator(){
		return this.lista.iterator();
	}
	
	public boolean ezBadagoKarta(karta pKarta) {
		boolean Dago=true;
		Iterator<karta> itr=getIterator();
		karta b;
		while(itr.hasNext()) {
			b=itr.next();
			if(pKarta==b) {
				Dago=false;
			}
		
		}
		return Dago;
	}
	
	public void Imprimatu() {
		Iterator<karta> itr=getIterator();
		karta b;
		int i=1;
		while(itr.hasNext()) {
			b=itr.next(); 
			System.out.println(i+".  "+b.getBalioa()+b.getKolorea());
			i=i+1;
		}
	}

	public void gehituKarta(karta pKarta) {
			this.lista.add(pKarta);
	}
	public karta getAusasKartaBat() {
	String[] palos = {"♥", "♦", "♣", "♠"};
    String [] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    
    Random random = new Random();
    
    // Elegir aleatoriamente un palo
    String palo = palos[random.nextInt(palos.length)];
    
    // Elegir aleatoriamente un valor
    String valor = valores[random.nextInt(valores.length)];
    
    karta KartaBerria =new karta(palo, valor);
    return KartaBerria;
}}
