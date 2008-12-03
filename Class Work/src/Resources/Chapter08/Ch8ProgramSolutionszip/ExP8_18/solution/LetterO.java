import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

/**
   This class implements the letter O
*/
public class LetterO
{
   /**
      Constructs a letter O object
      @param aBounds the bounding rectangle
   */
   public LetterO(Rectangle aBounds)
   {
      bounds = aBounds;
   }

   /**
      Draws the letter O
      @param g2 the graphics context
      @param p the top left corner point
    */
   public void draw(Graphics2D g2)
   {
      double x = bounds.getX();
      double y = bounds.getY();

      Ellipse2D.Double e = new Ellipse2D.Double(x, y, 
         bounds.getWidth(), bounds.getHeight());

      g2.draw(e);
   }

   private Rectangle bounds;
}
