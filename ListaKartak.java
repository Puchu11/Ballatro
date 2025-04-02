package juego;
import java.util.*;
public class ListaKartak {
	private ArrayList<karta> lista;
	
	protected ListaKartak() {this.lista=new ArrayList<karta>();}
	
	private Iterator<karta> getIterator(){
		return this.lista.iterator();
	}
	
	
	//POZIZIO BATEKO KARTA BAT LORTZEKO//
	protected karta getKarta(int j) {
		karta a=this.lista.get(j);
		return a;
	}
	//KARTAREN POZIZIOA LORTZEKO//
	protected int kartarenPosisioa(karta a) {
		int i = this.lista.indexOf(a);
		return i;
	}
	protected void Ordenatu() {
		  this.lista.sort(Comparator.comparingInt(p -> p.getFitxak()));
	}
	protected ArrayList<karta> GetListaKartak() {
		return this.lista;
	}
	
	protected int getKartenFitxak(karta a) {
		return a.getFitxak();
	}
	//KARTEN LUZERA//
	public int luzera() {
		int i=this.lista.size();
		return i;
	}
	
	//KARTAK IMPRIMATZEKO//
	protected void Imprimatu() {
		Iterator<karta> itr=getIterator();
		karta b;
		int i=1;
		System.out.println("************************************************************");
		System.out.print("");
		System.out.print("ESKUA:{ ");
		while(itr.hasNext()) {
			b=itr.next(); 
			System.out.print( i+". |"+b.getBalioa()+b.getKolorea()+"| ");
			
			System.out.print("");
			i=i+1;
		}
		System.out.print("}");
		System.out.println(" ");
		System.out.println("************************************************************");
		System.out.print("");
	}
	
	//KARTAK ALDATZEKO//
	protected void sustituir(int kant, karta a) {
		kant=kant-1;
		int i=0;
		Iterator<karta> itr=getIterator();
		while (itr.hasNext() ) {
			if (i==kant){
				Sustituir(kant,a);
			}
		i=i+1;	
		}
	}
		public void Sustituir(int kont,karta b) {
			if (kont==-1){
				kont=0;
			}
			lista.set(kont,b);
		}
	
	//LISTAN INDIZE BATEN KARTA LORTZEKO//
		protected karta lortuNahiDuzunKarta(int kant) {
		boolean aurkitu=false;
		int i=0;
		Iterator<karta> itr=getIterator();
		while (itr.hasNext() && !aurkitu) {
			if (i==kant){
				aurkitu=true;
			}
		i=i+1;	
		}
		i=i-1;
		if (i==-1) {
			i=0;
		}
		karta a = lista.get(i);
		return a;
	}
	
	
		protected boolean listaVacia() {
		return this.lista.isEmpty();
	}
	
	//KARTAK EZABATZEKO//
	protected void kartaEzabatu(karta a) {
		this.lista.remove(a);
	}
	protected void kartakEzabatu() {
		lista.clear();
	}
	
	//KARTA BAT GEHITU//
	protected void gehituKarta(karta pKarta) {
		this.lista.add(pKarta);
	}
	
	//AUSAS ARTZEKO PORGRAMA//
	
}

