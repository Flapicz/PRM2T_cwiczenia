package prm2t.lab3;
import java.util.LinkedList;


public class Koszyk {
    protected LinkedList<ProduktWKoszyku> ll;

    Koszyk(){
        ll = new LinkedList<>();
    }

    /** @return ilosc grup produktow w koszyku */
    public int sprawdzIlosc(){
        return ll.size();
    }


    public void dodajProdukt(Produkt produkt, int ilosc){
        ProduktWKoszyku produktWKoszyku = new ProduktWKoszyku(produkt, ilosc);
        ll.addLast(produktWKoszyku);
    }


}
