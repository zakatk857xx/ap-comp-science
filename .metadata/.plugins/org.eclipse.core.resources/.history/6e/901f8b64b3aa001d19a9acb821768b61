
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Game
{
     public static void main(String[] args)
     {
          JFrame frame = new JFrame("The Game of Life");
          
          int sizeConstant = 50;

          final Grid g = new Grid(10);
          final GridComponent grid = new GridComponent(g, sizeConstant);

          final int FRAME_HEIGHT = 700;
          final int FRAME_WIDTH = 700;

          frame.add(grid, BorderLayout.CENTER);
          addMenuBar(frame, g, grid);

          frame.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
          frame.setVisible(true);
          frame.setAlwaysOnTop(false);
          frame.setResizable(false);
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }

     public static void addMenuBar(JFrame window, final Grid g,
               final GridComponent grid)
     {
          JMenuBar mainMenu = new JMenuBar();

          JMenu file = new JMenu("File");
          JMenu reset = new JMenu("Reset");
          JMenuItem reset_a = new JMenuItem("All");
          JMenuItem reset_c = new JMenuItem("Color");
          JMenuItem redefine = new JMenuItem("Redefine");
          JMenuItem exit = new JMenuItem("Exit");

          JMenu options = new JMenu("Options");
          JMenu gridVisible = new JMenu("Show/Hide Grid");
          final JMenuItem grid_v = new JMenuItem("Change to Hidden");
          JMenu color = new JMenu("Colors");
          final JMenuItem color_g = new JMenuItem("Grid");
          final JMenuItem color_c = new JMenuItem("Cells");
          final JMenuItem color_b = new JMenuItem("Background");
          JMenu shape = new JMenu("Cell Shape");
          final JMenuItem shape_c = new JMenuItem("Circle");
          final JMenuItem shape_r = new JMenuItem("Rectangle");
          JMenu filled = new JMenu("Fill");
          final JMenuItem shape_f = new JMenuItem("Change to Filled");

          class exitListener implements ActionListener
          {
               public void actionPerformed(ActionEvent e)
               {
                    System.exit(-1);
               }
          }
          ActionListener listener0 = new exitListener();
          exit.addActionListener(listener0);

          class resetAllListener implements ActionListener
          {
               public void actionPerformed(ActionEvent e)
               {
                    g.reset(Integer.parseInt(JOptionPane.showInputDialog(null,
                              "Enter side dimension:", "Define new grid...",
                              JOptionPane.PLAIN_MESSAGE)));

                    grid.setVisibleGrid(true);
                    grid_v.setText("Change to Hidden");
                    grid.setGridColor(Color.GRAY);
                    grid.setCellColor(Color.RED);
                    grid.setBackgroundColor(new Color(236, 236, 236));
                    grid.setCellShape(GridComponent.CIRCLE);
                    grid.setCellsFilled(false);
                    shape_f.setText("Change to Filled");

                    grid.repaint();
               }
          }
          ActionListener listener1 = new resetAllListener();
          reset_a.addActionListener(listener1);

          class resetColorListener implements ActionListener
          {
               public void actionPerformed(ActionEvent e)
               {
                    grid.setVisibleGrid(true);
                    grid_v.setText("Change to Hidden");
                    grid.setGridColor(Color.GRAY);
                    grid.setCellColor(Color.RED);
                    grid.setBackgroundColor(new Color(236, 236, 236));
                    grid.setCellsFilled(false);
                    grid.setCellShape(GridComponent.CIRCLE);
                    shape_f.setText("Change to Filled");

                    grid.repaint();
               }
          }
          ActionListener listener1a = new resetColorListener();
          reset_c.addActionListener(listener1a);

          class redefineListener implements ActionListener
          {
               public void actionPerformed(ActionEvent e)
               {
                    g.redefine(Integer.parseInt(JOptionPane.showInputDialog(
                              null, "Enter side dimension:",
                              "Redefine grid...", JOptionPane.PLAIN_MESSAGE)));
                    grid.repaint();
               }
          }
          ActionListener listener1b = new redefineListener();
          redefine.addActionListener(listener1b);

          class gridVisibleListener implements ActionListener
          {
               public void actionPerformed(ActionEvent e)
               {
                    grid.setVisibleGrid(!grid.getVisibleGrid());

                    if (grid.getVisibleGrid())
                         grid_v.setText("Change to Hidden");
                    else if (!grid.getVisibleGrid())
                         grid_v.setText("Change to Visible");

                    grid.repaint();
               }
          }
          ActionListener listener2 = new gridVisibleListener();
          grid_v.addActionListener(listener2);

          class colorGridListener implements ActionListener
          {
               public void actionPerformed(ActionEvent e)
               {
                    grid.setGridColor(JColorChooser.showDialog(null,
                              "Pick a Color:", grid.getGridColor()));
                    grid.repaint();
               }
          }
          ActionListener listener3 = new colorGridListener();
          color_g.addActionListener(listener3);

          class colorCellListener implements ActionListener
          {
               public void actionPerformed(ActionEvent e)
               {
                    grid.setCellColor(JColorChooser.showDialog(null,
                              "Pick a Color:", grid.getCellColor()));
                    grid.repaint();
               }
          }
          ActionListener listener4 = new colorCellListener();
          color_c.addActionListener(listener4);

          class colorBgListener implements ActionListener
          {
               public void actionPerformed(ActionEvent e)
               {
                    grid.setBackgroundColor(JColorChooser.showDialog(null,
                              "Pick a Color:", grid.getCellColor()));
                    grid.repaint();
               }
          }
          ActionListener listener4a = new colorBgListener();
          color_b.addActionListener(listener4a);

          class cellRectangleListener implements ActionListener
          {
               public void actionPerformed(ActionEvent e)
               {
                    grid.setCellShape(GridComponent.RECTANGLE);
                    grid.repaint();
               }
          }
          ActionListener listener5 = new cellRectangleListener();
          shape_r.addActionListener(listener5);

          class cellCircleListener implements ActionListener
          {
               public void actionPerformed(ActionEvent e)
               {
                    grid.setCellShape(GridComponent.CIRCLE);
                    grid.repaint();
               }
          }
          ActionListener listener6 = new cellCircleListener();
          shape_c.addActionListener(listener6);

          class filledCellListener implements ActionListener
          {
               public void actionPerformed(ActionEvent e)
               {
                    grid.setCellsFilled(!grid.areCellsFilled());

                    if (grid.areCellsFilled())
                         shape_f.setText("Change to Spaced");
                    else if (!grid.areCellsFilled())
                         shape_f.setText("Change to Filled");

                    grid.repaint();
               }
          }
          ActionListener listener7 = new filledCellListener();
          shape_f.addActionListener(listener7);

          reset.add(reset_c);
          reset.add(reset_a);
          file.add(reset);
          file.add(redefine);
          file.add(exit);
          shape.add(shape_r);
          shape.add(shape_c);
          filled.add(shape_f);
          shape.add(filled);
          color.add(color_g);
          color.add(color_c);
          color.add(color_b);
          gridVisible.add(grid_v);
          options.add(gridVisible);
          options.add(color);
          options.add(shape);
          mainMenu.add(file);
          mainMenu.add(options);

          window.add(mainMenu, BorderLayout.NORTH);
     }

}
