import javax.swing.JFrame;

public class DietzlerFrame
{
     public static void main(String args[])
     {
          JFrame frame = new JFrame("K.D.");
          
          final int x = 0;
          final int y = 0;
          final double sM = 10;
          
          DietzlerComponent2  d = new DietzlerComponent2("Kevin", 25, x, y, sM);
          
          frame.add(d);
          
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//DO_NOTHING_ON_CLOSE);
          frame.setBounds(250, 250, (int)(sM * (DietzlerComponent2.WIDTH + x)),
                                    (int)(sM * (DietzlerComponent2.HEIGHT + y)));
          frame.setVisible(true);          
     }

}
