/**
 A 3 x 3 tic-tac-toe board.
 */
public class TicTacToe
{
     private String[][] board;
     private static final int ROWS = 3;
     private static final int COLUMNS = 3;
     public static final String X = "§";
     public static final String O = "½";
     
     /**
      Constructs an empty board.
      */
     public TicTacToe()
     {
          board = new String[ROWS][COLUMNS];
          initializeBoard();
     }
     
     
     /*
      * This method resets the board to all blanks.
      */
     public void initializeBoard ()
     {
          for (int i = 0; i < ROWS; i++)
               for (int j = 0; j < COLUMNS; j++)
               board [i][j] = " ";
     } // end initializeBoard method
     
     
     /*
      * This method sets the board to print "Tic Tac Toe"
      */
     public void setWelcomeBoard ()
     {
          board [0][0] = "T";
          board [1][0] = "T";
          board [2][0] = "T";
          board [0][1] = "i";
          board [1][1] = "a";
          board [2][1] = "o";
          board [0][2] = "c";
          board [1][2] = "c";
          board [2][2] = "e";
     } //end setWelcomeBoard method
     
     
     /*
      * Sets the indicated piece onto the board.
      * 
      * @return returns false if the piece was not added
      * successfully.
      */
     public boolean setPiece (String piece, int row, int column)
     {
          //Check if the space is occupied
          if (!board [(row - 1)][(column - 1)].equals (" "))
               return false;
          
          board [(row - 1)][(column - 1)] = piece;
          return true;
     }//end setPiece method
     
     
     /* This method checks for 3 in a row of X's or O's.
      * 
      * @return X if X wins, O if O wins, 
      * "T" if no one wins and there is a tie,
      * or "T" is the board is not full yet.
      */
     public String checkBoard ()
     {
          boolean fullBoard = true;
          
          //Check if the board is full and nobody won.
          //Note: The board is not full in any space is " "
          for (int i = 0; i < ROWS; i++)
               for (int j = 0; j < COLUMNS; j++)
                   if (board [i][j].equals(" "))
                       fullBoard = false;
          
          
          // Next check all rows across.
          for (int i = 0; i < ROWS; i ++)
               if (board [i][0].equals(board [i][1]) &&
                   board[i][1].equals(board[i][2]) &&
                   !board[i][0].equals (" "))
               if (board [i][0].equals (X))
                    return X;
               else
                    return O;
          
          // Next check all columns down.
          for (int j = 0; j < COLUMNS; j ++)
               if (board [0][j].equals(board [1][j]) &&
                   board[1][j].equals(board[2][j]) &&
                   !board[0][j].equals (" "))
               if (board [0][j].equals(X))
               return X;
          else
               return O;
          
          
          // Now check diagonal, down-right.
          if (board [0][0].equals(board [1][1]) &&
              board[1][1].equals(board[2][2]) &&
                   !board[0][0].equals (" "))
               if (board [1][1].equals(X))
                    return X;
               else
                    return O;
          
          // Now check diagonal, down-left.
          if (board [0][2].equals(board [1][1]) &&
              board[1][1].equals(board[2][0]) &&
                   !board[0][2].equals (" "))
               if (board [1][1].equals(X))
                    return X;
               else
                    return O;
          
          
          //If fullBoard is still false,
          //   return "N" to keep playing.
          if (!fullBoard)
               return "N";
          
          //If we reach this line,
          //  no one has won so return "T"
          return "T";
          
     }// end checkBoard method
     
     
     /**
      Creates a string representation of the board, such as
      |x  o|
      |  x |
      |   o|
      @return the string representation
      */
     public String toString()
     {
          String boardOutput = "\n+-----+\n";
          for (int i = 0; i < ROWS; i++)
          {
               boardOutput += "|";
               for (int j = 0; j < COLUMNS; j++)
               {
                    boardOutput += board [i][j] + "|";
               }
               boardOutput += "\n+-----+\n";
          }
          boardOutput += "\n\n";
          
          return boardOutput;
     }//end toString method
     
     
     /*
      * This method returns the board (a 2-d array)
      * so that the player can see the row numbers.
      */
     public String getBoardOutputRows ()
     {
          String boardOutput = "\n      +-----+\n";
          for (int i = 0; i < ROWS; i++)
          {
               if (i == 1)
               {
                    boardOutput += "Rows ";
               }
               else
               {
                    boardOutput += "     ";
               }
               boardOutput += (i + 1) + "|";
               for (int j = 0; j < COLUMNS; j++)
               {
                    boardOutput += board [i][j] + "|";
               }
               boardOutput += "\n      +-----+\n";
          }
          return boardOutput;
          
     } // end getBoardOutputRows method
     
     
     /*
      * This method returns the board (a 2-d array)
      * so that the player can see the column numbers.
      */
     public String getBoardOutputColumns ()
     {
          String boardOutput = "\n      Columns\n       1 2 3\n";
          boardOutput += "      +-----+\n";
          for (int i = 0; i < ROWS; i++)
          {
               boardOutput += "      |";
               for (int j = 0; j < COLUMNS; j++)
               {
                    boardOutput += board [i][j] + "|";
               }
               boardOutput += "\n      +-----+\n";
          }
          
          return boardOutput;
     } // end getBoardOutputColumns method
     
}