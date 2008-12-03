import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;

/**
   This class implements the letter E
*/
public class LetterE
{
   /**
      Constructs a letter E object
      @param aBounds the bounding rectangle
   */
   public LetterE(Rectangle aBounds)
   {
      bounds = aBounds;
   }

   /**
      Draws the letter E
      @param g2 the graphics context
    */
   public void draw(Graphics2D g2)
   {
      double x = bounds.getX();
      double y = bounds.getY();

      Line2D.Double horiz1 =
            new Line2D.Double(x, y, x + bounds.getWidth(), y);
      Line2D.Double horiz2 =
            new Line2D.Double(x, y + bounds.getHeight() / 2, 
               x + bounds.getWidth(), y + bounds.getHeight() / 2);
      Line2D.Double horiz3 =
            new Line2D.Double(x, y + bounds.getHeight(), 
               x + bounds.getWidth(), y + bounds.getHeight());
      Line2D.Double vert =
            new Line2D.Double(x, y, x, y + bounds.getHeight());

      g2.draw(horiz1);
      g2.draw(horiz2);
      g2.draw(horiz3);
      g2.draw(vert);
   }

   private Rectangle bounds;
}
