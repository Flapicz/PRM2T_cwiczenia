package prm2t.lab6.Zad2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Zad2Frame extends JFrame {

    public Zad2Frame(){
        super("Generator okręgu");
        setLocation(200,200);
        setSize(400,400);
        setLayout(new BorderLayout());

        JButton button = new JButton("Generuj");
        button.setPreferredSize(new Dimension(40,40));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                repaint();
            }
        });

        add(BorderLayout.CENTER,new Zad2());
        add(BorderLayout.PAGE_END,button);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        Zad2Frame z2 = new Zad2Frame();
        SwingUtilities.invokeLater(() -> z2.setVisible(true));
    }
}
