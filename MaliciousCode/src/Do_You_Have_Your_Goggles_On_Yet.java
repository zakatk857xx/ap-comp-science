import javax.swing.*;
import java.awt.Color;
import java.util.*;

public class Do_You_Have_Your_Goggles_On_Yet
{
     public static void main(String [] argz)
     {       
          Random gen = new Random();
          
          ArrayList<JFrame> frames = new ArrayList<JFrame>();
          
          final int RESOLUTION_X = 1440;
          final int RESOLUTION_Y = 900;
          final int FRAME_DIMENSIONS = 75;  
          
          while(true) 
          {
               JFrame frame = new JFrame();
               
               frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);               
               frame.setUndecorated(true);
               frame.setBackground(new Color(gen.nextInt(255), gen.nextInt(255), gen.nextInt(255)));
               frame.setBounds(gen.nextInt(RESOLUTION_X), gen.nextInt(RESOLUTION_Y), FRAME_DIMENSIONS, FRAME_DIMENSIONS);
               frame.setAlwaysOnTop(true);
               frame.setVisible(true);
               frames.add(frame);
               
               for(int i = 0; i < frames.size(); i++)
               {
                    frames.get(i).setBackground(new Color(gen.nextInt(255), gen.nextInt(255), gen.nextInt(255)));
               }
          }
     }
}
