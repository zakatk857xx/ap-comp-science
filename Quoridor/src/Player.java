/************************************************************************\
 * -----------------------------                                        *
 *  Introduction to Programming                                         *   
 * -----------------------------                                        *
 *          Name: Thomas Zaki                                           *
 * Last Modified: 05/12/08                                              *
 *         Title: Player.java                                           *
 *   Description: Player Object                                         *
 *                                                                      *
\************************************************************************/ 

import java.awt.*;
import java.awt.geom.*;

public class Player
{
     private int x, y, number;
     private int numWalls;
     private String name, marker;
     private Line2D.Double win;
     private Color color;
     
     public static final Line2D.Double UP    = new Line2D.Double(0, 0, 9, 0);
     public static final Line2D.Double DOWN  = new Line2D.Double(0, 9, 9, 9);
     public static final Line2D.Double DOWN_G  = new Line2D.Double(0, 8, 8, 8);
     public static final Line2D.Double LEFT  = new Line2D.Double(0, 0, 0, 9);
     public static final Line2D.Double RIGHT = new Line2D.Double(9, 0, 9, 9);
     public static final Line2D.Double RIGHT_G = new Line2D.Double(8, 0, 8, 8);
     
     public Player()
     {
          x = 0;
          y = 0;
          numWalls = 10;
          name = new String("Player 1");
     }
     
     public Player(int x_pos, int y_pos)
     {
          x = x_pos;
          y = y_pos;
          numWalls = 10;
          name = new String("Player 1");
     }
     
     public Player(int x_pos, int y_pos, int nb)
     {
          x = x_pos;
          y = y_pos;
          numWalls = 10;
          name = new String("Player " + Integer.toString(nb));
     }
     
     public Player(int x_pos, int y_pos, Line2D.Double l, String nm, String mrk, int n, int w, Color c)
     {
          x = x_pos;
          y = y_pos;
          numWalls = w;
          name = nm;
          number = n;
          marker = mrk;
          color = c;
          win = l;
     }
     
     public Player(Player p)
     {
          x = p.getX();
          y = p.getY();
          numWalls = p.getNumWalls();
          name = p.getName();
     }
     
     public boolean movePiece(String dir, Board b)
     {
          boolean wasMoved = true;
          boolean isBlocked = false;
          boolean isOccupied = false;
          
          Line2D.Double l = new Line2D.Double();
          
          if(dir.equalsIgnoreCase("UP"))
          {
               l.setLine(x + .5, y + .5, 
                         x + .5, y - .5);           
               
               for(int i = 0; i < b.getNumWalls(); i++)
               {           
                    //whenever this if statement appears, it is checking to see
                    //  if the potential path of movement for the player intersects a wall
                    if(l.ptSegDist(new Point2D.Double((b.getWall(i).getMidpoint().getX() +
                                                       b.getWall(i).getEndPt1().getX()) / 2, 
                                                      (b.getWall(i).getMidpoint().getY() +
                                                       b.getWall(i).getEndPt1().getY()) / 2)) == 0 ||
                       l.ptSegDist(new Point2D.Double((b.getWall(i).getMidpoint().getX() +
                                                       b.getWall(i).getEndPt2().getX()) / 2, 
                                                      (b.getWall(i).getMidpoint().getY() +
                                                       b.getWall(i).getEndPt2().getY()) / 2)) == 0)
                    {
                         wasMoved = false;
                         isBlocked = true;
                    }
               }
               for(int i = 0; i < b.getNumPlayers(); i++)
               {
                    if(b.getPlayer(i).getX() == x && b.getPlayer(i).getY() == (y - 1))
                    {
                         isOccupied = true;
                         wasMoved = false;
                    }
               }
               if(!isBlocked && !isOccupied)
               {
                    y--;
                    
                    if (y < 0)
                    {
                         y++;
                         wasMoved = false;
                    }
                    
               }
               else if(isOccupied)
               {
                    wasMoved = jump(dir, b);
               }
          }
          else if(dir.equalsIgnoreCase("DOWN"))
          {
               l.setLine(x + .5, y + .5, 
                         x + .5, y + 1.5);  
               
               for(int i = 0; i < b.getNumWalls(); i++)
               {           
                    if(l.ptSegDist(new Point2D.Double((b.getWall(i).getMidpoint().getX() +
                                                       b.getWall(i).getEndPt1().getX()) / 2, 
                                                      (b.getWall(i).getMidpoint().getY() +
                                                       b.getWall(i).getEndPt1().getY()) / 2)) == 0 ||
                       l.ptSegDist(new Point2D.Double((b.getWall(i).getMidpoint().getX() +
                                                       b.getWall(i).getEndPt2().getX()) / 2, 
                                                      (b.getWall(i).getMidpoint().getY() +
                                                       b.getWall(i).getEndPt2().getY()) / 2)) == 0)
                    {
                         wasMoved = false;
                         isBlocked = true;
                         //if (!wasMoved)
                         //System.out.println("Error A");
                    }
               }
               for(int i = 0; i < b.getNumPlayers(); i++)
               {
                    if(b.getPlayer(i).getX() == x && b.getPlayer(i).getY() == (y + 1))
                    {
                         isOccupied = true;
                         wasMoved = false;
                         //if (!wasMoved)
                         //System.out.println("Error B");
                    }
               }
               if(!isBlocked && !isOccupied)
               {
                    y++;
                    
                    if (y > 8)
                    {
                         y--;
                         wasMoved = false;
                    }
                    
               }    
               else if(isOccupied)
               {
                    wasMoved = jump(dir, b);
               }
          }
          else if(dir.equalsIgnoreCase("LEFT"))
          {
               l.setLine(x + .5, y + .5, 
                         x - .5, y + .5); 
               
               for(int i = 0; i < b.getNumWalls(); i++)
               {           
                    if(l.ptSegDist(new Point2D.Double((b.getWall(i).getMidpoint().getX() +
                                                       b.getWall(i).getEndPt1().getX()) / 2, 
                                                      (b.getWall(i).getMidpoint().getY() +
                                                       b.getWall(i).getEndPt1().getY()) / 2)) == 0 ||
                       l.ptSegDist(new Point2D.Double((b.getWall(i).getMidpoint().getX() +
                                                       b.getWall(i).getEndPt2().getX()) / 2, 
                                                      (b.getWall(i).getMidpoint().getY() +
                                                       b.getWall(i).getEndPt2().getY()) / 2)) == 0)
                    {
                         wasMoved = false;
                         isBlocked = true;
                    }
               }
               for(int i = 0; i < b.getNumPlayers(); i++)
               {
                    if(b.getPlayer(i).getX() == (x - 1) && b.getPlayer(i).getY() == y)
                    {
                         isOccupied = true;
                         wasMoved = false;
                    }
               }
               if(!isBlocked && !isOccupied)
               {
                    x--;
                    
                    if (x < 0)
                    {
                         x++;
                         wasMoved = false;
                    }
               }     
               else if(isOccupied)
               {
                    wasMoved = jump(dir, b);
               }
          }
          else if(dir.equalsIgnoreCase("RIGHT"))
          {
               l.setLine(x + .5, y + .5, 
                         x + 1.5, y + .5);  
               
               for(int i = 0; i < b.getNumWalls(); i++)
               {           
                    if(l.ptSegDist(new Point2D.Double((b.getWall(i).getMidpoint().getX() +
                                                       b.getWall(i).getEndPt1().getX()) / 2, 
                                                      (b.getWall(i).getMidpoint().getY() +
                                                       b.getWall(i).getEndPt1().getY()) / 2)) == 0 ||
                       l.ptSegDist(new Point2D.Double((b.getWall(i).getMidpoint().getX() +
                                                       b.getWall(i).getEndPt2().getX()) / 2, 
                                                      (b.getWall(i).getMidpoint().getY() +
                                                       b.getWall(i).getEndPt2().getY()) / 2)) == 0)
                    {
                         wasMoved = false;
                         isBlocked = true;
                    }
               }
               for(int i = 0; i < b.getNumPlayers(); i++)
               {
                    if(b.getPlayer(i).getX() == (x + 1) && b.getPlayer(i).getY() == y)
                    {
                         isOccupied = true;
                         wasMoved = false;
                    }
               }
               if(!isBlocked && !isOccupied)
               {
                    x++;              
                    
                    if (x > 8)
                    {
                         x--;                        
                         wasMoved = false;
                    } 
               }  
               else if(isOccupied)
               {
                    wasMoved = jump(dir, b);
               }
          }
          else
          {
               wasMoved = false;
          }
          
          
          //System.out.println("isBlocked: " + isBlocked +
          //    "\nisOccupied: " + isOccupied +
          //    "\nwasMoved: " + wasMoved);
          
          return wasMoved;
     }
     
     public boolean movePiece(String dir, BoardComponent b)
     {
          boolean wasMoved = true;
          boolean isBlocked = false;
          boolean isOccupied = false;
          
          Line2D.Double l = new Line2D.Double();
          
          if(dir.equalsIgnoreCase("UP"))
          {
               l.setLine(x + .5, y + .5, 
                         x + .5, y - .5);           
               
               for(int i = 0; i < b.getNumWalls(); i++)
               {           
                    //whenever this if statement appears, it is checking to see
                    //  if the potential path of movement for the player intersects a wall
                    if(l.ptSegDist(new Point2D.Double((b.getWall(i).getMidpoint().getX() +
                                                       b.getWall(i).getEndPt1().getX()) / 2, 
                                                      (b.getWall(i).getMidpoint().getY() +
                                                       b.getWall(i).getEndPt1().getY()) / 2)) == 0 ||
                       l.ptSegDist(new Point2D.Double((b.getWall(i).getMidpoint().getX() +
                                                       b.getWall(i).getEndPt2().getX()) / 2, 
                                                      (b.getWall(i).getMidpoint().getY() +
                                                       b.getWall(i).getEndPt2().getY()) / 2)) == 0)
                    {
                         wasMoved = false;
                         isBlocked = true;
                    }
               }
               for(int i = 0; i < b.getNumPlayers(); i++)
               {
                    if(b.getPlayer(i).getX() == x && b.getPlayer(i).getY() == (y - 1))
                    {
                         isOccupied = true;
                         wasMoved = false;
                    }
               }
               if(!isBlocked && !isOccupied)
               {
                    y--;
                    
                    if (y < 0)
                    {
                         y++;
                         wasMoved = false;
                    }
                    
               }
               else if(isOccupied)
               {
                    wasMoved = jump(dir, b);
               }
          }
          else if(dir.equalsIgnoreCase("DOWN"))
          {
               l.setLine(x + .5, y + .5, 
                         x + .5, y + 1.5);  
               
               for(int i = 0; i < b.getNumWalls(); i++)
               {           
                    if(l.ptSegDist(new Point2D.Double((b.getWall(i).getMidpoint().getX() +
                                                       b.getWall(i).getEndPt1().getX()) / 2, 
                                                      (b.getWall(i).getMidpoint().getY() +
                                                       b.getWall(i).getEndPt1().getY()) / 2)) == 0 ||
                       l.ptSegDist(new Point2D.Double((b.getWall(i).getMidpoint().getX() +
                                                       b.getWall(i).getEndPt2().getX()) / 2, 
                                                      (b.getWall(i).getMidpoint().getY() +
                                                       b.getWall(i).getEndPt2().getY()) / 2)) == 0)
                    {
                         wasMoved = false;
                         isBlocked = true;
                         //if (!wasMoved)
                         //System.out.println("Error A");
                    }
               }
               for(int i = 0; i < b.getNumPlayers(); i++)
               {
                    if(b.getPlayer(i).getX() == x && b.getPlayer(i).getY() == (y + 1))
                    {
                         isOccupied = true;
                         wasMoved = false;
                         //if (!wasMoved)
                         //System.out.println("Error B");
                    }
               }
               if(!isBlocked && !isOccupied)
               {
                    y++;
                    
                    if (y > 8)
                    {
                         y--;
                         wasMoved = false;
                    }
                    
               }    
               else if(isOccupied)
               {
                    wasMoved = jump(dir, b);
               }
          }
          else if(dir.equalsIgnoreCase("LEFT"))
          {
               l.setLine(x + .5, y + .5, 
                         x - .5, y + .5); 
               
               for(int i = 0; i < b.getNumWalls(); i++)
               {           
                    if(l.ptSegDist(new Point2D.Double((b.getWall(i).getMidpoint().getX() +
                                                       b.getWall(i).getEndPt1().getX()) / 2, 
                                                      (b.getWall(i).getMidpoint().getY() +
                                                       b.getWall(i).getEndPt1().getY()) / 2)) == 0 ||
                       l.ptSegDist(new Point2D.Double((b.getWall(i).getMidpoint().getX() +
                                                       b.getWall(i).getEndPt2().getX()) / 2, 
                                                      (b.getWall(i).getMidpoint().getY() +
                                                       b.getWall(i).getEndPt2().getY()) / 2)) == 0)
                    {
                         wasMoved = false;
                         isBlocked = true;
                    }
               }
               for(int i = 0; i < b.getNumPlayers(); i++)
               {
                    if(b.getPlayer(i).getX() == (x - 1) && b.getPlayer(i).getY() == y)
                    {
                         isOccupied = true;
                         wasMoved = false;
                    }
               }
               if(!isBlocked && !isOccupied)
               {
                    x--;
                    
                    if (x < 0)
                    {
                         x++;
                         wasMoved = false;
                    }
               }     
               else if(isOccupied)
               {
                    wasMoved = jump(dir, b);
               }
          }
          else if(dir.equalsIgnoreCase("RIGHT"))
          {
               l.setLine(x + .5, y + .5, 
                         x + 1.5, y + .5);  
               
               for(int i = 0; i < b.getNumWalls(); i++)
               {           
                    if(l.ptSegDist(new Point2D.Double((b.getWall(i).getMidpoint().getX() +
                                                       b.getWall(i).getEndPt1().getX()) / 2, 
                                                      (b.getWall(i).getMidpoint().getY() +
                                                       b.getWall(i).getEndPt1().getY()) / 2)) == 0 ||
                       l.ptSegDist(new Point2D.Double((b.getWall(i).getMidpoint().getX() +
                                                       b.getWall(i).getEndPt2().getX()) / 2, 
                                                      (b.getWall(i).getMidpoint().getY() +
                                                       b.getWall(i).getEndPt2().getY()) / 2)) == 0)
                    {
                         wasMoved = false;
                         isBlocked = true;
                    }
               }
               for(int i = 0; i < b.getNumPlayers(); i++)
               {
                    if(b.getPlayer(i).getX() == (x + 1) && b.getPlayer(i).getY() == y)
                    {
                         isOccupied = true;
                         wasMoved = false;
                    }
               }
               if(!isBlocked && !isOccupied)
               {
                    x++;              
                    
                    if (x > 8)
                    {
                         x--;                        
                         wasMoved = false;
                    } 
               }  
               else if(isOccupied)
               {
                    wasMoved = jump(dir, b);
               }
          }
          else
          {
               wasMoved = false;
          }
          
          
          //System.out.println("isBlocked: " + isBlocked +
          //    "\nisOccupied: " + isOccupied +
          //    "\nwasMoved: " + wasMoved);
          
          return wasMoved;
     }
     
     public boolean placeWall(Wall w, Board b)
     {
          boolean wasPlaced = true;
          
          //Wall is more than 2 spaces long
          if (Math.sqrt(Math.pow(w.getEndPt1().getX() - w.getEndPt2().getX(), 2) 
                             + Math.pow(w.getEndPt1().getY() - w.getEndPt2().getY(), 2) ) != 2)
          {
               wasPlaced = false;
          }
          //Wall extends over board (Left)
          else if(w.getEndPt1().getX() < 0 || w.getEndPt2().getX() < 0)
          {
               wasPlaced = false;
          }
          //Wall extends over board (Top)
          else if (w.getEndPt1().getY() < 0 || w.getEndPt2().getY() < 0)
          {
               wasPlaced = false;
          }
          //Wall extends over board (Right)
          else if(w.getEndPt1().getX() > 9 || w.getEndPt2().getX() > 9)
          {
               wasPlaced = false;
          }
          //Wall extends over board (Bottom)
          else if (w.getEndPt1().getY() > 9 || w.getEndPt2().getY() > 9)
          {
               wasPlaced = false;
          }
          //Wall endpoint #1 in corner
          else if (w.getEndPt1().getX() == 0 && w.getEndPt1().getY() == 0 
                        || w.getEndPt1().getX() == 0 && w.getEndPt1().getY() == 9 
                        || w.getEndPt1().getX() == 9 && w.getEndPt1().getY() == 0 
                        || w.getEndPt1().getX() == 9 && w.getEndPt1().getY() == 9)
          {
               wasPlaced = false;
          }
          //Wall endpoint #2 in corner
          else if (w.getEndPt2().getX() == 0 && w.getEndPt2().getY() == 0 
                        || w.getEndPt2().getX() == 0 && w.getEndPt2().getY() == 9 
                        || w.getEndPt2().getX() == 9 && w.getEndPt2().getY() == 0 
                        || w.getEndPt2().getX() == 9 && w.getEndPt2().getY() == 9)
          {
               wasPlaced = false;
          }
          //Wall is on board's edge
          else if (w.getEndPt1().getX() == 0 && w.getEndPt2().getX() == 0
                        || w.getEndPt1().getX() == 9 && w.getEndPt2().getX() == 9
                        || w.getEndPt1().getY() == 0 && w.getEndPt2().getY() == 0
                        || w.getEndPt1().getY() == 9 && w.getEndPt2().getY() == 9)
          {
               wasPlaced = false;
          }
          //Player has no walls left
          else if(numWalls == 0)
               wasPlaced = false;
          
          //Wall crosses existing wall
          for(int i = 0; i < b.getNumWalls(); i++)
          {
               if(w.getMidpoint().equals((b.getWall(i).getMidpoint())))
                    wasPlaced = false;
          }
          
          /*Wall overlaps existing wall 
           *  >uses a complicated-looking test that determines
           *   overlap by finding the midpoint between the endpoint 
           *   of the wall and the midpoint of the wall 
           *   (I call it the "quarter-way" point) and seeing if
           *   that intersects the "quarter-way" point of any of
           *   the existing walls
           *
           *   Example Below:   
           *
           *      <----+----|----+---->
           *           ^         ^
           *           |         |
           *      "quarter-way"  points
           * 
           *   Overlaping walls that are beeing checked for:
           * 
           *       ___one wall___
           *      |              |
           *      |              |
           *      <----+----<---->----+---->
           *                |              |
           *                |___one wall___|
           * 
           */
          for(int i = 0; i < b.getNumWalls(); i++)
          {           
               if((new Point2D.Double((w.getMidpoint().getX() +
                                       w.getEndPt1().getX()) / 2, 
                                      (w.getMidpoint().getY() +
                                       w.getEndPt1().getY()) / 2)).equals
                       (new Point2D.Double((b.getWall(i).getMidpoint().getX() +
                                            b.getWall(i).getEndPt1().getX()) / 2, 
                                           (b.getWall(i).getMidpoint().getY() +
                                            b.getWall(i).getEndPt1().getY()) / 2)) ||
                  (new Point2D.Double((w.getMidpoint().getX() +
                                       w.getEndPt1().getX()) / 2, 
                                      (w.getMidpoint().getY() +
                                       w.getEndPt1().getY()) / 2)).equals
                       (new Point2D.Double((b.getWall(i).getMidpoint().getX() +
                                            b.getWall(i).getEndPt2().getX()) / 2, 
                                           (b.getWall(i).getMidpoint().getY() +
                                            b.getWall(i).getEndPt2().getY()) / 2)) || 
                  (new Point2D.Double((w.getMidpoint().getX() +
                                       w.getEndPt2().getX()) / 2, 
                                      (w.getMidpoint().getY() +
                                       w.getEndPt2().getY()) / 2)).equals
                       (new Point2D.Double((b.getWall(i).getMidpoint().getX() +
                                            b.getWall(i).getEndPt1().getX()) / 2, 
                                           (b.getWall(i).getMidpoint().getY() +
                                            b.getWall(i).getEndPt1().getY()) / 2)) ||
                  (new Point2D.Double((w.getMidpoint().getX() +
                                       w.getEndPt2().getX()) / 2, 
                                      (w.getMidpoint().getY() +
                                       w.getEndPt2().getY()) / 2)).equals
                       (new Point2D.Double((b.getWall(i).getMidpoint().getX() +
                                            b.getWall(i).getEndPt2().getX()) / 2, 
                                           (b.getWall(i).getMidpoint().getY() +
                                            b.getWall(i).getEndPt2().getY()) / 2)))
               {
                    wasPlaced = false;
               }
          }
          
          if(wasPlaced)
          {
               b.addWall(w);
               numWalls--;
               //System.out.println("Wall Added");
          }
          
          return wasPlaced;
     }
     
     public boolean placeWall(Wall w, BoardComponent b)
     {
          boolean wasPlaced = true;
          
          //Wall is more than 2 spaces long
          if (Math.sqrt(Math.pow(w.getEndPt1().getX() - w.getEndPt2().getX(), 2) 
                             + Math.pow(w.getEndPt1().getY() - w.getEndPt2().getY(), 2) ) != 2)
          {
               wasPlaced = false;
          }
          //Wall extends over board (Left)
          else if(w.getEndPt1().getX() < 0 || w.getEndPt2().getX() < 0)
          {
               wasPlaced = false;
          }
          //Wall extends over board (Top)
          else if (w.getEndPt1().getY() < 0 || w.getEndPt2().getY() < 0)
          {
               wasPlaced = false;
          }
          //Wall extends over board (Right)
          else if(w.getEndPt1().getX() > 9 || w.getEndPt2().getX() > 9)
          {
               wasPlaced = false;
          }
          //Wall extends over board (Bottom)
          else if (w.getEndPt1().getY() > 9 || w.getEndPt2().getY() > 9)
          {
               wasPlaced = false;
          }
          //Wall endpoint #1 in corner
          else if (w.getEndPt1().getX() == 0 && w.getEndPt1().getY() == 0 
                        || w.getEndPt1().getX() == 0 && w.getEndPt1().getY() == 9 
                        || w.getEndPt1().getX() == 9 && w.getEndPt1().getY() == 0 
                        || w.getEndPt1().getX() == 9 && w.getEndPt1().getY() == 9)
          {
               wasPlaced = false;
          }
          //Wall endpoint #2 in corner
          else if (w.getEndPt2().getX() == 0 && w.getEndPt2().getY() == 0 
                        || w.getEndPt2().getX() == 0 && w.getEndPt2().getY() == 9 
                        || w.getEndPt2().getX() == 9 && w.getEndPt2().getY() == 0 
                        || w.getEndPt2().getX() == 9 && w.getEndPt2().getY() == 9)
          {
               wasPlaced = false;
          }
          //Wall is on board's edge
          else if (w.getEndPt1().getX() == 0 && w.getEndPt2().getX() == 0
                        || w.getEndPt1().getX() == 9 && w.getEndPt2().getX() == 9
                        || w.getEndPt1().getY() == 0 && w.getEndPt2().getY() == 0
                        || w.getEndPt1().getY() == 9 && w.getEndPt2().getY() == 9)
          {
               wasPlaced = false;
          }
          //Player has no walls left
          else if(numWalls == 0)
               wasPlaced = false;
          
          //Wall crosses existing wall
          for(int i = 0; i < b.getNumWalls(); i++)
          {
               if(w.getMidpoint().equals((b.getWall(i).getMidpoint())))
                    wasPlaced = false;
          }
          
          /*Wall overlaps existing wall 
           *  >uses a complicated-looking test that determines
           *   overlap by finding the midpoint between the endpoint 
           *   of the wall and the midpoint of the wall 
           *   (I call it the "quarter-way" point) and seeing if
           *   that intersects the "quarter-way" point of any of
           *   the existing walls
           *
           *   Example Below:   
           *
           *      <----+----|----+---->
           *           ^         ^
           *           |         |
           *      "quarter-way"  points
           * 
           *   Overlaping walls that are beeing checked for:
           * 
           *       ___one wall___
           *      |              |
           *      |              |
           *      <----+----<---->----+---->
           *                |              |
           *                |___one wall___|
           * 
           */
          for(int i = 0; i < b.getNumWalls(); i++)
          {           
               if((new Point2D.Double((w.getMidpoint().getX() +
                                       w.getEndPt1().getX()) / 2, 
                                      (w.getMidpoint().getY() +
                                       w.getEndPt1().getY()) / 2)).equals
                       (new Point2D.Double((b.getWall(i).getMidpoint().getX() +
                                            b.getWall(i).getEndPt1().getX()) / 2, 
                                           (b.getWall(i).getMidpoint().getY() +
                                            b.getWall(i).getEndPt1().getY()) / 2)) ||
                  (new Point2D.Double((w.getMidpoint().getX() +
                                       w.getEndPt1().getX()) / 2, 
                                      (w.getMidpoint().getY() +
                                       w.getEndPt1().getY()) / 2)).equals
                       (new Point2D.Double((b.getWall(i).getMidpoint().getX() +
                                            b.getWall(i).getEndPt2().getX()) / 2, 
                                           (b.getWall(i).getMidpoint().getY() +
                                            b.getWall(i).getEndPt2().getY()) / 2)) || 
                  (new Point2D.Double((w.getMidpoint().getX() +
                                       w.getEndPt2().getX()) / 2, 
                                      (w.getMidpoint().getY() +
                                       w.getEndPt2().getY()) / 2)).equals
                       (new Point2D.Double((b.getWall(i).getMidpoint().getX() +
                                            b.getWall(i).getEndPt1().getX()) / 2, 
                                           (b.getWall(i).getMidpoint().getY() +
                                            b.getWall(i).getEndPt1().getY()) / 2)) ||
                  (new Point2D.Double((w.getMidpoint().getX() +
                                       w.getEndPt2().getX()) / 2, 
                                      (w.getMidpoint().getY() +
                                       w.getEndPt2().getY()) / 2)).equals
                       (new Point2D.Double((b.getWall(i).getMidpoint().getX() +
                                            b.getWall(i).getEndPt2().getX()) / 2, 
                                           (b.getWall(i).getMidpoint().getY() +
                                            b.getWall(i).getEndPt2().getY()) / 2)))
               {
                    wasPlaced = false;
               }
          }
          
          if(wasPlaced)
          {
               b.addWall(w);
               numWalls--;
               //System.out.println("Wall Added");
          }
          
          return wasPlaced;
     }
     
     //this is called when there is a player impeding 
     public boolean jump(String dir, Board b)
     {
          boolean wasMoved = true;
          boolean isBlocked = false;
          boolean isOccupied = false;
          Line2D.Double l = new Line2D.Double();      
          
          if(dir.equalsIgnoreCase("UP"))
          {
               l.setLine(x + .5, y + .5, 
                         x + .5, y - 1.5);   
               
               y -= 2;
               
               for(int i = 0; i < b.getNumWalls(); i++)
               {           
                    if(l.ptSegDist(new Point2D.Double((b.getWall(i).getMidpoint().getX() +
                                                       b.getWall(i).getEndPt1().getX()) / 2, 
                                                      (b.getWall(i).getMidpoint().getY() +
                                                       b.getWall(i).getEndPt1().getY()) / 2)) == 0 ||
                       l.ptSegDist(new Point2D.Double((b.getWall(i).getMidpoint().getX() +
                                                       b.getWall(i).getEndPt2().getX()) / 2, 
                                                      (b.getWall(i).getMidpoint().getY() +
                                                       b.getWall(i).getEndPt2().getY()) / 2)) == 0)
                    {
                         wasMoved = false;
                         isBlocked = true;
                    }
               }
               for(int i = 0; i < b.getNumPlayers(); i++)
               {
                    if(b.getPlayer(i).getX() == x && b.getPlayer(i).getY() == y && !b.getPlayer(i).equals(this))
                    {
                         wasMoved = false;
                         isOccupied = true;
                    }
               }
               
               if(isBlocked || isOccupied)
                    y += 2;
               
          }
          else if(dir.equalsIgnoreCase("DOWN"))
          {
               l.setLine(x + .5, y + .5, 
                         x + .5, y + 2.5);     
               
               y += 2;
               
               for(int i = 0; i < b.getNumWalls(); i++)
               {           
                    if(l.ptSegDist(new Point2D.Double((b.getWall(i).getMidpoint().getX() +
                                                       b.getWall(i).getEndPt1().getX()) / 2, 
                                                      (b.getWall(i).getMidpoint().getY() +
                                                       b.getWall(i).getEndPt1().getY()) / 2)) == 0 ||
                       l.ptSegDist(new Point2D.Double((b.getWall(i).getMidpoint().getX() +
                                                       b.getWall(i).getEndPt2().getX()) / 2, 
                                                      (b.getWall(i).getMidpoint().getY() +
                                                       b.getWall(i).getEndPt2().getY()) / 2)) == 0)
                    {
                         wasMoved = false;
                         isBlocked = true;
                         //if (!wasMoved)
                         //System.out.println("Error C");
                    }
               }
               for(int i = 0; i < b.getNumPlayers(); i++)
               {
                    if(b.getPlayer(i).getX() == x && b.getPlayer(i).getY() == y && !b.getPlayer(i).equals(this))
                    {
                         wasMoved = false;
                         isOccupied = true;
                         //if (!wasMoved)
                         //System.out.println("Error D");
                    }
               }
               
               if(isBlocked || isOccupied)
                    y -= 2;
          }
          else if(dir.equalsIgnoreCase("LEFT"))
          {
               l.setLine(x + .5, y + .5, 
                         x - 1.5, y + .5);    
               
               x -= 2;
               
               for(int i = 0; i < b.getNumWalls(); i++)
               {           
                    if(l.ptSegDist(new Point2D.Double((b.getWall(i).getMidpoint().getX() +
                                                       b.getWall(i).getEndPt1().getX()) / 2, 
                                                      (b.getWall(i).getMidpoint().getY() +
                                                       b.getWall(i).getEndPt1().getY()) / 2)) == 0 ||
                       l.ptSegDist(new Point2D.Double((b.getWall(i).getMidpoint().getX() +
                                                       b.getWall(i).getEndPt2().getX()) / 2, 
                                                      (b.getWall(i).getMidpoint().getY() +
                                                       b.getWall(i).getEndPt2().getY()) / 2)) == 0)
                    {
                         wasMoved = false;
                         isBlocked = true;
                    }
               }
               for(int i = 0; i < b.getNumPlayers(); i++)
               {
                    if(b.getPlayer(i).getX() == x && b.getPlayer(i).getY() == y && !b.getPlayer(i).equals(this))
                    {
                         wasMoved = false;
                         isOccupied = true;
                    }
               }
               
               if(isBlocked || isOccupied)
                    x += 2;
          }
          else if(dir.equalsIgnoreCase("RIGHT"))
          {
               l.setLine(x + .5, y + .5, 
                         x + 2.5, y - .5);   
               
               x += 2;
               
               for(int i = 0; i < b.getNumWalls(); i++)
               {           
                    if(l.ptSegDist(new Point2D.Double((b.getWall(i).getMidpoint().getX() +
                                                       b.getWall(i).getEndPt1().getX()) / 2, 
                                                      (b.getWall(i).getMidpoint().getY() +
                                                       b.getWall(i).getEndPt1().getY()) / 2)) == 0 ||
                       l.ptSegDist(new Point2D.Double((b.getWall(i).getMidpoint().getX() +
                                                       b.getWall(i).getEndPt2().getX()) / 2, 
                                                      (b.getWall(i).getMidpoint().getY() +
                                                       b.getWall(i).getEndPt2().getY()) / 2)) == 0)
                    {
                         wasMoved = false;
                         isBlocked = true;
                    }
               }
               for(int i = 0; i < b.getNumPlayers(); i++)
               {
                    if(b.getPlayer(i).getX() == x && b.getPlayer(i).getY() == y && !b.getPlayer(i).equals(this))
                    {
                         wasMoved = false;
                         isOccupied = true;
                    }
               }
               
               if(isBlocked || isOccupied)
                    x -= 2;
          }
          else
          {
               wasMoved = false;
          }
          
          return wasMoved;
     }
     
     //this is called when there is a player impeding the current players path
     public boolean jump(String dir, BoardComponent b)
     {
          boolean wasMoved = true;
          boolean isBlocked = false;
          boolean isOccupied = false;
          Line2D.Double l = new Line2D.Double();      
          
          if(dir.equalsIgnoreCase("UP"))
          {
               l.setLine(x + .5, y + .5, 
                         x + .5, y - 1.5);   
               
               y -= 2;
               
               for(int i = 0; i < b.getNumWalls(); i++)
               {           
                    if(l.ptSegDist(new Point2D.Double((b.getWall(i).getMidpoint().getX() +
                                                       b.getWall(i).getEndPt1().getX()) / 2, 
                                                      (b.getWall(i).getMidpoint().getY() +
                                                       b.getWall(i).getEndPt1().getY()) / 2)) == 0 ||
                       l.ptSegDist(new Point2D.Double((b.getWall(i).getMidpoint().getX() +
                                                       b.getWall(i).getEndPt2().getX()) / 2, 
                                                      (b.getWall(i).getMidpoint().getY() +
                                                       b.getWall(i).getEndPt2().getY()) / 2)) == 0)
                    {
                         wasMoved = false;
                         isBlocked = true;
                    }
               }
               for(int i = 0; i < b.getNumPlayers(); i++)
               {
                    if(b.getPlayer(i).getX() == x && b.getPlayer(i).getY() == y && !b.getPlayer(i).equals(this))
                    {
                         wasMoved = false;
                         isOccupied = true;
                    }
               }
               
               if(isBlocked || isOccupied)
               {
                    y += 2;
               }
               else if (y < 0)
               {
                   y += 2;                        
                   wasMoved = false;
               } 
               
          }
          else if(dir.equalsIgnoreCase("DOWN"))
          {
               l.setLine(x + .5, y + .5, 
                         x + .5, y + 2.5);     
               
               y += 2;
               
               for(int i = 0; i < b.getNumWalls(); i++)
               {           
                    if(l.ptSegDist(new Point2D.Double((b.getWall(i).getMidpoint().getX() +
                                                       b.getWall(i).getEndPt1().getX()) / 2, 
                                                      (b.getWall(i).getMidpoint().getY() +
                                                       b.getWall(i).getEndPt1().getY()) / 2)) == 0 ||
                       l.ptSegDist(new Point2D.Double((b.getWall(i).getMidpoint().getX() +
                                                       b.getWall(i).getEndPt2().getX()) / 2, 
                                                      (b.getWall(i).getMidpoint().getY() +
                                                       b.getWall(i).getEndPt2().getY()) / 2)) == 0)
                    {
                         wasMoved = false;
                         isBlocked = true;
                         //if (!wasMoved)
                         //System.out.println("Error C");
                    }
               }
               for(int i = 0; i < b.getNumPlayers(); i++)
               {
                    if(b.getPlayer(i).getX() == x && b.getPlayer(i).getY() == y && !b.getPlayer(i).equals(this))
                    {
                         wasMoved = false;
                         isOccupied = true;
                         //if (!wasMoved)
                         //System.out.println("Error D");
                    }
               }
               
               if(isBlocked || isOccupied)
               {
                    y -= 2;
               }
               else if (y > 8)
               {
                   y -= 2;                        
                   wasMoved = false;
               } 
          }
          else if(dir.equalsIgnoreCase("LEFT"))
          {
               l.setLine(x + .5, y + .5, 
                         x - 1.5, y + .5);    
               
               x -= 2;
               
               for(int i = 0; i < b.getNumWalls(); i++)
               {           
                    if(l.ptSegDist(new Point2D.Double((b.getWall(i).getMidpoint().getX() +
                                                       b.getWall(i).getEndPt1().getX()) / 2, 
                                                      (b.getWall(i).getMidpoint().getY() +
                                                       b.getWall(i).getEndPt1().getY()) / 2)) == 0 ||
                       l.ptSegDist(new Point2D.Double((b.getWall(i).getMidpoint().getX() +
                                                       b.getWall(i).getEndPt2().getX()) / 2, 
                                                      (b.getWall(i).getMidpoint().getY() +
                                                       b.getWall(i).getEndPt2().getY()) / 2)) == 0)
                    {
                         wasMoved = false;
                         isBlocked = true;
                    }
               }
               for(int i = 0; i < b.getNumPlayers(); i++)
               {
                    if(b.getPlayer(i).getX() == x && b.getPlayer(i).getY() == y && !b.getPlayer(i).equals(this))
                    {
                         wasMoved = false;
                         isOccupied = true;
                    }
               }
               
               if(isBlocked || isOccupied)
               {
                    x += 2;
               }
               else if (x < 0)
               {
                   x += 2;                        
                   wasMoved = false;
               } 
          }
          else if(dir.equalsIgnoreCase("RIGHT"))
          {
               l.setLine(x + .5, y + .5, 
                         x + 2.5, y - .5);   
               
               x += 2;
               
               for(int i = 0; i < b.getNumWalls(); i++)
               {           
                    if(l.ptSegDist(new Point2D.Double((b.getWall(i).getMidpoint().getX() +
                                                       b.getWall(i).getEndPt1().getX()) / 2, 
                                                      (b.getWall(i).getMidpoint().getY() +
                                                       b.getWall(i).getEndPt1().getY()) / 2)) == 0 ||
                       l.ptSegDist(new Point2D.Double((b.getWall(i).getMidpoint().getX() +
                                                       b.getWall(i).getEndPt2().getX()) / 2, 
                                                      (b.getWall(i).getMidpoint().getY() +
                                                       b.getWall(i).getEndPt2().getY()) / 2)) == 0)
                    {
                         wasMoved = false;
                         isBlocked = true;
                    }
               }
               for(int i = 0; i < b.getNumPlayers(); i++)
               {
                    if(b.getPlayer(i).getX() == x && b.getPlayer(i).getY() == y && !b.getPlayer(i).equals(this))
                    {
                         wasMoved = false;
                         isOccupied = true;
                    }
               }
               
               if(isBlocked || isOccupied)
               {
                    x -= 2;                    
               }
               else if (x > 8)
               {
                   x -= 2;                        
                   wasMoved = false;
               } 
          }
          else
          {
               wasMoved = false;
          }
          
          return wasMoved;
     }
     
     public void setNumWalls(int n)
     {
          numWalls = n;
     }
     
     public void addWall()
     {
          numWalls++;
     }
     
     public int getNumWalls()
     {
          return numWalls;
     }
     
     public String getName()
     {
          return name;
     }
     
     public void setName(String n)
     {
          name = n;
     }
     
     public void setMarker(String mrk)
     {
          marker = mrk;
     }
     
     public String getMarker()
     {
          return marker;
     }
     
     public void setNumber(int n)
     {
          number = n;
     }
     
     public int getNumber()
     {
          return number;
     }
     
     public void setColor(Color c)
     {
          color = c;
     }
     
     public Color getColor()
     {
          return color;
     }
     
     public int getX()
     {
          return x;
     }
     
     public int getY()
     {
          return y;
     }
     
     public void setX(int newX)
     {
          x = newX;
     }
     
     public void setY(int newY)
     {
          y = newY;
     }
     
     public void setPos(int newX, int newY)
     {
          x = newX;
          y = newY;
     }
     
     public boolean checkWin()
     {
    	  //System.out.println("winChecking...");
    	  //System.out.println(win.ptLineDist(new Point2D.Double(x, y)));
    	 
          boolean isWin = false;
          
          if(win.ptLineDist(new Point2D.Double(x, y)) == 0)
               isWin = true;
          
          return isWin;
     }
     
     public String toString()
     {
          return new String("[Name: " + name + "; Location: (x=" + x + ",y=" + y +"); Walls Left: " + numWalls + "]");
     }
     
}

