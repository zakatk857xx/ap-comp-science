import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;

/**
   This class implements the letter L
*/
public class LetterL
{
   /**
      Constructs a letter L object
      @param aBounds the bounding rectangle
   */
   public LetterL(Rectangle aBounds)
   {
      bounds = aBounds;
   }

   /**
      Draws the letter L
      @param g2 the graphics context
    */
   public void draw(Graphics2D g2)
   {
      double x = bounds.getX();
      double y = bounds.getY();

      Line2D.Double vert = new Line2D.Double(x, y, 
         x, y + bounds.getHeight());
      Line2D.Double horiz =
            new Line2D.Double(x, y + bounds.getHeight(), 
               x + bounds.getWidth(), y + bounds.getHeight());

      g2.draw(vert);
      g2.draw(horiz);
   }

   private Rectangle bounds;
}
