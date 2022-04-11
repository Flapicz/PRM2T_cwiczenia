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

    public void zawartoscKoszyka(){
        String string = "";
        for(int i = koszyk.ll.size()-1; i>=0; i--){
            ProduktWKoszyku produkt = koszyk.ll.get(i);
            string = string + "\n" + produkt.liczbaSztukProduktu + " " + produkt.nazwa;
        }
        System.out.println("Klient " + id + " ma w koszyku:" + string);
    }
}
