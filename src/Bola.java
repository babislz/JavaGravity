import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.*;

public class Bola extends JComponent{

    private Point point;
    private double angle = 90;
    double vx = 0, vy = 1, gravity = 1.5;
    double radiozinho = 102;
    int width = 600;
    int height = 600;

    public Bola() {
        point = new Point(width/2, height/2);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        width = getWidth();
        height = getHeight();

        g.setColor(new Color(66, 66, 111, 255));
        g.fillOval(point.x - (int)radiozinho, point.y - (int)radiozinho, (int)radiozinho * 2, (int)radiozinho * 2);
    }

    public void physihi(){
        
        vy = vy >= 0 ? vy + Math.sin(angle) * gravity : vy - Math.sin(angle) * -gravity + 0.7;
        point.x += vx;
        point.y += vy;

        if(point.y+radiozinho >= height && vy > 0){
            if (vy > 0) {
                vy = -vy;
            }
        }
    }
}

