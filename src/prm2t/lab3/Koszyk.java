package prm2t.lab3;
import java.util.LinkedList;


public class Koszyk {
    private LinkedList<ProduktWKoszyku> ll;

    Koszyk(){
        ll = new LinkedList<>();
    }

    /** @return ilosc grup produktow w koszyku */
    public int sprawdzIlosc(){
        return ll.size();
    }

    //public float sprawdzWartosc(){return }

    //public ? sprawdzListe(){}

    public void dodajProdukt(Produkt produkt, int ilosc){
        ProduktWKoszyku produktWKoszyku = new ProduktWKoszyku(produkt, ilosc);
        ll.addLast(produktWKoszyku);
    }

    /** Usuwa produkt z koszyka
     * @return cena usunietego produktu */
    public float skasujProdukt(){
        float cena = ll.removeLast().cena;
        return cena;
    }

}
