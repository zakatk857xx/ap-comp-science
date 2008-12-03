import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;

/**
   This class implements the letter H
*/
public class LetterH
{
   /**
      Constructs a letter H object
      @param aBounds the bounding rectangle
   */
   public LetterH(Rectangle aBounds)
   {
      bounds = aBounds;
   }

   /**
      Draws the letter H
      @param g2 the graphics context
    */
   public void draw(Graphics2D g2)
   {
      double x = bounds.getX();
      double y = bounds.getY();

      Line2D.Double vert1 = new Line2D.Double(x, y, x, y + bounds.getHeight());
      Line2D.Double vert2 =
            new Line2D.Double(x + bounds.getWidth(), y, 
               x + bounds.getWidth(), y + bounds.getHeight());
      Line2D.Double horiz =
            new Line2D.Double(x, y + bounds.getHeight() / 2, 
               x + bounds.getWidth(), y + bounds.getHeight() / 2);

      g2.draw(vert1);
      g2.draw(vert2);
      g2.draw(horiz);
   }

   private Rectangle bounds;
}
