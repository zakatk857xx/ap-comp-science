import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
   This component draws a message by constructing individual letter objects.
   This is solution is more object oriented because each letter is separated
   to perform its own duty.
*/
public class LettersComponent extends JComponent
{
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;

      final int WIDTH = 30;
      final int HEIGHT = 50;
      final int SPACING = 5;

      Rectangle bounds = new Rectangle(0, 0, WIDTH, HEIGHT);

      LetterH h = new LetterH(bounds);
      h.draw(g2);
      bounds.translate(WIDTH + SPACING, 0);

      LetterE e = new LetterE(bounds);
      e.draw(g2);
      bounds.translate(WIDTH + SPACING, 0);

      LetterL l1 = new LetterL(bounds);
      l1.draw(g2);
      bounds.translate(WIDTH + SPACING, 0);

      LetterL l2 = new LetterL(bounds);
      l2.draw(g2);
      bounds.translate(WIDTH + SPACING, 0);

      LetterO o = new LetterO(bounds);
      o.draw(g2);

      bounds = new Rectangle(0, HEIGHT + SPACING, WIDTH, HEIGHT);

      LetterH h2 = new LetterH(bounds);
      h2.draw(g2);
      bounds.translate(WIDTH + SPACING, 0);

      LetterO o2 = new LetterO(bounds);
      o2.draw(g2);
      bounds.translate(WIDTH + SPACING, 0);

      LetterL l3 = new LetterL(bounds);
      l3.draw(g2);
      bounds.translate(WIDTH + SPACING, 0);

      LetterE e2 = new LetterE(bounds);
      e2.draw(g2);
   }
}
