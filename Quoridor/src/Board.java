/************************************************************************\
 * -----------------------------                                        *
 *  Introduction to Programming                                         *   
 * -----------------------------                                        *
 *          Name: Thomas Zaki                                           *
 * Last Modified: 05/12/08                                              *
 *         Title: Board.java                                            *
 *   Description: Board Object                                          *
 *                                                                      *
\************************************************************************/ 

import javax.swing.*;
import java.awt.geom.*;
import java.util.*;

public class Board extends JComponent
{     
     private String board;
     private String divider;
     private ArrayList<Wall> walls;
     private ArrayList<Player> players;
     
     public Board(ArrayList<Player> p)
     {  
          //initializes the ArrayList of Players and Walls
          walls = new ArrayList<Wall>();
          players = new ArrayList<Player>();
          
          //begins the string with a header that takes care of some of the top of the board
          board = new String(" 0 1 2 3 4 5 6 7 8 9\n" + 
                             "0+-+-+-+-+-+-+-+-+-+\n");
          
          //nested for loop to draw board 
          //  (uses other inner for loops to cycle
          //  through players or walls where necessary)
          for(int i = 0; i < p.size(); i++)
          {
               players.add(p.get(i));
          }
          
          for(int i = 0; i < 9; i++)
          {               
               board += " |";
               
               for(int j = 0; j < 9; j++)
               {
                    boolean isOccupied = false;
                    
                    //checks to see if space is occupied by a player
                    for(int k = 0; k < players.size(); k++)
                    {                  
                         if(players.get(k).getX() == j && players.get(k).getY() == i)
                         {
                              isOccupied = true;
                              board += players.get(k).getMarker() + "|";
                              break;
                         }
                    }
                    if(!isOccupied)
                         board += " |";
                    
                    isOccupied = false;
                    
               }//end for    
               
               board += "\n" + (i + 1) + "+-+-+-+-+-+-+-+-+-+\n";
               
          }//end for 
          
     }     
     
     public String reDraw()//Player p1, Player p2)
     {
          //initializes the ArrayList of Players and Walls
          board = new String(" 0 1 2 3 4 5 6 7 8 9\n" + 
                             "0+-+-+-+-+-+-+-+-+-+\n");
          divider = new String();
          
          //booleans to keep track of useful properties
          boolean isOccupied = false;
          boolean isWall = false;
          
          //nested for loop to draw board 
          //  (uses other inner for loops to cycle
          //  through players or walls where necessary)
          for(int i = 0; i < 9; i++)
          {               
               board += " |";
               divider = "+";
               
               //this inner loop edits the row that contains the players
               for(int j = 0; j < 9; j++)
               {
                    //player cycle
                    for(int k = 0; k < players.size(); k++)
                    {
                         if(players.get(k).getX() == j && players.get(k).getY() == i)
                         {
                              board += players.get(k).getMarker();
                              isOccupied = true;
                              break;
                         }
                    }
                    if(!isOccupied)
                    {
                         board += " ";
                    }
                    
                    //wall cycle
                    for(int k = 0; k < walls.size(); k++)
                    {
                         if(walls.get(k).ptSegDist(j + 1, i + .5) == 0)
                         {
                              board += "#";
                              isWall = true;
                              break;
                         }
                    }
                    if(!isWall)
                    {
                         board += "|";
                    }
                    
                    isOccupied = false;
                    isWall = false;
               }
               
               //this second inner loop edits the row that 
               //  divides each player containing row (I call
               //  it the "divider")
               for(double j = 0; j < 9; j++)
               {
                    boolean isSideWall = false;
                    
                    for(int k = 0; k < walls.size(); k++)
                    {
                         if(walls.get(k).ptSegDist(j + .5, i + 1) == 0)
                         {
                              divider += "#";
                              isSideWall = true;
                              break;
                         }                  
                    }
                    if(!isSideWall)
                    {
                         divider += "-";
                    }
                    
                    isSideWall = false;
                    
                    for(int k = 0; k < walls.size(); k++)
                    {
                         //old debugging tests....
                         //System.out.println(walls.get(k).getMidpoint());
                         //System.out.println(new Point2D.Double(j + 1, i + 1));
                         
                         if(walls.get(k).getMidpoint().equals(new Point2D.Double(j + 1, i + 1)))
                         {
                              divider += "#";
                              isSideWall = true;
                              break;
                         }
                    }
                    if(!isSideWall)
                    {
                         divider += "+";
                    }
               }
               
               board += "\n" + (i + 1) + divider + "\n"; //adds the divider to the board, begins a new row.
          }
          
          return board;
     }
     
     //GET AND SET METHODS
     
     public void addWall(Wall w)
     {
          walls.add(w);
     }
     
     public void addWall(int i, Wall w)
     {
          walls.add(i, w);
     }
     
     public Wall getWall(int i)
     {
          return walls.get(i);
     }
     
     public int getNumWalls()
     {
          return walls.size();
     }
     
     public Player getPlayer(int i)
     {
          return players.get(i); 
     }     
     
     public int getNumPlayers()
     {
          return players.size();
     }
     
     public String getWalls()
     {
          String w = new String();
          
          for(int i = 0; i < walls.size(); i++)
               w += walls.get(i) + "; ";
          
          if(w.equals(null))
               w = "<null>";
          
          return w;
     }
     
     
     public String toString()
     {
          return new String(board);
     }
}//Board class

