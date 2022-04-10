package prm2t.lab3;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {



    public static void main(String[] args){
        Produkt chleb = new Produkt("Chleb",3.5f );
        Produkt kurczak = new Produkt("Kurczak",5.0f );
        Produkt mleko = new Produkt("Mleko",4.0f );
        Produkt czekolada = new Produkt("Czekolada",6.0f );

        ArrayList<Produkt> listaProduktow = new ArrayList<>();
        listaProduktow.add(chleb);
        listaProduktow.add(kurczak);
        listaProduktow.add(mleko);
        listaProduktow.add(czekolada);


        Klient klient1 = new Klient(0000);
        klient1.koszyk.dodajProdukt(chleb,3);
        klient1.koszyk.dodajProdukt(czekolada,1);
        klient1.koszyk.dodajProdukt(mleko, 4);
        klient1.koszyk.dodajProdukt(czekolada, 1);

    }
}
