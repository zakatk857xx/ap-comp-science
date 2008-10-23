/**
 * 
 * @author Thomas Zaki
 * @version 10/11/08
 */

package gameElements;

public class Grid
{
     private boolean [][] currentGrid;
     private boolean [][] tempGrid;
     
     private final int CURRENT = 1;
     private final int TEMP = 2;
     
     
     /**
      *
      * Creates a default 10 x 10 grid
      *
      */
     public Grid()
     {
          currentGrid = new boolean [10][10];
          tempGrid    = new boolean [10][10];
     }
     
     /**
      * 
      * Creates a user-defined grid (n x n)
      * 
      * @param n the length of each side of the grid
      */
     public Grid(int n)
     {
          currentGrid = new boolean [n][n];
          tempGrid    = new boolean [n][n];
          
          for(int i = 0; i < this.getSize(); i++)
          {
               for(int j = 0; j < this.getSize(); j++)
               {
                    currentGrid[i][j] = false;
                    tempGrid[i][j]    = false;
               }
          }          
     }
     
     public void nextGeneration()
     {
          for (int row = 0; row < this.getSize(); row++)
          {
               for (int column = 0; column < this.getSize(); column++)
               {
                    switch(this.getNumNeighbors(CURRENT, row, column))
                    {
                         case 3:
                              tempGrid[row][column] = true;
                              break;
                         case 2:
                              if(currentGrid[row][column])
                                   tempGrid[row][column] = true;
                              break;
                         default:
                              tempGrid[row][column] = false;   
                    }
               }
          }
          
          for (int row = 0; row < this.getSize(); row++)
               for (int column = 0; column < this.getSize(); column++)
                    currentGrid[row][column] = tempGrid[row][column];
     }
     
     private int getNumNeighbors(int grid, int row, int column)
     {
          int numNeighbors = 0;
          
          //o.k. to check north
          if(row != 0)
               if(this.isOccupied(grid, row - 1, column))
                    numNeighbors++;
          //o.k. to check south
          if (row != (currentGrid.length - 1))
               if(this.isOccupied(grid, row + 1, column))
                    numNeighbors++;
          //o.k. to check west
          if(column != 0)
               if(this.isOccupied(grid, row, column - 1))
                    numNeighbors++;
          //o.k. to check east
          if (column != (currentGrid.length - 1))
               if(this.isOccupied(grid, row, column + 1))
                    numNeighbors++;
          //o.k. to check north west
          if(row != 0 && column != 0)
               if(this.isOccupied(grid, row - 1, column - 1))
                    numNeighbors++;
          //o.k. to check north east
          if(row != 0 && column != (currentGrid.length - 1))
               if(this.isOccupied(grid, row - 1, column + 1))
                    numNeighbors++;
          //o.k. to check south west
          if (row != currentGrid.length - 1 && column != 0)
               if(this.isOccupied(grid, row + 1, column - 1))
                    numNeighbors++;
          //o.k. to check south east
          if (row != currentGrid.length - 1 && column != (currentGrid.length - 1))
               if(this.isOccupied(grid, row + 1, column + 1))
                    numNeighbors++;
          
          return numNeighbors;
     }
     
     
     /**
      * 
      * Creates a string representing the grid
      * 
      * @return a string representing the grid
      */
     public String getTextGrid()
     {
          String board = new String();
          
          for(int i = 0; i < this.getSize(); i++)
          {
               for(int j = 0; j < this.getSize(); j++)
               {
                    if(this.isOccupied(this.CURRENT, i, j))
                         board += "#";
                    else
                         board += ".";
               }
               
               board += "\n";
          }
          
          return board;
     }
     
     
     /**
      * 
      * Returns the length of a side of the grid
      * 
      * @return
      */
     public int getSize()
     {
          return currentGrid.length;
     }
     
     /**
      * 
      * checks if a cell is occupied
      * 
      * @param row
      * @param column
      * @return the state of the cell
      */
     public boolean isOccupied(int row, int column)
     {
          return currentGrid[row][column];
     }
     
     /**
      * 
      * checks if a cell is occupied in a specified grid
      * 
      * @param grid (current - 1 or temporary - 2)
      * @param row
      * @param column
      * @return the state of the cell
      */
     private boolean isOccupied(int grid, int row, int column)
     {
          switch(grid)
          {
               case 1: return currentGrid[row][column];
               case 2: return tempGrid[row][column];
               default: return false;
          }
     }
     
     public void changeState(int column, int row)
     {
          if(currentGrid[row][column])
               currentGrid[row][column] = false;
          else
               currentGrid[row][column] = true;
     }
     
     public void redefine(int n)
     {
          currentGrid = new boolean [n][n];
          tempGrid = new boolean [n][n];
     }
}