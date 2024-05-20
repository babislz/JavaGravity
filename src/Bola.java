import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.util.Random;

import javax.swing.*;

public class Bola extends JComponent{

    public Point point;
    private double angle = 20;
    double vx = 15, vy = 1, gravity = 9.8;
    double raio = 30;
    int width = 0;
    int height = 0;
    double mass = 5;
    Color c;

    public Bola(int x, int y, double vx, double angle) {
        point = new Point(x,y);
        this.vx = vx;
        this.angle = angle;
        Random rd = new Random();
        c = new Color(rd.nextInt(255), rd.nextInt(255), rd.nextInt(255));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      
        g.setColor(new Color(66, 66, 111, 255));
        g.fillOval(point.x - (int)raio, point.y - (int)raio, (int)raio * 2, (int)raio * 2); //desenha o circulo
    }

    public void physihi(int h, int w) {
        
        width = w;
        height = h;

        double angleInRadians = Math.toRadians(angle) * 0.025; 

        double accelerationY = Math.sin(angleInRadians) * gravity * mass * 0.025;
    
        // vx += accelerationX;
        vy += accelerationY;
    
        point.x += vx * Math.cos(angleInRadians);
        point.y += vy;
    
        if (point.x + raio >= width) {
            point.x = width - (int) raio;
            
            if (angle < 90) {
                angle = 180 - angle;
            }

            vx -= 1.5;
        } else if (point.x - raio <= 0) {
            point.x = (int) raio;
            
            if (angle > 90) {
                angle = 90 - (angle-90);
            }
            vx -= 1.5;
        }

        if (point.y + raio >= height) {
            point.y = height - (int) raio;
            vx *= 0.98;
            if (vx <= 0.0001) {
                vx = 0;
            }
            vy = -vy; 
        } else if (point.y - raio <= 0) {
            point.y = (int) raio;
            vy = -vy;
            vx *= 0.35;
        }
    }
}


