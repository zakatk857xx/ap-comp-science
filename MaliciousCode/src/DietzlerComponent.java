import javax.swing.*;
import java.awt.*;
import java.util.*;

public class DietzlerComponent extends JComponent
{
     
     private ImageIcon d;
     private String path;
     private Color c;
     private int r, g, b, t, rs, gs, bs;
     private Random gen;
     private boolean o;
     
     
     public DietzlerComponent(Color col, boolean opt) 
     {
          path = new String("/Users/tzaki/java/MaliciousCode/src/");
          
          d = new ImageIcon(path + "dietzler.gif");
          
          gen = new Random();
          
          o = opt;
          
          if(o)
          {
               r  = 150;//gen.nextInt(101) + 100; 
               rs = 5;//gen.nextInt(15);
               g  = 100;//gen.nextInt(101) + 100;
               gs = 3;//gen.nextInt(15);
               b  = 125;//gen.nextInt(101) + 100;
               bs = 7;//gen.nextInt(15);
               t  = 200;          
                         
               c = new Color(r, g, b, t);
          }
          else
               c = col;
     }
     
     public void changevalues()
     {
          if(r <= 100 || r >= 200)
               rs *= -1;
          if(g <= 100 || g >= 200)
               gs *= -1;
          if(b <= 100 || b >= 200)
               bs *= -1;
          
          r += rs;
          g += gs;
          b += bs;
          
          c = new Color(r, g, b, t);
     }
     
     public void paintComponent(Graphics g)
     {
          Graphics2D g2 = (Graphics2D) g;
          
          d.paintIcon(this, g2, 0, 0);
          if(o)
               changevalues();
          g2.setColor(c);
          g2.fillRect(0, 0, 80, 100);
     }
}