import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;


public class ColorComponent extends JComponent
{
  	  private Color color;
  	  
  	  public ColorComponent(Color c)
  	  {
  		  color = c;
  	  }
  	  
  	  public void paintComponent(Graphics g)
  	  {
  		  Graphics2D g2 = (Graphics2D) g;
  		  
  		  g2.setColor(color);
  		  if(color != Color.LIGHT_GRAY)
  		  {
  			  g2.fill(new Rectangle2D.Double(this.getHeight() / 2 - 6.25,
  					  this.getHeight() / 2 - 6.25, 25, 12.5));
  			  g2.setColor(Color.BLACK);
  			  g2.draw(new Rectangle2D.Double(this.getHeight() / 2 - 6.25, 
  					  this.getHeight() / 2 - 6.25, 25, 12.5));
  		  }
  	  }
  	  
  	  public void setColor(Color c)
  	  {
  		  color = c;
  	  }
}


