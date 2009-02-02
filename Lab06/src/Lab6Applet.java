import java.applet.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.Random;

/**
 * 
 * Applet stuff
 * 
 * @author Thomas Zaki
 * Nov 21, 2008
 *
 */
public class Lab6Applet extends Applet implements MouseListener, MouseMotionListener, KeyListener
{
     
     //This shape will be controlled within the Applet
     private Rectangle2D.Double box;
     private Ellipse2D.Double cir;
     private double x, y, horiz, vert;
     private Color color;
     private Random gen;
     private String text;
     private int face;
     
     //elements of the string, to allow for a complete and varying description
     private boolean grow, shrink, stretch, squish, blink, smile, frown, isBox;
     
     private static final int BOX_SMILE = 1;
     private static final int BOX_NONE  = 0;
     private static final int BOX_FROWN = -1;
     
     public void init()
     {
          horiz = 100.0;
          vert = 100.0;
          x = this.getWidth()/2 - horiz/2;
          y = this.getHeight()/2 - vert/2;
          box = new Rectangle2D.Double (x, y, horiz, vert);
          cir = new Ellipse2D.Double (x, y, horiz, vert);
          color = Color.red; 
          isBox = true;
          text = "THIS BOX IS DOING NOTHING SPECIAL.";
          gen = new Random();        
                    
          
          //This code sets the Applet up to allow for and react to keyboard input.
          this.setFocusable(true);
          this.addKeyListener(this);
          this.addMouseMotionListener(this);
          this.addMouseListener(this);
          this.repaint();
          
     }//end init
     
     //This method paints (or updates) the shape(s) on the screen
     public void paint(Graphics g)
     {
          //recover Graphics2D
          Graphics2D g2 = (Graphics2D)g;
          
          box.setFrame(x, y, horiz, vert);
          cir.setFrame(x, y, horiz, vert);
          
          g2.setColor(color);
          if(isBox)
               g2.fill(box);
          else
               g2.fill(cir);
          g2.setColor(Color.BLACK);
          if(isBox)
               g2.draw(box);
          else
               g2.draw(cir);
          g2.drawString(text, (int)x, (int)y);
          
          if(isBox)
               text = "THIS BOX IS ";
          else
               text = "THIS CIRCLE IS ";
          
          if(grow)
               text += "GROWING AND ";
          if(shrink)
               text += "SHRINKING AND ";
          if(stretch)
               text += "STRETCHING AND ";
          if(squish)
               text += "SQUISHING AND ";
          if(blink)
               text += "BLINKING AND ";
          if(smile)
               text += "SMILING AND ";
          if(frown)
               text += "FROWNING AND ";
               
          if(text.substring(text.length() - 4, text.length()).equals("AND "))
               text = text.substring(0, text.length() - 5);
          else
               text += "DOING NOTHING SPECIAL";
               
          text += ".";
          
          switch(face)
          {               
               case BOX_NONE:  break;
               case BOX_SMILE: 
                    g2.drawArc((int)x, (int)(y - (vert / 5)), (int)(horiz), (int)(vert), 225, 90);
                    g2.drawLine((int)(x + horiz / 4), (int)(y + vert / 4), (int)(x + horiz / 4), (int)(y + vert / 2));
                    g2.drawLine((int)(x + 3 * horiz / 4), (int)(y + vert / 4), (int)(x + 3 * horiz / 4), (int)(y + vert / 2));                    
                    break;
               case BOX_FROWN: 
                    g2.drawArc((int)x, (int)(y + (3 * vert / 5)), (int)(horiz), (int)(vert), 45, 90);
                    g2.drawLine((int)(x + horiz / 4), (int)(y + vert / 4), (int)(x + horiz / 4), (int)(y + vert / 2));
                    g2.drawLine((int)(x + 3 * horiz / 4), (int)(y + vert / 4), (int)(x + 3 * horiz / 4), (int)(y + vert / 2));                    
                    break;
          }
          
          g2.drawString(
                    "[X: " + Double.toString(x + horiz / 2) + "]" 
                  + "[Y: " + Double.toString(y + vert / 2) + "]"
                  + "[Width: " + Double.toString(horiz) + "]"
                  + "[Height:" + Double.toString(vert) + "]", 0, 12);
          g2.drawString("Controls:", 0, 30);
          g2.drawString("(1) [Up] and [Down] modify overall size", 0, 45);
          g2.drawString("(2) [1] and [3] strecth the box, [2] and [4] squish the box", 0, 60);
          g2.drawString("(3) [S] makes the box happy, [F] makes the box sad (press key again to hide face)", 0, 75);
          g2.drawString("(4) [5] changes shape of the figure", 0, 90);
          
          
     }//end paint method
     
     
     /*
      * BELOW YOU WILL IMPLEMENT THE NECESSARY METHODS
      * TO HAVE THE BOX FOLLOW THE MOUSE AS IT MOVES ABOUT THE
      * SCREEN AND RESIZE WHEN CERTAIN KEYS ARE PRESSED.
      */
     
     public void keyPressed(KeyEvent e)      
     {
          x += horiz/2;
          y += vert/2;
          
          if(e.getKeyCode() == KeyEvent.VK_UP)
          {
               grow = true;
               horiz += 2;
               vert  += 2;
          }
          else if(e.getKeyCode() == KeyEvent.VK_DOWN)
          {
               shrink = true;
               horiz -= 2;
               vert  -= 2;
          }
          else if(e.getKeyCode() == KeyEvent.VK_SPACE) 
          {
               this.init();
          }
          else if(e.getKeyCode() == KeyEvent.VK_1)
          {
               stretch = true;
               horiz += 2;
          }
          else if(e.getKeyCode() == KeyEvent.VK_3)
          {
               stretch = true;
               vert  += 2;
          }
          else if(e.getKeyCode() == KeyEvent.VK_2)
          {
               squish = true;
               horiz -= 2;
          }
          else if(e.getKeyCode() == KeyEvent.VK_4)
          {
               squish = true;
               vert  -= 2;
          }
          else if(e.getKeyCode() == KeyEvent.VK_S)
          {
               if(face == BOX_SMILE) 
               {
                    smile = false;
                    face = BOX_NONE;
               }
               else
               {
                    smile = true;
                    frown = false;
                    face = BOX_SMILE;
               }
          }
          else if(e.getKeyCode() == KeyEvent.VK_F)
          {
               if(face == BOX_FROWN) 
               {
                    frown = false;
                    face = BOX_NONE;
               }
               else
               {
                    frown = true;
                    smile = false;
                    face = BOX_FROWN;
               }
          }
          else if(e.getKeyCode() == KeyEvent.VK_5)
          {
               if(isBox)
                    isBox = false;
               else
                    isBox = true;
          }
          
          x -= horiz/2;
          y -= vert/2;
          
          this.repaint();
     }
     public void keyReleased(KeyEvent e)     
     {
          grow = false;
          shrink = false;
          stretch = false;
          squish = false;
          blink = false;
          
          this.repaint();
     }
     public void keyTyped(KeyEvent e)        {}
     public void mouseExited(MouseEvent e)   {}
     public void mouseEntered(MouseEvent e)  {}     
     public void mouseClicked(MouseEvent e)  {}
     public void mousePressed(MouseEvent e)  {}
     public void mouseReleased(MouseEvent e) 
     {
          grow = false;
          shrink = false;
          stretch = false;
          squish = false;
          blink = false;
          
          this.repaint();
     }
     public void mouseMoved(MouseEvent e)    
     {
          x = e.getX() - horiz/2;
          y = e.getY() - vert/2;
          this.repaint();
     }
     public void mouseDragged(MouseEvent e)  
     {
          color = new Color(gen.nextInt(255), gen.nextInt(255), gen.nextInt(255));
          x = e.getX() - horiz/2;
          y = e.getY() - vert/2;
          blink = true;
          this.repaint();
     }
     
}//end MyFirstApplet class