package prm2t.lab3;

public class ProduktWKoszyku extends Produkt {

    int liczbaSztukProduktu;

    ProduktWKoszyku(Produkt produkt, int liczbaSztukProduktu){
        super();
        this.liczbaSztukProduktu=liczbaSztukProduktu;
        cena = produkt.cena;
        nazwa = produkt.nazwa;
    }
}
