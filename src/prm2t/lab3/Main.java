package prm2t.lab3;

import javax.swing.*;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.util.*;

public class Main {


    public static void obsluz(){
        Klient klient = kolejka.getFirst();
        float suma = 0;
        for (int dlugosc = klient.koszyk.ll.size(); dlugosc > 0; dlugosc--){
            suma = suma + klient.skasujProdukt();
        }
        System.out.println("Klient"+ klient.id + " ma do zaplacenia "+ suma + "zl");
    }



    public static void main(String[] args){
        Produkt chleb = new Produkt("Chleb",3.5f );
        Produkt bulka = new Produkt("Bułka",0.5f );
        Produkt mleko = new Produkt("Mleko",4.0f );
        Produkt czekolada = new Produkt("Czekolada",6.0f );
        Produkt piwo = new Produkt("Piwo",3.0f );
        Produkt sok = new Produkt("Sok",3.0f );
        Produkt dzem = new Produkt("Dżem",5.0f );
        Produkt szynka = new Produkt("Szynka",6.0f );
        Produkt guma = new Produkt("Guma do żucia",1.0f );
        Produkt baton = new Produkt("Baton",2.0f );
        Produkt woda = new Produkt("Woda",1.5f );

        ArrayList<Produkt> listaProduktow = new ArrayList<>();
        listaProduktow.add(chleb);
        listaProduktow.add(bulka);
        listaProduktow.add(mleko);
        listaProduktow.add(czekolada);
        listaProduktow.add(piwo);
        listaProduktow.add(sok);
        listaProduktow.add(dzem);
        listaProduktow.add(szynka);
        listaProduktow.add(guma);
        listaProduktow.add(baton);
        listaProduktow.add(woda);

        Klient klient1 = new Klient(1);
        Klient klient2 = new Klient(2);
        Klient klient3 = new Klient(3);
        Klient klient4 = new Klient(4);
        Klient klient5 = new Klient(5);
        Klient klient6 = new Klient(6);
        Klient klient7 = new Klient(7);

        ArrayList<Klient> listaKlientow = new ArrayList<>();
        listaKlientow.add(klient1);
        listaKlientow.add(klient2);
        listaKlientow.add(klient3);
        listaKlientow.add(klient4);
        listaKlientow.add(klient5);
        listaKlientow.add(klient6);
        listaKlientow.add(klient7);

        LinkedList<Klient> kolejka = new LinkedList<>();

        klient1.dodajProdukt(chleb,3);
        klient1.dodajProdukt(czekolada,1);
        klient1.dodajProdukt(mleko, 4);
        klient1.dodajProdukt(czekolada, 1);
        kolejka.addFirst(klient1);

        klient2.dodajProdukt(woda, 5);
        klient2.dodajProdukt(chleb, 1);
        klient2.dodajProdukt(baton, 2);
        kolejka.addFirst(klient2);

        obsluz();
        obsluz();

    }
}
