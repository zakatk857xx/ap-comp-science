import javax.swing.JFrame;

/**
   This program shows the message "HELLO".
*/
public class HelloViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      final int FRAME_WIDTH = 200;
      final int FRAME_HEIGHT = 150;

      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setTitle("HelloViewer");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      LettersComponent component = new LettersComponent();
      frame.add(component);

      frame.setVisible(true);
   }
}
