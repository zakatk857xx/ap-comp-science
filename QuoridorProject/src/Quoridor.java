import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.*;

public class Quoridor
{
     public static void main (String [] beans)
     {
          Scanner in = new Scanner(System.in);
          String input = new String();
          
          boolean isGameOver = false;
          
          
          Player p1 = new Player(4, 8, 1, "Player 1");
          Player p2 = new Player(4, 0, 2, "Player 2");
          Player currentPlayer = new Player();
          
          Board Qboard = new Board(p1, p2);        
          
          System.out.println(" WECOME TO QUORIDOR");
          
          System.out.println(Qboard);
                    
          while(!isGameOver)
          {
               currentPlayer = p1;
               System.out.println("It's " + currentPlayer + "'s turn!\n");
               System.out.println("ENTER:[|+|UP|+|DOWN|+|LEFT|+|RIGHT|+|]");
               p1.movePiece(in.nextLine());
               Qboard.reDraw(p1, p2);              
               
          }
          
     }//end main
}//end Quoridor class