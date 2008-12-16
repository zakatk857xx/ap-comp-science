import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class DietzlerComponent2 extends JComponent
{
     public static final int WIDTH  =  80;
     public static final int HEIGHT = 100;
     
     private int x, y, age;
     private double sizeMult;
     private String name;
          
     public DietzlerComponent2(String n, int a, int xP, int yP, double sM)
     {
          name = new String(n);
          age = a;
          x = xP;
          y = yP;          
          sizeMult = sM;
     }
     
     public String getName()       {return name;}
     public int    getAge()        {return age;}
     public void   happyBirthday() {age++;}
     public void paintComponent(Graphics g)
     {
          Graphics2D g2 = (Graphics2D) g;
          
          g2.drawOval((int)(sizeMult * x), (int)(sizeMult * y), (int)(sizeMult * 20), (int)(sizeMult * 20));
          g2.drawLine((int)(sizeMult * (10 + x)), (int)(sizeMult * (20 + y)),
                      (int)(sizeMult * (10 + x)), (int)(sizeMult * (50 + y)));
          g2.drawLine((int)(sizeMult * (10 + x)), (int)(sizeMult * (20 + y)),
                      (int)(sizeMult * ( 5 + x)), (int)(sizeMult * (30 + y)));
          g2.drawLine((int)(sizeMult * (10 + x)), (int)(sizeMult * (20 + y)),
                      (int)(sizeMult * (15 + x)), (int)(sizeMult * (30 + y)));
          g2.drawLine((int)(sizeMult * (10 + x)), (int)(sizeMult * (50 + y)),
                      (int)(sizeMult * ( 5 + x)), (int)(sizeMult * (60 + y)));
          g2.drawLine((int)(sizeMult * (10 + x)), (int)(sizeMult * (50 + y)),
                      (int)(sizeMult * (15 + x)), (int)(sizeMult * (60 + y)));
          
          g2.setFont(new Font("Helvetica", Font.PLAIN, 10 + (int)sizeMult));
          g2.drawString(name + " Dietzler", (int)(sizeMult * x), (int)(sizeMult * (y + 75)));
     }

}
