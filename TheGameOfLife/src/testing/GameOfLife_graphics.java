package testing;

import gameElements.Grid;
import graphicsElements.GridComponent;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GameOfLife_graphics
{
     public static void main(String args [])
     {
          JFrame frame = new JFrame("The Game of Life");     
          
          int sideDimension;
          int sizeConstant;
          
          sideDimension  = Integer.parseInt(JOptionPane.showInputDialog(
                 null, "Enter side dimension:",
                 "Welcome to The Game of Life!", JOptionPane.PLAIN_MESSAGE));
          sizeConstant = Integer.parseInt(JOptionPane.showInputDialog(
                    null, "Enter size constant:",
                    "Welcome to The Game of Life!", JOptionPane.PLAIN_MESSAGE));
          
          final Grid g = new Grid(sideDimension);
          final GridComponent grid = new GridComponent(g, sizeConstant);
          
          ////Glider Test:
          //g.changeState(2, 1);
          //g.changeState(3, 2);
          //g.changeState(3, 3);
          //g.changeState(2, 3);
          //g.changeState(1, 3);
          
          JButton nextGen = new JButton("Next Generation");          
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
          
          JPanel bottomPanel = new JPanel();
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
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
     
     public static void addMenuBar(JFrame window, final Grid g, final GridComponent grid)
     {
          JMenuBar mainMenu = new JMenuBar();
          
          JMenu file = new JMenu("File");  
          JMenuItem reset = new JMenuItem("Reset"); 
          JMenuItem exit = new JMenuItem("Exit"); 
          exit.setFocusable(true);
          exit.setFocusable(true);
          
          class exitListener implements ActionListener
          {
               public void actionPerformed(ActionEvent e)
               {
                    System.exit(-1);
               }
          }
          ActionListener quit = new exitListener();
          exit.addActionListener(quit);
          
          class resetListener implements ActionListener
          {
               public void actionPerformed(ActionEvent e)
               {
                    g.redefine(Integer.parseInt(JOptionPane.showInputDialog(
                              null, "Enter side dimension:",
                              "Define new grid...",
                              JOptionPane.PLAIN_MESSAGE)));
                    grid.repaint();                    
               }
          }
          ActionListener resetGrid = new resetListener();
          reset.addActionListener(resetGrid);
          
          file.add(reset);
          file.add(exit);
          mainMenu.add(file);
          
          window.add(mainMenu, BorderLayout.NORTH);
     }
}
