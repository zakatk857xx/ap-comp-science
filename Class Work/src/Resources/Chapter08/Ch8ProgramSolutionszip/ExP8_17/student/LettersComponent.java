import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Point2D;

public class LettersComponent extends JComponent
{
   public void paintComponent(Graphics g)
   {
      final int WIDTH = 30;
      final int HEIGHT = 50;
      final int SPACING = 10;

      Graphics2D g2 = (Graphics2D) g;

      Rectangle bounds = new Rectangle(0, 0, WIDTH, HEIGHT);

      Letters.drawH(g2, bounds);
      bounds.translate(WIDTH + SPACING, 0);

      Letters.drawE(g2, bounds);
      bounds.translate(WIDTH + SPACING, 0);

      Letters.drawL(g2, bounds);
      bounds.translate(WIDTH + SPACING, 0);

      Letters.drawL(g2, bounds);
      bounds.translate(WIDTH + SPACING, 0);

      Letters.drawO(g2, bounds);
      bounds = new Rectangle(0, HEIGHT + SPACING, WIDTH, HEIGHT);

      Letters.drawH(g2, bounds);
      bounds.translate(WIDTH + SPACING, 0);

      Letters.drawO(g2, bounds);
      bounds.translate(WIDTH + SPACING, 0);

      Letters.drawL(g2, bounds);
      bounds.translate(WIDTH + SPACING, 0);

      Letters.drawE(g2, bounds);
   }
}
