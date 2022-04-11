package prm2t.lab3;
import java.util.LinkedList;


public class Koszyk {
    protected LinkedList<ProduktWKoszyku> ll;

    Koszyk(){
        ll = new LinkedList<>();
    }


    public void dodajProdukt(Produkt produkt, int ilosc){
        ProduktWKoszyku produktWKoszyku = new ProduktWKoszyku(produkt, ilosc);
        ll.addLast(produktWKoszyku);
    }


}
