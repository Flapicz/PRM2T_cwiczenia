package prm2t.lab6.Zad2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;
import static java.lang.Math.max;

public class Zad2 extends JComponent {

    public Zad2() {
        setPreferredSize(new Dimension(400, 400));
    }

    public void paintComponent(Graphics g) {
        Dimension size2 = getSize();

        int x = getRandomNumber(0,size2.width-10);
        int y = getRandomNumber(0,size2.height-50);
        int maxRadius = max(size2.width, size2.height) - max(x,y);// maxradius+max(x,y) = 400; maxradius = 400-max(x,y)
        int minRadius = 10;
        int radius = getRandomNumber(minRadius,maxRadius);
        g.drawOval(x, y, radius, radius);
    }

    private int getRandomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
