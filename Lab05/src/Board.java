/**
 * This <code>Board</code> object can be used to simulate a SuDoKu board.  
 *   It uses a 3x3 grid of 3x3 grids (<code>int[3][3][3][3]</code>) to keep track  
 *   of the values. The <code>Board</code> class contains 3 preset grids of
 *   varying difficulty for quick implementation, the ability to add your own 
 *   user-defined grid, and can return reasons (as a <code>String</code>) for 
 *   invalid input into the <code>Board</code>.
 * 
 * @author Thomas Zaki
 * @version 2.0
 */
public class Board
{
     private int[][][][] grid;
     private String err;
     private int row, rowIndexA, rowIndexB, col, colIndexA, colIndexB, box, boxIndexA, boxIndexB;
     
     /**
      * Auto-fills the <code>Board</code> with an easy setup
      */
     public static final int EASY   = 0;
     /**
      * Auto-fills the <code>Board</code> with an intermediate setup
      */
     public static final int MEDIUM = 1;
     /**
      * Auto-fills the <code>Board</code> with a hard setup
      */
     public static final int HARD   = 2;     
     
     /**
      * Creates a new <code>Board</code> with all values set to 0
      */
     public Board()
     {
          //presets values to 0
          grid = new int[3][3][3][3];    
          err = new String();
     }//end Constructor
     
     /**
      * Creates a new <code>Board</code> with a specified difficulty level
      * 
      * @param difficulty the difficulty level of the <code>Board</code>
      */
     public Board(int difficulty)
     {   
          err = new String();
          
          /*
            {{{{1,0,1}, {0,1,0}, {1,0,1}}, {{0,2,0}, {2,0,2}, {0,2,0}}, {{3,0,3}, {0,3,0}, {3,0,3}}},
             {{{0,4,0}, {4,0,4}, {0,4,0}}, {{5,0,5}, {0,5,0}, {5,0,5}}, {{0,6,0}, {6,0,6}, {0,6,0}}},
             {{{7,0,7}, {0,0,0}, {7,0,7}}, {{0,8,0}, {8,0,8}, {0,8,0}}, {{9,0,9}, {0,9,0}, {9,0,9}}}};
                    
             will produce:
             
             +#######+#######+#######+              1stRow   2ndRow   3rdRow
             # 1   1 #   2   # 3   3 #   note that {{1,0,1}, {0,1,0}, {1,0,1}}
             #   1   # 2   2 #   3   #     makes:
             # 1   1 #   2   # 3   3 #            +#######+
             +#######+#######+#######+            # 1   1 #
             #   4   # 5   5 #   6   #            #   1   #
             # 4   4 #   5   # 6   6 #            # 1   1 #
             #   4   # 5   5 #   6   #            +#######+
             +#######+#######+#######+   so each one represents a 3x3 grid and each 
             # 7   7 #   8   # 9   9 #     internal array is a row in that grid
             #   7   # 8   8 #   9   #
             # 7   7 #   8   # 9   9 #
             +#######+#######+#######+
             
           */
          
          switch (difficulty)
          {            
               case 0:       
                    int[][][][] g1 = {{{{0,1,9}, {0,0,0}, {8,2,0}}, {{0,6,0}, {0,0,0}, {9,7,4}}, {{5,4,0}, {0,0,0}, {0,3,6}}},
                                      {{{0,0,1}, {0,0,0}, {0,0,2}}, {{5,0,3}, {0,0,0}, {7,0,1}}, {{8,0,0}, {0,0,0}, {6,0,0}}},
                                      {{{7,5,0}, {0,0,0}, {0,8,3}}, {{1,3,8}, {0,0,0}, {0,4,0}}, {{0,9,2}, {0,0,0}, {7,1,0}}}};
                    grid = (int[][][][]) g1.clone();                    
                    break;
               case 1:  
                    int[][][][] g2 = {{{{0,0,0}, {5,0,0}, {0,4,0}}, {{2,7,9}, {0,0,0}, {0,3,0}}, {{0,0,0}, {0,0,7}, {0,2,0}}},
                                      {{{4,0,0}, {0,6,8}, {7,0,0}}, {{0,5,0}, {0,0,0}, {0,6,0}}, {{0,0,8}, {3,5,0}, {0,0,9}}},
                                      {{{0,5,0}, {3,0,0}, {0,0,0}}, {{0,4,0}, {0,0,0}, {8,1,5}}, {{0,9,0}, {0,0,2}, {0,0,0}}}};
                    grid = (int[][][][]) g2.clone();   
                    break;
               case 2:  
                    int[][][][] g3 = {{{{0,0,0}, {0,2,0}, {3,9,0}}, {{0,1,0}, {6,0,0}, {0,0,7}}, {{4,0,0}, {0,0,5}, {0,0,1}}},
                                      {{{5,0,0}, {0,6,0}, {0,3,0}}, {{0,6,0}, {0,0,0}, {0,8,0}}, {{0,3,0}, {0,8,0}, {0,0,7}}},
                                      {{{9,0,0}, {4,0,0}, {0,0,2}}, {{2,0,0}, {0,0,5}, {0,3,0}}, {{0,5,6}, {0,2,0}, {0,0,0}}}};
                    grid = (int[][][][]) g3.clone();   
                    break;
               default: break;
          }//end switch difficulty
     }//end constructor
     
     public Board(int[][][][] g)
     {
          err = new String();
          grid = (int[][][][]) g.clone(); 
     }//end constructor
     
     /**
      * Returns whether the <code>Board</code> is full or not
      * 
      * @return <code>true</code> if the <code>Board</code> is full, otherwise <code>false</code>
      */
     public boolean fullBoard()
     {
          boolean result = true;
          
          for(int i = 0; i < 3; i++)
               for(int j = 0; j < 3; j++)
                    for(int k = 0; k < 3; k++)
                         for(int l = 0; l < 3; l++)
                              if(grid[i][k][j][l] == 0) //looks for zero's
                                   result = false;
          return result;
     }
     
     /**
      * Sets the values used to identify the current row, column, and box (or sub-grid)
      * 
      * @param r the row
      * @param c the column
      * @return <code>false</code> if an error occurs, otherwise <code>true</code>
      */
     private boolean setRowAndColAndBox(int r, int c)
     {
          boolean result = true;
          
          //directly assigns row and column values
          row = r;
          col = c;
          
          if(row < 1 || row > 9)
          {
               result = false; 
               err += "\n(*) Row '" + row + "' does not exist.\n";
          }//end if
          if(col < 1 || col > 9)
          {
               result = false; 
               err += "\n(*) Column '" + col + "' does not exist.\n";
          }//end if
          
          rowIndexA = ((row - 1) / 3); //Row of major grid
          rowIndexB = ((row - 1) % 3); //Row of sub-grids of major row
          colIndexA = ((col - 1) / 3); //Column of major grid
          colIndexB = ((col - 1) % 3); //Column of sub-grids of major column
          boxIndexA = rowIndexA; //Row of the box of major grid
          boxIndexB = colIndexA; //Column of the box of major grid

          box = 3 * boxIndexA + (boxIndexB + 1);
          
          return result;
     }//end setRowAndColAndBox
     
     /**
      * Checks a row for potential repeats
      * 
      * @param value the value to find repeats of
      * @return <code>false</code> if a repeat exists, otherwise <code>true</code>
      */
     private boolean checkRow(int value)
     {
          boolean result = true;
          
          //checks the values in a specified row 
          //  (a row is defined by row indexes, or making i and k constants)
          for(int j = 0; j < 3 && result; j++)
               for(int l = 0; l < 3 && result; l++)
                    if(grid[rowIndexA][j][rowIndexB][l] == value)
                         result = false;
          
          if(!result)
               err += "\n(*) The value entered already exists in row " + row + ".  ";
          
          return result;
     }//end checkRow
     
     /**
      * Checks a column for potential repeats
      * 
      * @param value the value to find repeats of
      * @return <code>false</code> if a repeat exists, otherwise <code>true</code>
      */
     private boolean checkCol(int value)
     {
          boolean result = true;
          
          //checks the values in a specified column 
          //  (a column is defined by column indexes, or making j and l constants)
          for(int i = 0; i < 3 && result; i++)
               for(int k = 0; k < 3 && result; k++)
                    if(grid[i][colIndexA][k][colIndexB] == value)
                         result = false;
          
          if(!result)
               err += "\n(*) The value entered already exists in column " + col + ".  ";
          
          return result;
     }//end checkCol 
     
     /**
      * Checks a box for potential repeats
      * 
      * @param value the value to find repeats of
      * @return <code>false</code> if a repeat exists, otherwise <code>true</code>
      */
     private boolean checkBox(int value)
     {
          boolean result = true;
          
          //checks the values in a specified box 
          //  (a box is defined by box indexes, or making i and k constants)
          for(int j = 0; j < 3 && result; j++)
               for(int l = 0; l < 3 && result; l++)
                    if(grid[boxIndexA][boxIndexB][j][l] == value)
                         result = false;
          
          if(!result)
               err += "\n(*) The value entered already exists in box " + box + ".  ";
          
          return result;
     }//end checkBox
     
     /**
      * Checks if the current space is already occupied
      * 
      * @return <code>false</code> if the space is occupied, otherwise <code>true</code>
      */
     private boolean isOccupied()
     {
          boolean result = false;

          //checks for values other than zero in every space
          if(grid[rowIndexA][colIndexA][rowIndexB][colIndexB] != 0)
               result = true;

          if(result)
               err += "\n(*) The space selected (" + row + ", " + col + ") is already occupied.  ";
          
          return result;
     }//end isOccupied
     
     /**
      * Checks whether the placement of a value in a specified position is valid or not
      * 
      * @param value the value being checked
      * @param row the new current row to be checked
      * @param col the new current column to be checked
      * @return <code>false</code> if an error occurs, otherwise <code>true</code>
      */
     private boolean checkPlacement(int value, int row, int col)
     {
          boolean result = true;
          
          //tests for valid input for value 
          //  (row and column are tested in respective check methods)
          if(value < 1 || value > 9)
          {
               result = false;
               err += "\n(*) The value '" + value + "' is out of range [1-9].  ";
          }//end if
          
          if(result)
          {
               //sets current row, column, and box
               setRowAndColAndBox(row, col);

               //performs tests (individually, so that all errors are printed)
               if(isOccupied())
                    result = false;
               if(!checkRow(value))
                    result = false;
               if(!checkCol(value))
                    result = false;
               if(!checkBox(value))
                    result = false;
          }//end if
          
          return result;
     }//end checkPlacement
     
     /**
      * Adds a number to a specified location on the <code>Board</code>
      * 
      * @param value the value to be added
      * @param row the row to add the value in
      * @param col the column to add the value in
      * @return <code>false</code> if an error occurs, otherwise <code>true</code>
      */
     public boolean addNum(int value, int row, int col)
     {
          //resets err
          err = "";
          //checks placement of the value
          boolean result = checkPlacement(value, row, col);
                    
          //if the placement is valid, place it there
          if(result)
               grid[rowIndexA][colIndexA][rowIndexB][colIndexB] = value;
               
          return result;
     }//end addNum
     
     /**
      * Gets the current error <code>String</code>
      * 
      * @return the error <code>String</code> generated by calling <code>addNum()</code>
      */
     public String getErr()
     {
          return err;
     }//end getErr
     
     /**
      * Returns the <code>Board</code> as a <code>String</code>
      */
     public String toString()
     {
          String result = new String("\n+#######+#######+#######+\n");
          
          for(int i = 0; i < 3; i++)
          {
               result += "# ";
               for(int j = 0; j < 3; j++)
               {
                    for(int k = 0; k < 3; k++)
                    {
                         for(int l = 0; l < 3; l++)
                         {
                              if(grid[i][k][j][l] != 0)
                                   result += grid[i][k][j][l] + " ";
                              //The trick to understanding the above statement is to
                              //  just not think about it and accept the fact that 
                              //  it works...
                              else
                                   result += "  ";
                         }//end for 'l'
                         
                         result += "# ";
                    }//end for 'k'
                    
                    result += "\n# ";
               }//end for 'j'
               
               //cuts off the extra '#'
               result = result.substring(0, result.length() - 2) + "+#######+#######+#######+\n";
          }//end for 'i'
          
          return result;
     }//end toString
     
}//end Board class