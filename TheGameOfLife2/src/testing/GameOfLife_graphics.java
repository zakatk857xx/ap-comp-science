package testing;

import gameElements.Grid;
import graphicsElements.GridComponent;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.MenuShortcut;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class GameOfLife_graphics
{
     public static void main(String args [])
     {
          Frame frame = new Frame("The Game of Life");     
          
          int sideDimension;
          int sizeConstant = 0;
          
          sideDimension  = Integer.parseInt(JOptionPane.showInputDialog(
                                                                        null, "Enter the length of one side of the grid:",
                                                                        "Welcome to The Game of Life!", JOptionPane.PLAIN_MESSAGE));
          while(sizeConstant < 1 || sizeConstant > 50)
          {
               sizeConstant = Integer.parseInt(JOptionPane.showInputDialog(
                                                                           null, "Enter size constant [1-50]:",
                                                                           "Welcome to The Game of Life!", JOptionPane.PLAIN_MESSAGE));
               
               if(sizeConstant < 1 || sizeConstant > 50)
               {
                    JOptionPane.showMessageDialog(
                                                  null, "Please enter a size constant in the range [1-50]:",
                                                  "Welcome to The Game of Life!", JOptionPane.INFORMATION_MESSAGE);
               }
          }
          
          final Grid g = new Grid(sideDimension);
          final GridComponent grid = new GridComponent(g, sizeConstant);
          
          Button nextGen = new Button("Next Generation");          
          class ButtonListener implements ActionListener
          {
               public void actionPerformed(ActionEvent event)
               {                     
                    g.nextGeneration();
                    grid.repaint();
               }
          }
          ActionListener listener1 = new ButtonListener();
          nextGen.addActionListener(listener1);
          
          Panel bottomPanel = new Panel();
          bottomPanel.setLayout(new GridLayout(3,1));
          final JSlider boxSizeSlider  = new JSlider(0, 50, sizeConstant);
          
          class SizeListener implements ChangeListener
          {
               public void stateChanged(ChangeEvent event)
               {
                    grid.setBoxSize(boxSizeSlider.getValue());
                    grid.repaint();
               }
          }          
          ChangeListener listener2 = new SizeListener();
          boxSizeSlider.addChangeListener(listener2);
          
          final JLabel boxSizeNum = new JLabel("Box Size" + Integer.toString(sizeConstant));   
          boxSizeNum.setHorizontalAlignment(SwingConstants.LEFT);
          class LabelListener implements ChangeListener
          {
               public void stateChanged(ChangeEvent event)
               {
                    boxSizeNum.setText("Box Size: " + boxSizeSlider.getValue());
               }
          }
          ChangeListener listener3 = new LabelListener();
          boxSizeSlider.addChangeListener(listener3);
          
          bottomPanel.add(boxSizeNum);
          bottomPanel.add(boxSizeSlider);
          bottomPanel.add(nextGen);
          
          final int FRAME_HEIGHT = 700;
          final int FRAME_WIDTH = 700;
          
          frame.add(grid, BorderLayout.CENTER);
          frame.add(bottomPanel, BorderLayout.SOUTH);
          addMenuBar(frame, g, grid);
          
          frame.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
          frame.setVisible(true);          
          frame.setAlwaysOnTop(false);
          frame.setResizable(false);
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
     
     public static void addMenuBar(Frame window, final Grid g, final GridComponent grid)
     {
          MenuBar mainMenu = new MenuBar();
          
          Menu file = new Menu("File");  
          Menu reset = new Menu("Reset");
          MenuItem reset_a = new MenuItem("All");
          MenuItem reset_c = new MenuItem("Color");
          MenuItem redefine = new MenuItem("Redefine"); 
          MenuItem exit = new MenuItem("Exit"); 
          
          Menu options = new Menu("Options");  
          Menu gridVisible = new Menu("Show/Hide Grid"); 
          final MenuItem grid_v = new MenuItem("Change to Hidden"); 
          Menu color = new Menu("Colors"); 
          final MenuItem color_g = new MenuItem("Grid", new MenuShortcut(
                    KeyEvent.VK_X)); 
          final MenuItem color_c = new MenuItem("Cells");
          final MenuItem color_b = new MenuItem("Background");
          Menu shape = new Menu("Cell Shape");
          final MenuItem shape_c = new MenuItem("Circle"); 
          final MenuItem shape_r = new MenuItem("Rectangle");
          Menu filled = new Menu("Fill"); 
          final MenuItem shape_f = new MenuItem("Change to Filled");
          
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
                    g.reset(Integer.parseInt(JOptionPane.showInputDialog(
                                                                         null, "Enter side dimension:",
                                                                         "Define new grid...",
                                                                         JOptionPane.PLAIN_MESSAGE)));
                    
                    grid.setVisibleGrid(true);
                    grid_v.setLabel("Change to Hidden");
                    grid.setGridColor(Color.GRAY);
                    grid.setCellColor(Color.RED);
                    grid.setBackgroundColor(new Color(236, 236, 236));
                    grid.setCellShape(GridComponent.CIRCLE);
                    grid.setCellsFilled(false);
                    shape_f.setLabel("Change to Filled");
                    
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
                    grid_v.setLabel("Change to Hidden");
                    grid.setGridColor(Color.GRAY);
                    grid.setCellColor(Color.RED);
                    grid.setBackgroundColor(new Color(236, 236, 236));
                    grid.setCellsFilled(false);
                    grid.setCellShape(GridComponent.CIRCLE);
                    shape_f.setLabel("Change to Filled");
                    
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
                                                                            "Redefine grid...",
                                                                            JOptionPane.PLAIN_MESSAGE)));
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
                    
                    if(grid.getVisibleGrid())
                         grid_v.setLabel("Change to Hidden"); 
                    else if (!grid.getVisibleGrid())
                         grid_v.setLabel("Change to Visible");
                    
                    grid.repaint();
               }
          }
          ActionListener listener2 = new gridVisibleListener();
          grid_v.addActionListener(listener2);
          
          class colorGridListener implements ActionListener
          {
               public void actionPerformed(ActionEvent e)
               {       
                    grid.setGridColor(JColorChooser.showDialog(null, "Pick a Color:",
                                                               grid.getGridColor()));
                    grid.repaint();
               }
          }
          ActionListener listener3 = new colorGridListener();
          color_g.addActionListener(listener3);
          
          class colorCellListener implements ActionListener
          {
               public void actionPerformed(ActionEvent e)
               {
                    grid.setCellColor(JColorChooser.showDialog(null, "Pick a Color:",
                                                               grid.getCellColor()));
                    grid.repaint();
               }
          }
          ActionListener listener4 = new colorCellListener();
          color_c.addActionListener(listener4);
          
          class colorBgListener implements ActionListener
          {
               public void actionPerformed(ActionEvent e)
               {
                    grid.setBackgroundColor(JColorChooser.showDialog(null, "Pick a Color:",
                                                                     grid.getCellColor()));
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
                    
                    if(grid.areCellsFilled())
                         shape_f.setLabel("Change to Spaced"); 
                    else if (!grid.areCellsFilled())
                         shape_f.setLabel("Change to Filled");
                    
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
