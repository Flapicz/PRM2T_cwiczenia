package prm2t.lab3;

//– reprezentująca klientów sklepu, wymagane pola: identyfikator (np. nazwisko
//albo PESEL), koszyk;

public class Klient {

    private int pesel;
    Koszyk koszyk;

    Klient(int pesel){
        this.pesel = pesel;
        koszyk = new Koszyk();
    }
}
