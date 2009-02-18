/**
 *    The Disc class inherits from Rectangle2D.Double and has extra
 *      features like a Color and ringWidth.
 *    <br>
 *    Date: 2/6/08
 * 
 *    @author Mr. Dietzler
 *
 */

import java.awt.geom.Rectangle2D;
import java.awt.Color;

public class Disc extends Rectangle2D.Double
{
   private int ringWidth;
   private Color discColor;
   
   public Disc (int rW, double towerMiddleX, double initialY,
                double width, double height, Color c)
   {
      ringWidth = rW;
      setRect (towerMiddleX - (width/2.0), initialY, width, height);
      discColor = c;
   }//end Disc constructor
   
   
   public int getRingWidth ()
   {
      return ringWidth;
   }//end getRingWidth method
   
   
   public Color getColor ()
   {
      return discColor;
   }//end getColor method
   
}//end Disc class