import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;
public class BallCollection extends JComponent{
    ArrayList<Bola> bolas = new ArrayList<>();

    public void addBola(Bola bola){
        bolas.add(bola);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Bola bola : bolas) {
            bola.physihi(getHeight(), getWidth());
            g.setColor(bola.c);
            g.fillOval(bola.point.x-(int)bola.raio, bola.point.y-(int)bola.raio, (int)bola.raio*2, (int)bola.raio*2);
        }
    }
}
