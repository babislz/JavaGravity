import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;

public class Quadrado extends JComponent {
    public Lastico l, x, lx, xl;

    ArrayList<Bola> balls;

    public Quadrado() {
        super();

        Bola ball = new Bola(100, 100, 30, 20);
        Bola ball1 = new Bola(200, 100, 30, 110);
        Bola ball2 = new Bola(200, 200, 30, 80);
        Bola ball3 = new Bola(100, 200, 30, 30);
        balls = new ArrayList<>();

        balls.add(ball);
        balls.add(ball1);
        balls.add(ball2);
        balls.add(ball3);


        // BallCollection balls = new BallCollection();

        // balls.addBola(ball);
        // balls.addBola(ball1);

        // frame.add(balls);

        l = new Lastico(ball, ball1);
        x = new Lastico(ball2, ball3);
        lx = new Lastico(ball, ball2);
        xl = new Lastico(ball1, ball3);
    }

    @Override
    protected void paintComponent(Graphics g) {
        for (Bola bola : balls) {
            g.drawOval(bola.point.x - (int)bola.raio, bola.point.y - (int)bola.raio, (int)bola.raio*2, (int)bola.raio*2);
        }
    }
}
