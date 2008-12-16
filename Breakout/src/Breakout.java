import java.applet.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Breakout extends Applet implements Runnable, KeyListener, MouseListener, MouseMotionListener
{
     private AnimatedShape      paddle;
     private AnimatedShape      ball;

     ArrayList                  list          = new ArrayList<AnimatedShape>();

     private Thread             breakoutAnimator;

     private int                delay         = 15;
     private int                rows          = 2;
     private static int         columns       = 7;

     private boolean            hit;
     private boolean            gameOver      = false;
     private boolean            gameWon       = false;
     private boolean            onMenu        = true;
     private boolean            paused        = false;

     private Random             gen           = new Random();
     public static final int    BALL_DIAMETER = 15;
     public static final int    PADDLE_WIDTH  = 60;
     public static final int    PADDLE_HEIGHT = 10;
     public static final int    BRICK_WIDTH   = 60;
     public static final int    BRICK_HEIGHT  = 20;
     public static final int    BUTTON_WIDTH  = 80;
     public static final int    BUTTON_HEIGHT = 40;

     private Rectangle2D.Double easy;
     private Rectangle2D.Double medium;
     private Rectangle2D.Double hard;

     private int                lives;

     public void init()
     {
          easy = new Rectangle2D.Double(this.getWidth() / 2 - BUTTON_WIDTH / 2, this.getHeight() / 2 - BUTTON_HEIGHT, BUTTON_WIDTH, BUTTON_HEIGHT);
          medium = new Rectangle2D.Double(this.getWidth() / 2 - BUTTON_WIDTH / 2, this.getHeight() / 2, BUTTON_WIDTH, BUTTON_HEIGHT);
          hard = new Rectangle2D.Double(this.getWidth() / 2 - BUTTON_WIDTH / 2, this.getHeight() / 2 + BUTTON_HEIGHT, BUTTON_WIDTH, BUTTON_HEIGHT);

          paddle = new AnimatedShape(new Rectangle2D.Double(2 * PADDLE_WIDTH, this.getHeight() / 2, PADDLE_WIDTH, PADDLE_HEIGHT),
                    this.getWidth() / 2, this.getHeight() - PADDLE_HEIGHT - 5, PADDLE_WIDTH, PADDLE_HEIGHT, 1, 0, 1, 5, Color.BLACK, Color.GREEN);

          ball = new AnimatedShape(new Ellipse2D.Double(this.getHeight() / 2 - BALL_DIAMETER / 2, this.getHeight() / 2 - BALL_DIAMETER / 2,
                    BALL_DIAMETER, BALL_DIAMETER), this.getWidth() / 2 - BALL_DIAMETER / 2, this.getHeight() / 2 - BALL_DIAMETER / 2, BALL_DIAMETER,
                    BALL_DIAMETER, 1, 1, 3, 2, Color.BLACK, Color.RED);

          list.clear();
          for (int i = 0; i < columns; i++)
          {
               for (int j = 0; j < rows; j++)
               {
                    AnimatedShape temp = new AnimatedShape(new Rectangle2D.Double(2 * BRICK_WIDTH, this.getHeight() / 2, BRICK_WIDTH, BRICK_HEIGHT),
                              ((i * 3) + i * BRICK_WIDTH) + 30, ((j * 3) + j * BRICK_HEIGHT) + 6, BRICK_WIDTH, BRICK_HEIGHT, 0, 1, 1, 5, Color.BLACK,
                              Color.GREEN);
                    list.add(temp);
               }
          }

          this.setFocusable(true);
          this.addKeyListener(this);
          this.addMouseMotionListener(this);
          this.addMouseListener(this);

          lives = 3;

          hit = false;
          // onMenu = true;
          gameOver = false;
          gameWon = false;

     }

     public void start()
     {
          breakoutAnimator = new Thread(this);
          breakoutAnimator.start();
     }

     // This method is called with the Applet is closed.
     public void stop()
     {
          breakoutAnimator = null;
     }

     // The paint method.
     public void paint(Graphics g)
     {
          Graphics2D g2 = (Graphics2D) g;

          // recover Graphics2D
          if (onMenu)
          {
               g2.setColor(Color.GREEN);
               g2.fill(easy);
               g2.setColor(Color.ORANGE);
               g2.fill(medium);
               g2.setColor(Color.RED);
               g2.fill(hard);

               g2.setColor(Color.BLACK);
               g2.setFont(new Font("Helvetica", Font.BOLD, 20));
               g2.drawString("EASY", (int) easy.getX(), (int) easy.getY() + BUTTON_HEIGHT);
               g2.drawString("MEDIUM", (int) medium.getX(), (int) medium.getY() + BUTTON_HEIGHT);
               g2.drawString("HARD", (int) hard.getX(), (int) hard.getY() + BUTTON_HEIGHT);

          }

          else if (!gameOver)
          {
               g2.setColor(Color.BLACK);

               g2.setColor(paddle.getFillColor());
               g2.fill(paddle.getShape());

               for (int i = 0; i < list.size(); i++)
               {
                    g2.setColor(new Color(gen.nextInt(256), gen.nextInt(256), gen.nextInt(256)));
                    g2.fill(((AnimatedShape) list.get(i)).getShape());
               }

               g2.setColor(ball.getFillColor());
               g2.fill(ball.getShape());

               g2.setColor(Color.BLACK);
               g2.setFont(new Font("Helvetica", Font.BOLD, 20));
               g2.drawString(Integer.toString(lives), 10, 20);

               if (paused)
               {
                    g2.setColor(new Color(100, 100, 100, 100));
                    g2.fillRect(0, 0, this.getWidth(), this.getHeight());
                    g2.setColor(new Color(0, 0, 0, 100));
                    g2.fillRoundRect(this.getWidth() / 2 - 75, this.getHeight() / 2 - 110, 150, 200, 15, 15);
                    
                    g2.setColor(new Color(0, 0, 0, 100));
                    g2.drawRoundRect(this.getWidth() / 2 - 75, this.getHeight() / 2 - 110, 150, 200, 15, 15);
                    g2.drawRoundRect(this.getWidth() / 2 - 74, this.getHeight() / 2 - 109, 148, 198, 15, 15);
                    
                    g2.setColor(new Color(0, 0, 0, 100));
                    g2.fillRoundRect(this.getWidth() / 2 - 70, this.getHeight() / 2 - 25, 140, 50, 15, 15);
                    g2.setColor(new Color(255, 255, 255, 200));
                    g2.drawRoundRect(this.getWidth() / 2 - 70, this.getHeight() / 2 - 25, 140, 50, 15, 15);
                    g2.setColor(new Color(0, 0, 0, 100));
                    g2.fillRoundRect(this.getWidth() / 2 - 70, this.getHeight() / 2 - 80, 140, 50, 15, 15);
                    g2.setColor(new Color(255, 255, 255, 200));
                    g2.drawRoundRect(this.getWidth() / 2 - 70, this.getHeight() / 2 - 80, 140, 50, 15, 15);
                    g2.setColor(new Color(0, 0, 0, 100));
                    g2.fillRoundRect(this.getWidth() / 2 - 70, this.getHeight() / 2 + 30, 140, 50, 15, 15);
                    g2.setColor(new Color(255, 255, 255, 200));
                    g2.drawRoundRect(this.getWidth() / 2 - 70, this.getHeight() / 2 + 30, 140, 50, 15, 15);
                    

                    g2.setFont(new Font("Helvetica", Font.BOLD, 20));
                    g2.drawString("Main Menu", this.getWidth() / 2 - 53, this.getHeight() / 2 - 88);
                    g2.drawString("EASY", this.getWidth() / 2 - 27, this.getHeight() / 2 - 50);
                    g2.drawString("MEDIUM", this.getWidth() / 2 - 39, this.getHeight() / 2 + 7);
                    g2.drawString("HARD", this.getWidth() / 2 - 27, this.getHeight() / 2 + 63);
                    
               }
          }

          else
          {
               if (gameWon)
               {
                    g2.setColor(Color.BLACK);
                    g2.setFont(new Font("Helvetica", Font.BOLD, 20));
                    g2.drawString("Congratulations", this.getWidth() / 2 - 60, this.getWidth() / 2 - 5);
               }
               else
               {
                    g2.setColor(Color.BLACK);
                    g2.setFont(new Font("Helvetica", Font.BOLD, 20));
                    g2.drawString("Game Over", this.getWidth() / 2 - 50, this.getWidth() / 2 - 5);
               }
          }

     }

     // After the start method has been called, the run method is called.
     public void run()
     {
          // Check that the current thread is still our pongAnimator.
          while (Thread.currentThread() == breakoutAnimator)
          {
               do
               {
                    if (!paused)
                    {
                         System.out.println(paused);
                         /******************************************************
                          * CODE TO BE ADDED BY YOU
                          *****************************************************/
                         // System.out.println("##########################");
                         // System.out.println(paddle.toString() + "\n" +
                         // ball.toString());
                         // if ball is within the y of the paddle
                         // System.out.println(lives + ", " + list.size());
                         if (ball.getBottomLeftPoint().getY() >= paddle.getTopLeftPoint().getY()
                                   && ball.getBottomLeftPoint().getY() <= paddle.getBottomLeftPoint().getY())
                         {
                              if (ball.getBottomRightPoint().getX() > paddle.getTopLeftPoint().getX()
                                        && ball.getBottomLeftPoint().getX() < paddle.getTopRightPoint().getX())
                              {
                                   ball.setY((int) paddle.getTopRightPoint().getY() - BALL_DIAMETER + 1);
                                   ball.changeVerticalDirection();
                              }// end if
                         }// end if

                         // if ball hits sides of screen
                         if (ball.getTopLeftPoint().getX() <= 0 || ball.getTopRightPoint().getX() >= this.getWidth())
                              ball.changeHorizontalDirection();

                         // if ball hits top of screen
                         if (ball.getTopLeftPoint().getY() <= 0)
                              ball.changeVerticalDirection();

                         // if the ball reaches the bottom
                         if (ball.getTopLeftPoint().getY() > this.getHeight())
                         {
                              lives--;
                              if (lives == 0)
                                   gameOver = true;
                              ball.setX(this.getWidth() / 2 - BALL_DIAMETER / 2);
                              ball.setY(this.getHeight() / 2 - BALL_DIAMETER / 2);
                         }

                         for (int i = 0; i < list.size(); i++)
                         {
                              hit = false;
                              if (((AnimatedShape) list.get(i)).getShape().contains(ball.getLeftSide())
                                        || ((AnimatedShape) list.get(i)).getShape().contains(ball.getRightSide()))
                              {
                                   ball.changeHorizontalDirection();
                                   hit = true;
                              }
                              if (((AnimatedShape) list.get(i)).getShape().contains(ball.getTopSide())
                                        || ((AnimatedShape) list.get(i)).getShape().contains(ball.getBottomSide()))
                              {
                                   ball.changeVerticalDirection();
                                   hit = true;
                              }

                              if (hit)
                              {
                                   list.remove(i);
                                   hit = false;
                              }
                         }

                         // test to see if game is won
                         if (list.size() == 0)
                         {
                              gameWon = true;
                              gameOver = true;
                         }

                         ball.moveShape();

                         repaint();

                         // Have the Thread sleep for 1 second at a time.
                         try
                         {
                              Thread.sleep(delay);
                         }
                         catch (InterruptedException e)
                         {
                              break;
                         }
                    }

               }
               while (!onMenu);
          }
     }

     // The following methods control the keyboard input.
     public void keyPressed(KeyEvent e)
     {
          if (e.getKeyCode() == KeyEvent.VK_SPACE)
          {
               onMenu = true;
               init();
          }

          if (e.getKeyCode() == KeyEvent.VK_UP)
          {
               if (delay > 0)
                    delay--;
          }

          if (e.getKeyCode() == KeyEvent.VK_DOWN)
          {
               delay++;
          }

          if (e.getKeyCode() == KeyEvent.VK_P)
          {
               if (paused)
               {
                    paused = false;
               }
               else
               {
                    paused = true;
                    repaint();
               }
          }
          if (e.getKeyCode() == KeyEvent.VK_R)
          {
               repaint();
          }
     }

     public void keyReleased(KeyEvent e)
     {}

     public void keyTyped(KeyEvent e)
     {}

     public void mouseMoved(MouseEvent e)
     {
          if (!paused)
          {
               int mouseX = e.getX() - PADDLE_WIDTH / 2;
               paddle.setX(mouseX);
               paddle.moveShape();
               repaint();
          }
     }

     public void mouseDragged(MouseEvent e)
     {
          Point2D.Double mouse = new Point2D.Double(e.getX(), e.getY());

          for (int i = 0; i < list.size(); i++)
          {
               hit = false;
               if (((AnimatedShape) list.get(i)).getShape().contains(mouse))
               {
                    list.remove(i);
               }
          }
     }

     public void mousePressed(MouseEvent e)
     {}

     public void mouseClicked(MouseEvent e)
     {
          Point2D.Double mouse = new Point2D.Double(e.getX(), e.getY());

          if (onMenu)
          {
               if (easy.contains(mouse))
               {
                    delay = 15;
                    rows = 2;
                    onMenu = false;
               }
               else if (medium.contains(mouse))
               {
                    delay = 10;
                    rows = 5;
                    onMenu = false;
               }
               else if (hard.contains(mouse))
               {
                    delay = 5;
                    rows = 10;
                    onMenu = false;
               }
               init();
          }
          if(paused)
          {
               if(new RoundRectangle2D.Double(this.getWidth() / 2 - 70, this.getHeight() / 2 - 25, 140, 50, 15, 15).contains(mouse))
               {
                    delay = 10;
                    rows = 5;
                    paused = false;
               }
               else if(new RoundRectangle2D.Double(this.getWidth() / 2 - 70, this.getHeight() / 2 - 80, 140, 50, 15, 15).contains(mouse))
               {
                    delay = 15;
                    rows = 2;
                    paused = false;
               }
               else if(new RoundRectangle2D.Double(this.getWidth() / 2 - 70, this.getHeight() / 2 + 30, 140, 50, 15, 15).contains(mouse))
               {
                    delay = 5;
                    rows = 10;
                    paused = false;
               }
               repaint();
               init();
          }
     }

     public void mouseReleased(MouseEvent e)
     {}

     public void mouseEntered(MouseEvent e)
     {}

     public void mouseExited(MouseEvent e)
     {}

}
