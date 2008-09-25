import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.*;

public class Board extends JComponent
{     
     private String board;
     
     public Board(Player p1, Player p2)
     {          
          board = new String();
          
          for(int i = 0; i < 9; i++)
          {               
               board += "|";
               
               for(int j = 0; j < 9; j++)
               {
                    if(p1.getX() == j && p1.getY() == i)
                    {
                         board += "o|";
                    }
                    else if(p2.getX() == j && p2.getY() == i)
                    {
                         board += "x|";
                    }
                    else
                         board += "_|";
               }//end for    
               
               board += "\n";
               
          }//end for 
     }     
     
     public String reDraw(Player p1, Player p2)
     {
          board = new String();
          
          for(int i = 0; i < 9; i++)
          {               
               board += "|";
               
               for(int j = 0; j < 9; j++)
               {
                    if(p1.getX() == j && p1.getY() == i)
                    {
                         board += "o|";
                    }
                    else if(p2.getX() == j && p2.getY() == i)
                    {
                         board += "x|";
                    }
                    else
                         board += "_|";
               }//end for    
               
               board += "\n";
               
          }//end for 
          
          return new String(" _ _ _ _ _ _ _ _ _ \n" + board);
     }
     
     public String toString()
     {
          return new String(" _ _ _ _ _ _ _ _ _ \n" + board);
     }
}//Board class