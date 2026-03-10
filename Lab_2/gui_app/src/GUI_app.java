import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
class Panel extends JPanel{
    private static final long serialVersionUID = 1L;
    //metoda desenare mostenita din clasa de baza
    public void paintComponent(Graphics g) {
        int totalP=6;
        int xP1[]={110,50,200,20,170,110};
        int yP1[]={20,190,80,80,190,20};
        g.drawPolygon(xP1,yP1,totalP);
        int xP2[]={310,250,400,220,370,310};
        int yP2[]={20,190,80,80,190,20};
        g.setColor(Color.blue);
        g.fillPolygon(xP2,yP2,totalP);
    }
}
public class GUI_app {
    public static void main(String args[]) {
        JFrame frame = new JFrame("Exemplu desenare pe panou.");
        frame.add(new Panel());
        frame.setSize(440, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
