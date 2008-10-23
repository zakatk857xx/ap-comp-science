/**
 * 
 * The Basic Structure for a Tic Tac Toe Board
 * 
 * @author tzaki
 * @version Oct 7, 2008
 * 
 */

import java.util.Scanner;

public class TicTacToe
{
     public static void main(String args[])
     {
          Scanner in = new Scanner(System.in);
          
          final int SIDE_LENGTH = 3;
          String boardText = new String();
          String[][] board = new String[SIDE_LENGTH][SIDE_LENGTH];
//                                      <num  rows> <num  columns>

          for (int row = 0; row < board.length; row++)
          {
               for (int column = 0; column < board[row].length; column++)
               {
                    board[row][column] = " ";
                    System.out.println("Entry for (" + row + ", " + column + "):");
                    board[row][column] = in.nextLine();
                    
               }// end for
               
          }// end for
          
          for (int row = 0; row < board.length; row++)
          {
               boardText += "+-+-+-+\n";
               for (int column = 0; column < board[row].length; column++)
               {
                    boardText += "|" + board[row][column];    
                    
               }// end for
               
               boardText += "|\n";
               if(row == board.length - 1)
                    boardText += "+-+-+-+\n";
               
          }// end for
          
          System.out.println(boardText);
          
     }// end main
}// end class





