package prm2t.lab3;


public class Klient {

    int id;
    Koszyk koszyk;

    Klient(int id){
        this.id = id;
        koszyk = new Koszyk();
    }

    public void dodajProdukt(Produkt produkt, int ilosc){
        this.koszyk.dodajProdukt(produkt,ilosc);
    }

    /** Usuwa produkt z koszyka
     * @return cena usunietego produktu */
    public float skasujProdukt(){
        float cena = this.koszyk.ll.getLast().liczbaSztukProduktu * this.koszyk.ll.removeLast().cena;
        return cena;
    }
}
