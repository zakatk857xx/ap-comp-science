/**
 * A 3 x 3 tic-tac-toe board
 */
public class TicTacToe
{
     private String[][] board;
     private static final int ROWS = 3;
     private static final int COLUMNS = 3;
     
     /**
      * Constructs an empty board
      */
     public TicTacToe()
     {
          board = new String[ROWS][COLUMNS];
          //Fill with spaces
          for (int i = 0; i < ROWS; i++)
               for (int j = 0; j < COLUMNS; j++)
          board[i][j] = " ";
     }//end constructor
     
     
     /**
      * Sets a field in the board.
      * The field must be unoccupied.
      * @param i the row index
      * @param j the column index
      * @param player the player ("x" or "o")
      */
     public boolean set (int i, int j, String player)
     {
          if (board[i][j].equals (" "))
               board[i][j] = player;
          else
               return false;
          return true;
     }//end set method
     
     
     /**
      * Creates a string representation of the board, such as
      * |X O|
      * | X |
      * |  O|
      * @return the string representation.
      */
     public String toString()
     {
          String r = "";
          
          //System.out.println (board);
          for (int i = 0; i < ROWS; i++)
          {
               r += "|";
               for (int j = 0; j < COLUMNS; j++)
                    r += board[i][j];
               r += "|\n";
          }//end outer for
          
          return r;
     }//end toString method
}//end TicTacToe class