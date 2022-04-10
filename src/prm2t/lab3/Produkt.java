package prm2t.lab3;

public class Produkt {

    protected String nazwa;
    protected float cena;

    Produkt(String nazwa, float cena){
        this.nazwa = nazwa;
        this.cena = cena;
    }

    public Produkt() {

    }


    public String sprawdzNazwe() {return this.nazwa;}
    public float sprawdzCene() {return this.cena;}
}
