import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class SidePanel extends JPanel
{
     private int                     player = 1;
     private final ArrayList<Player> players;
     private final BoardComponent    board;

     private final JTextField        valX1  = new JTextField("<x1>");
     private final JTextField        valY1  = new JTextField("<y1>");
     private final JTextField        valX2  = new JTextField("<x2>");
     private final JTextField        valY2  = new JTextField("<y2>");

     private final JLabel            name;
     private final JLabel            wallsLeft;
     private final ColorComponent    pColor;

     // public SidePanel() {}

     // public void add(BoardComponent b) {final BoardComponent board = b;}
     // public void add(ArrayList<Player> p) {final ArrayList<Player> players =
     // p;}

     public SidePanel(BoardComponent b, ArrayList<Player> p)
     {
          board = b;
          players = p;

          JButton up = new JButton("UP");
          class ButtonListener1 implements ActionListener
          {
               public void actionPerformed(ActionEvent event)
               {
                    boolean moved = players.get(player - 1).movePiece("UP",
                              board);

                    // System.out.println(moved);

                    if (moved)
                    {
                         if (players.get(player - 1).checkWin())
                         {
                              board.repaint();
                              JOptionPane.showMessageDialog(null,
                                        "Congratulations, "
                                                  + players.get(player - 1)
                                                            .getName()
                                                  + ", YOU WIN!", null, 1);
                              System.exit(-1);
                         }

                         player++;
                         if (player > players.size())
                              player = 1;
                    }

                    board.repaint();
               }
          }
          ActionListener listener1 = new ButtonListener1();
          up.addActionListener(listener1);

          JButton down = new JButton("DOWN");
          class ButtonListener2 implements ActionListener
          {
               public void actionPerformed(ActionEvent event)
               {
                    boolean moved = players.get(player - 1).movePiece("DOWN",
                              board);

                    // System.out.println(moved);

                    if (moved)
                    {
                         // System.out.println(player);

                         if (players.get(player - 1).checkWin())
                         {
                              board.repaint();
                              JOptionPane.showMessageDialog(null,
                                        "Congratulations, "
                                                  + players.get(player - 1)
                                                            .getName()
                                                  + ", YOU WIN!", null, 1);
                              System.exit(-1);
                         }

                         player++;
                         if (player > players.size())
                              player = 1;
                    }

                    board.repaint();
               }
          }
          ActionListener listener2 = new ButtonListener2();
          down.addActionListener(listener2);

          JButton left = new JButton("LEFT");
          class ButtonListener3 implements ActionListener
          {
               public void actionPerformed(ActionEvent event)
               {
                    boolean moved = players.get(player - 1).movePiece("LEFT",
                              board);

                    // System.out.println(moved);

                    if (moved)
                    {
                         // System.out.println(player);

                         if (players.get(player - 1).checkWin())
                         {
                              board.repaint();
                              JOptionPane.showMessageDialog(null,
                                        "Congratulations, "
                                                  + players.get(player - 1)
                                                            .getName()
                                                  + ", YOU WIN!", null, 1);
                              System.exit(-1);
                         }

                         player++;
                         if (player > players.size())
                              player = 1;
                    }

                    board.repaint();
               }
          }
          ActionListener listener3 = new ButtonListener3();
          left.addActionListener(listener3);

          JButton right = new JButton("RIGHT");
          class ButtonListener4 implements ActionListener
          {
               public void actionPerformed(ActionEvent event)
               {
                    boolean moved = players.get(player - 1).movePiece("RIGHT",
                              board);

                    // System.out.println(moved);

                    if (moved)
                    {
                         // System.out.println(player);

                         if (players.get(player - 1).checkWin())
                         {
                              board.repaint();
                              JOptionPane.showMessageDialog(null,
                                        "Congratulations, "
                                                  + players.get(player - 1)
                                                            .getName()
                                                  + ", YOU WIN!", null, 1);
                              System.exit(-1);
                         }

                         player++;
                         if (player > players.size())
                              player = 1;
                    }

                    board.repaint();
               }
          }
          ActionListener listener4 = new ButtonListener4();
          right.addActionListener(listener4);

          ColorComponent dummy1 = new ColorComponent(Color.LIGHT_GRAY);
          ColorComponent dummy2 = new ColorComponent(Color.LIGHT_GRAY);
          ColorComponent dummy3 = new ColorComponent(Color.LIGHT_GRAY);
          ColorComponent dummy4 = new ColorComponent(Color.LIGHT_GRAY);
          ColorComponent dummy5 = new ColorComponent(Color.LIGHT_GRAY);

          JPanel move = new JPanel();

          move.setLayout(new GridLayout(3, 3));

          move.add(dummy1);
          move.add(up);
          move.add(dummy2);
          move.add(left);
          move.add(dummy3);
          move.add(right);
          move.add(dummy4);
          move.add(down);
          move.add(dummy5);

          JLabel x1y1 = new JLabel("(x1, y1):", SwingConstants.CENTER);
          JLabel x2y2 = new JLabel("(x2, y2):", SwingConstants.CENTER);

          JButton place = new JButton("PLACE");
          class ButtonListener5 implements ActionListener
          {
               public void actionPerformed(ActionEvent event)
               {
                    int x1 = Integer.parseInt(valX1.getText());
                    int y1 = Integer.parseInt(valY1.getText());
                    int x2 = Integer.parseInt(valX2.getText());
                    int y2 = Integer.parseInt(valY2.getText());

                    boolean placed = players.get(player - 1).placeWall(
                              new Wall(x1, y1, x2, y2), board);

                    System.out.println(placed);

                    if (placed)
                    {
                         player++;
                         if (player > players.size())
                              player = 1;
                    }

                    board.repaint();
               }
          }
          ActionListener listener5 = new ButtonListener5();
          place.addActionListener(listener5);

          JPanel wall = new JPanel();
          wall.setLayout(new GridLayout(2, 1));

          JPanel wallVals = new JPanel();
          wallVals.setLayout(new GridLayout(2, 3));
          wallVals.add(x1y1);
          wallVals.add(valX1);
          wallVals.add(valY1);
          wallVals.add(x2y2);
          wallVals.add(valX2);
          wallVals.add(valY2);

          wall.add(wallVals);
          wall.add(place);

          JPanel currentPlayer = new JPanel();
          currentPlayer.setLayout(new GridLayout(3, 2));

          name = new JLabel("Name: " + players.get(player - 1).getName());
          class LabelListener1 implements ChangeListener
          {
               public void stateChanged(ChangeEvent event)
               {
                    name.setText("Name: " + players.get(player - 1).getName());
               }
          }
          ChangeListener listener6 = new LabelListener1();
          up.addChangeListener(listener6);
          down.addChangeListener(listener6);
          right.addChangeListener(listener6);
          left.addChangeListener(listener6);
          place.addChangeListener(listener6);

          JLabel color = new JLabel("Color: ");
          color.setHorizontalAlignment(SwingConstants.LEFT);

          wallsLeft = new JLabel("Walls Left: "
                    + players.get(player - 1).getNumWalls());
          class LabelListener3 implements ChangeListener
          {
               public void stateChanged(ChangeEvent event)
               {
                    wallsLeft.setText("Walls Left: "
                              + players.get(player - 1).getNumWalls());
               }
          }
          ChangeListener listener8 = new LabelListener3();
          up.addChangeListener(listener8);
          down.addChangeListener(listener8);
          right.addChangeListener(listener8);
          left.addChangeListener(listener8);
          place.addChangeListener(listener8);

          ColorComponent gray1 = new ColorComponent(Color.LIGHT_GRAY);
          ColorComponent gray2 = new ColorComponent(Color.LIGHT_GRAY);
          pColor = new ColorComponent(players.get(player - 1).getColor());
          class ColorListener1 implements ChangeListener
          {
               public void stateChanged(ChangeEvent event)
               {
                    pColor.setColor(players.get(player - 1).getColor());
                    pColor.repaint();
               }
          }
          ChangeListener listener9 = new ColorListener1();
          up.addChangeListener(listener9);
          down.addChangeListener(listener9);
          right.addChangeListener(listener9);
          left.addChangeListener(listener9);
          place.addChangeListener(listener9);

          currentPlayer.add(name);
          currentPlayer.add(gray1);
          currentPlayer.add(color);
          currentPlayer.add(pColor);
          // System.out.println(players.get(player - 1).getColor());
          currentPlayer.add(wallsLeft);
          currentPlayer.add(gray2);

          JPanel label1 = new JPanel();
          label1.setLayout(new GridLayout(3, 1));
          label1.add(new JLabel(
                    "____________________",
                    SwingConstants.CENTER));
          label1.add(new JLabel("Movement", SwingConstants.CENTER));
          label1.add(new JLabel(
                    "____________________",
                    SwingConstants.CENTER));

          JPanel label2 = new JPanel();
          label2.setLayout(new GridLayout(3, 1));
          label2.add(new JLabel(
                    "____________________",
                    SwingConstants.CENTER));
          label2.add(new JLabel("Wall Placement", SwingConstants.CENTER));
          label2.add(new JLabel(
                    "____________________",
                    SwingConstants.CENTER));

          JPanel label3 = new JPanel();
          label3.setLayout(new GridLayout(3, 1));
          label3.add(new JLabel(
                    "____________________",
                    SwingConstants.CENTER));
          label3.add(new JLabel("Current Player Stats", SwingConstants.CENTER));
          label3.add(new JLabel(
                    "____________________",
                    SwingConstants.CENTER));

          this.setLayout(new GridLayout(6, 1));

          this.add(label1);
          this.add(move);
          this.add(label2);
          this.add(wall);
          this.add(label3);
          this.add(currentPlayer);
     }

     public void setVals(BoardComponent b)
     {
          valX1.setText((Double.toString(Math
                    .round(b.getNewWall().getX1() / 50))).substring(0, 1));
          valY1.setText((Double.toString(Math
                    .round(b.getNewWall().getY1() / 50))).substring(0, 1));
          valX2.setText((Double.toString(Math
                    .round(b.getNewWall().getX2() / 50))).substring(0, 1));
          valY2.setText((Double.toString(Math
                    .round(b.getNewWall().getY2() / 50))).substring(0, 1));
     }

     public int getX1()
     {
          return Integer.parseInt(valX1.getText());
     }

     public int getY1()
     {
          return Integer.parseInt(valY1.getText());
     }

     public int getX2()
     {
          return Integer.parseInt(valX2.getText());
     }

     public int getY2()
     {
          return Integer.parseInt(valY2.getText());
     }

     public int getPlayer()
     {
          return player;
     }

     public void setPlayer(int i)
     {
          player = i;
     }

     public void incPlayer()
     {
          player++;
     }

     public void refresh()
     {
          name.setText("Name: " + players.get(player - 1).getName());

          wallsLeft.setText("Walls Left: "
                    + players.get(player - 1).getNumWalls());

          pColor.setColor(players.get(player - 1).getColor());
          pColor.repaint();
     }

}
