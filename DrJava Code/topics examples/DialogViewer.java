import javax.swing.JOptionPane;

public class DialogViewer
{
     public static void main(String beans[])
     {
          String name = JOptionPane.showInputDialog("What is your name?");
          System.out.println("Hello, " + name + "!");
          System.exit(0);
     }
}