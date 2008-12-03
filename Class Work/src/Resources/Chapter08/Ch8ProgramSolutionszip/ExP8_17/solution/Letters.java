import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

/**
   This class provides methods that implement the letters H, E, L, and O.
*/
public class Letters
{
   /**
      Draws the letter H.
      @param g2 the graphics context
      @param bounds the bounding rectangle
    */
   public static void drawH(Graphics2D g2, Rectangle bounds)
   {
      double x = bounds.getX();
      double y = bounds.getY();
      Line2D.Double vert1 = new Line2D.Double(x, y, 
         x, y + bounds.getHeight());
      Line2D.Double vert2 = new Line2D.Double(x + bounds.getWidth(), y, 
         x + bounds.getWidth(), y + bounds.getHeight());
      Line2D.Double horiz = new Line2D.Double(x, y + bounds.getHeight() / 2, 
         x + bounds.getWidth(), y + bounds.getHeight() / 2);
      g2.draw(vert1);
      g2.draw(vert2);
      g2.draw(horiz);
   }

   /**
      Draws the letter E.
      @param g2 the graphics context
      @param bounds the bounding rectangle
    */
   public static void drawE(Graphics2D g2, Rectangle bounds)
   {
      drawL(g2, bounds);
      double x = bounds.getX();
      double y = bounds.getY();
      Line2D.Double horiz1 = new Line2D.Double(x, y, 
         x + bounds.getWidth(), y);
      Line2D.Double horiz2 =
            new Line2D.Double(x, y + bounds.getHeight() / 2, 
               x + bounds.getWidth(), y + bounds.getHeight() / 2);
      g2.draw(horiz1);
      g2.draw(horiz2);
   }

   /**
      Draws the letter L.
      @param g2 the graphics context
      @param bounds the bounding rectangle
    */
   public static void drawL(Graphics2D g2, Rectangle bounds)
   {
      double x = bounds.getX();
      double y = bounds.getY();
      Line2D.Double vert = new Line2D.Double(x, y, x, y + bounds.getHeight());
      Line2D.Double horiz =
            new Line2D.Double(x, y + bounds.getHeight(), 
               x + bounds.getWidth(), y + bounds.getHeight());
      g2.draw(vert);
      g2.draw(horiz);
   }

   /**
      Draws the letter O.
      @param g2 the graphics context
      @param bounds the bounding rectangle
    */
   public static void drawO(Graphics2D g2, Rectangle bounds)
   {
      double x = bounds.getX();
      double y = bounds.getY();
      Ellipse2D.Double e =  new Ellipse2D.Double(x, y, 
         bounds.getWidth(), bounds.getHeight());
      g2.draw(e);
   }
}
