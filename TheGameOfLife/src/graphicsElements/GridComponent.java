package graphicsElements;

import javax.swing.JComponent;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.*;
import gameElements.Grid;

public class GridComponent extends JComponent implements MouseListener
{     
     private Grid grid;
     private int unitSize;
     
     /**
      * 
      * @param n the size of the grid
      */
     public GridComponent(Grid g, int s)
     {
          this.addMouseListener(this);
          
          grid = g;
          unitSize = s;
     }
     
     /**
      * paints the component in a frame
      */
     public void paintComponent(Graphics g)
     {
          Graphics2D g2 = (Graphics2D) g;
          
          Rectangle2D.Double r;
          Ellipse2D.Double e = new Ellipse2D.Double();
          
          for (int i = 0; i < this.grid.getSize(); i++)
          {
               for (int j = 0; j < this.grid.getSize(); j++)
               {
                    r = new Rectangle2D.Double(i * this.unitSize,
                                               j * this.unitSize,
                                               this.unitSize,
                                               this.unitSize);
                    g2.setColor(Color.GRAY);                    
                    g2.draw(r);
                    
                    //test to see which cells have been manipulated
                    //System.out.println("(" + i + ", " + j + ") = " + grid.isOccupied(i, j));
                    
                    //if is occupied, fill in cell
                    if(grid.isOccupied(i, j))
                    {
                         e.setFrame(r.x + (this.unitSize / 5),
                                    r.y + (this.unitSize / 5),
                                    3 * (this.unitSize / 5),
                                    3 * (this.unitSize / 5));
                         g2.setColor(Color.RED);
                         g2.fill(e);
                    }         
               }
          }
     }
     
     public Grid getGrid()
     {
          return this.grid;
     }
     
     public void setBoxSize(int s)
     {
          this.unitSize = s;
          this.repaint();
     }
     
     public void mouseExited(MouseEvent e) {}
     public void mouseEntered(MouseEvent e) {}     
     public void mouseClicked(MouseEvent e) {}
     public void mousePressed(MouseEvent e) {}
     public void mouseReleased(MouseEvent e) 
     {     
          this.grid.changeState(Math.round((e.getY() / this.unitSize)),
                    Math.round((e.getX() / this.unitSize)));
          this.repaint();
     }

}
