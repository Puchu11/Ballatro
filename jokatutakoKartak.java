package juego;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class jokatutakoKartak extends ListaKartak {
    
    public jokatutakoKartak() {
        super();
    }

    List<Integer> zenbakiak = new ArrayList<>();

    public String zeEskuDa() {
        for (int i = 0; i != this.luzera(); i++) {
            zenbakiak.add(this.getKarta(i).getFitxak());
        }

        String Eskua = "Karta Altua";

        if (KoloreEskailera()) {
            Eskua = "Kolore Eskailera";
        } else if (Poker(zenbakiak)) {
            Eskua = "Poker";
        } else if (Full(zenbakiak)) {
            Eskua = "Full";
        } else if (Kolorea()) {
            Eskua = "Kolorea";
        } else if (Eskailera()) {
            Eskua = "Eskailera";
        } else if (Trio(zenbakiak)) {
            Eskua = "Trio";
        } else if (DoblePareja(zenbakiak)) {
            Eskua = "Doble Pareja";
        } else if (Pareja()) {
            Eskua = "Pareja";
        }
        zenbakiak.clear();
        return Eskua;
    }

    protected boolean KoloreEskailera() {
        boolean Da = false;
        if (Kolorea() && Eskailera()) {
            Da = true;
        }
        return Da;
    }

    protected boolean Poker(List<Integer> b) {
        boolean Da = false;
        if (this.luzera() >= 4) {
            for (int i = 0; i !=2; i++) {  // Recorremos todas las cartas
                karta a = this.getKarta(i);
                int frekuentzia = Collections.frequency(b, a.getFitxak());
                System.out.println("poker");
                System.out.println(frekuentzia);
                if (frekuentzia == 4) {
                    Da = true;
                    break; 
                }
            }
        }
        return Da;
    }

    protected boolean Full(List<Integer> c) {
        boolean Da = false;
        if (this.luzera() == 5) {
            karta a = this.getKarta(0);
            karta b = this.getKarta(4);
            int frekuentziaA = Collections.frequency(c, a.getFitxak());
            int frekuentziaB = Collections.frequency(c, b.getFitxak());
            if (frekuentziaA == 3 && frekuentziaB == 2) {
                Da = true;
            } else if (frekuentziaA == 2 && frekuentziaB == 3) {
                Da = true;
            }
        }
        return Da;
    }

    protected boolean Kolorea() {
        boolean Da = true;
        if (this.luzera() == 5) {
            for (int i = 0; i < this.luzera() - 1; i++) {
                if (!(this.getKarta(i).getKolorea().equals(this.getKarta(i + 1).getKolorea()))) {
                    Da = false;
                    break; 
                }
            }
        } else {
            Da = false;
        }
        return Da;
    }

    protected boolean Eskailera() {
        boolean Da = true;
        if (this.luzera() == 5) {
            for (int i = 0; i < 4; i++) {
                if (this.getKarta(i).getFitxak() + 1 != this.getKarta(i + 1).getFitxak()) {
                    Da = false;
                    break; 
                }
            }
        } else {
            Da = false;
        }
        return Da;
    }

    protected boolean Trio(List<Integer> d) {
        boolean Da = false;
        if (this.luzera() >= 3) {
            karta a = this.getKarta(0);
            karta b = this.getKarta(2);
            karta c = this.getKarta(this.luzera() - 1);
            int frekuentziaA = Collections.frequency(d, a.getFitxak());
            int frekuentziaB = Collections.frequency(d, b.getFitxak());
            int frekuentziaC = Collections.frequency(d, c.getFitxak());
            System.out.println("trio");
            System.out.println(frekuentziaA);
            System.out.println(frekuentziaB);
            System.out.println(frekuentziaC);
            if (frekuentziaA == 3 || frekuentziaB == 3 || frekuentziaC == 3) {
                Da = true;
            }
        }
        return Da;
    }

    protected boolean DoblePareja(List<Integer> d) {
        boolean Da = false;
        if (this.luzera() >= 4) {
            karta a = this.getKarta(0);
            karta b = new karta(" ", " ", 0);
            if (this.luzera() == 5) {
                b = this.getKarta(2);
            }
            karta c = this.getKarta(this.luzera() - 1);
            int frekuentziaA = Collections.frequency(d, a.getFitxak());
            int frekuentziaB = Collections.frequency(d, b.getFitxak());
            int frekuentziaC = Collections.frequency(d, c.getFitxak());
            System.out.println("doble pareja");
            System.out.println(frekuentziaA);
            System.out.println(frekuentziaB);
            System.out.println(frekuentziaC);
            if ((frekuentziaA == 2 && frekuentziaB == 2) || 
                (frekuentziaA == 2 && frekuentziaC == 2) || 
                (frekuentziaB == 2 && frekuentziaC == 2)) {
                Da = true;
            }
        }
        return Da;
    }

    protected boolean Pareja() {
        boolean Da = false;
        for (int i = 0; i < this.luzera() - 1; i++) {
            if (this.getKarta(i).getBalioa().equals(this.getKarta(i + 1).getBalioa())) {
                Da = true;
                break;  
            }
        }
        return Da;
    }
}
