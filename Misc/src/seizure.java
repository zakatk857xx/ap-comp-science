import javax.swing.*;
import java.awt.Color;
import java.util.*;

public class seizure
{
     public static void main(String [] argz)
     {
          Random gen = new Random();
          
          ArrayList<JFrame> frames = new ArrayList<JFrame>();
          
          final int RESOLUTION_X = 1440;
          final int RESOLUTION_Y = 900;
          final int FRAME_DIMENSIONS = 100;
          final int COLOR_RANGE = 255;
          final int MOVE_INCREMENT = 25;
          
          
          while(true) 
          {
               JFrame frame = new JFrame();
               
               frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);               
               frame.setUndecorated(true);
               frame.setBackground(new Color(gen.nextInt(COLOR_RANGE), gen.nextInt(COLOR_RANGE), gen.nextInt(COLOR_RANGE)));
               frame.setBounds(gen.nextInt(RESOLUTION_X), gen.nextInt(RESOLUTION_Y), FRAME_DIMENSIONS, FRAME_DIMENSIONS);
               frame.setAlwaysOnTop(true);
               frame.setVisible(true);
               frames.add(frame);
               
               for(int i = 0; i < frames.size(); i++)
               {                    
                    frames.get(i).setBounds((int)frames.get(i).getBounds().getX(),
                                            (int)frames.get(i).getBounds().getY() + MOVE_INCREMENT,
                                            FRAME_DIMENSIONS,
                                            FRAME_DIMENSIONS);
                    frames.get(i).setBackground(new Color(gen.nextInt(COLOR_RANGE), gen.nextInt(COLOR_RANGE), gen.nextInt(COLOR_RANGE)));
                    
                    if(frames.get(i).getX() > RESOLUTION_X && frames.get(i).getY() > RESOLUTION_Y)
                    {
                         frames.remove(i);
                    }
               }
               
               
               
          }
     }
}
