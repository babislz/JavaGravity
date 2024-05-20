import java.awt.Graphics;

import javax.swing.JComponent;

public class Lastico extends JComponent{
    public Bola bola1;
    public Bola bola2;

    double S = 180;
    double K = 10;
    double X;

    public Lastico(Bola b1, Bola b2) {
        super();

        bola1 = b1;
        bola2 = b2;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        double dx = (bola2.point.x - bola1.point.x);
        double dy = (bola2.point.y - bola1.point.y);

        double distance = Math.sqrt(dx * dx + dy * dy);
        X = distance - S;

        double f = X * K * 0.025;
        double fx = f * dx / distance;
        double fy = f * dy / distance;

        bola1.vx += fx / bola1.mass;
        bola1.vy += fy / bola1.mass;
        bola2.vx -= fx / bola2.mass;
        bola2.vy -= fy / bola2.mass;
        
        bola1.physihi(getHeight(), getWidth());
        bola2.physihi(getHeight(), getWidth());
        
        g.setColor(bola1.c);
        g.fillOval(bola1.point.x - (int)bola1.raio, bola1.point.y - (int)bola1.raio, (int)bola1.raio*2, (int)bola1.raio*2);
        g.setColor(bola2.c);
        g.fillOval(bola2.point.x - (int)bola2.raio, bola2.point.y - (int)bola2.raio, (int)bola2.raio*2, (int)bola2.raio*2);

        g.drawLine(bola1.point.x, bola1.point.y, bola2.point.x, bola2.point.y);
    }
}
