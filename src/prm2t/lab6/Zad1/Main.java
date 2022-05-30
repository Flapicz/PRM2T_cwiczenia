package prm2t.lab6.Zad1;

import java.awt.*;

public class Main {

    public static void main(String... args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainPanel();
            }
        });
    }
}
