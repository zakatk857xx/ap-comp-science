import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;

/**
   This component displays a rectangle that can be moved. 
*/
public class RectangleComponent extends JComponent
{  
   public RectangleComponent()
   {  
      // The rectangle that the paint method draws 
      box = new Rectangle(BOX_X, BOX_Y, 
            BOX_WIDTH, BOX_HEIGHT);         
   }

   public void paintComponent(Graphics g)
   {  
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;

      g2.draw(box);
   }

   /**
      Moves the rectangle by a given amount. 
      @param x the amount to move in the x-direction 
      @param y the amount to move in the y-direction 
   */
   public void moveBy(int dx, int dy)
   {
      box.translate(dx, dy);
      repaint();      
   }

   private Rectangle box;

   private static final int BOX_X = 100;
   private static final int BOX_Y = 100;
   private static final int BOX_WIDTH = 20;
   private static final int BOX_HEIGHT = 30;
}
