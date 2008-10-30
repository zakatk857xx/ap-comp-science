import java.util.Scanner;

/**
 * This program tests the <code>TicTacToe</code> class by prompting
 * the user to set positions on the board and printing out the
 * result
 */
public class TicTacToeTester
{
     public static void main (String[] args)
     {
          Scanner in = new Scanner (System.in);
          
          String player = "x";
          
          TicTacToe game = new TicTacToe ();
          
          boolean done = false, occupied = false;
          
          while (!done)
          {
               System.out.println (game/*.toString()*/);
               System.out.print ("Row for " + player + 
                                 " (-1 to exit): ");
               int row = in.nextInt ();
               if (row == -1) done = true;
               else
               {
                    System.out.print ("Column for " + player + 
                                      ": ");
                    int column = in.nextInt ();
                    
                    occupied = false;
                    
                    if (!game.set (row, column, player))
                         occupied = true;
                    
                    if (!occupied)
                    {
                         if (player.equals ("x"))
                              player = "o";
                         else
                              player = "x";
                    }//end if
               }//end else
          }//end while
          
     }//end main
}//end class