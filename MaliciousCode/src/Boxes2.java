import javax.swing.*;
import java.awt.Color;
import java.util.*;

public class Boxes2
{
     public static void main(String [] argz)
     {       
          Random gen = new Random();
                   
          final int RESOLUTION_X = 1440;
          final int RESOLUTION_Y = 900; 
          
          for(int i = 0; i < 50      ; i++)
          {
               MovingFrame frame 
                    = new MovingFrame(
                         gen.nextInt(RESOLUTION_X),
                         gen.nextInt(RESOLUTION_Y),
                         80,
                         100,
                         gen.nextInt(500) / 10.0, 
                         gen.nextInt(500) / 10.0,
                         new Color(255, 0, 0, 100),
                         false);
          }
     }
}
