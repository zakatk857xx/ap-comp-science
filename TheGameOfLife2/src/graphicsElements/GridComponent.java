package graphicsElements;

import javax.swing.JComponent;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.*;
import gameElements.Grid;

public class GridComponent extends JComponent implements MouseListener
{     
     public static final int RECTANGLE = 0;
     public static final int CIRCLE = 1;
     
     private Grid grid;
     private int unitSize;
     private int cellShape;
     private boolean gridIsVisible;    
     private boolean fillCell;
     private Color gridColor;
     private Color cellColor;
     private Color backgroundColor;
     
     /**
      * 
      * @param n the size of the grid
      */
     public GridComponent(Grid g, int s)
     {
          this.addMouseListener(this);
          
          grid = g;
          unitSize = s;
          cellShape = 1;
          gridIsVisible = true;
          fillCell = false;
          gridColor = Color.GRAY;
          cellColor = Color.RED;    
          backgroundColor = new Color(236, 236, 236);
     }
     
     /**
      * paints the component in a frame
      */
     public void paintComponent(Graphics g)
     {
          Graphics2D g2 = (Graphics2D) g;
          
          g2.setColor(this.backgroundColor);
          g2.fillRect(0, 0, this.unitSize * this.grid.getSize(),
                      this.unitSize * this.grid.getSize());
          
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
                    e = new Ellipse2D.Double(i * this.unitSize,
                                             j * this.unitSize,
                                             this.unitSize,
                                             this.unitSize);
                    
                    //if is occupied, fill in cell
                    if(grid.isOccupied(i, j))
                    {
                         g2.setColor(this.cellColor);
                         
                         if(this.cellShape == GridComponent.RECTANGLE)
                         {
                              if(!fillCell)
                              {
                                   r.setFrame(r.x + (this.unitSize / 5),
                                              r.y + (this.unitSize / 5),
                                              3 * (this.unitSize / 5),
                                              3 * (this.unitSize / 5));
                              }
                              
                              g2.fill(r);
                         }
                         else if (this.cellShape == GridComponent.CIRCLE)
                         {
                              if(!fillCell)
                              {
                                   e.setFrame(r.x + (this.unitSize / 5),
                                              r.y + (this.unitSize / 5),
                                              3 * (this.unitSize / 5),
                                              3 * (this.unitSize / 5));
                              }
                              
                              g2.fill(e);
                         }
                    }         
               }
          }
          
          if(gridIsVisible)
          {
               g2.setColor(this.gridColor); 
               for(int i = 0; i <= this.grid.getSize(); i++)
               {
                    g2.drawLine(i * this.unitSize, 0,
                                i * this.unitSize,
                                this.grid.getSize() * this.unitSize);
                    g2.drawLine(0, i * this.unitSize,
                                this.grid.getSize() * this.unitSize, i * this.unitSize);
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
     
     public void setVisibleGrid(boolean isVisible)
     {
          if(isVisible)
               gridIsVisible = true;
          if(!isVisible)
               gridIsVisible = false;
     }
     
     public boolean getVisibleGrid()
     {
          return gridIsVisible;
     }
     
     public void setCellShape(int shape)
     {
          if(shape == GridComponent.RECTANGLE)
               cellShape = GridComponent.RECTANGLE;
          else if(shape == GridComponent.CIRCLE)
               cellShape = GridComponent.CIRCLE;
     }
     
     public void setGridColor(Color c)
     {
          gridColor = c;
     }
     
     public void setCellColor(Color c)
     {
          cellColor = c;
     }
     
     public Color getGridColor()
     {
          return gridColor;
     }
     
     public Color getCellColor()
     {
          return cellColor;
     }
     
     public void setBackgroundColor(Color c)
     {
          backgroundColor = c;;
     }
     
     public Color getBackgroundColor()
     {
          return backgroundColor;
     }
     
     public void setCellsFilled(boolean f)
     {
          fillCell = f;
     }
     
     public boolean areCellsFilled()
     {
          return fillCell;
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
