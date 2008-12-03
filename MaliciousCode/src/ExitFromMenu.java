import java.awt.*;
import java.awt.event.*;

public class ExitFromMenu extends Frame implements ActionListener
{
     Menu m = new Menu("Exit From Here");

     ExitFromMenu()
     {
          super("");
          MenuBar mb = new MenuBar();

          mb.add(m);
          MenuItem m1 = m.add(new MenuItem("Exit", new MenuShortcut(
                    KeyEvent.VK_X)));
          m1.setActionCommand("Exit");
          m.addActionListener(this);

          setMenuBar(mb);

          addWindowListener(new WindowAdapter() {
               public void windowClosing(WindowEvent e)
               {
                    // unique exit point
                    System.out.println("Bye.");
                    System.exit(0);
               }
          });
          add(new Label("You can quit by clicking on the 'X'"), "South");
          add(new Label("You can quit by clicking on the menu item 'Exit'"),
                    "Center");
          add(new Label("You can quit with the MenuShortcut 'ctrl-x'"), "North");
          setSize(300, 300);
          this.setVisible(true);
     }

     public void actionPerformed(ActionEvent evt)
     {
          String what = evt.getActionCommand();

          if (what.equals("Exit"))
               processEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
     }

     static public void main(String[] args)
     {
          new ExitFromMenu();
     }
}
