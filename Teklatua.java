package juego;

import java.util.Scanner;

public class Teklatua {
    private static Teklatua nireTeklatua;
    private Scanner sc;

    private Teklatua() {sc = new Scanner(System.in);}

    public static Teklatua getTeklatua() {
        if (nireTeklatua == null) {
            nireTeklatua = new Teklatua();
        }
        return nireTeklatua;
    }

    public String irakurriString() {
        String gordetakoa= sc.next();
        return gordetakoa;
    }

    public int irakurriInt(String pMzua, int pHemendik, int pOnaino) {
        int zenbakia;
        do {
            System.out.print(pMzua);
            while (!sc.hasNextInt()) {
                System.out.println("Mesedez, sartu zenbaki baliodun bat.");
                sc.next(); // Clear invalid input
            }
            zenbakia = sc.nextInt();
        } while (zenbakia < pHemendik || zenbakia > pOnaino);
        return zenbakia;
    }

    public boolean irakurriBaiEz(String pMezua, String pBai, String pEz) {
        String erantzuna;
        do {
            System.out.print(pMezua + " (" + pBai + "/" + pEz + "): ");
            erantzuna = sc.nextLine().trim().toLowerCase();
        } while (!erantzuna.equals(pBai.toLowerCase()) && !erantzuna.equals(pEz.toLowerCase()));
        return erantzuna.equals(pBai.toLowerCase());
    }

    public String irakurriAukera(String pMezua, String pZerrenda) {
        String aukera;
        String[] aukerak = pZerrenda.split(",");
        do {
            System.out.print(pMezua + " " + pZerrenda + ": ");
            aukera = sc.nextLine().trim();
        } while (!java.util.Arrays.asList(aukerak).contains(aukera));
        return aukera;
    }
}