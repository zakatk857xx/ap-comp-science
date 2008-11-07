public class Grid
{
     private boolean [][] currentGrid;
     private boolean [][] tempGrid;
     
     public Grid()
     {
          currentGrid = new boolean [10][10];
          tempGrid = new boolean [10][10];
     }
     
     public Grid(int n)
     {
          currentGrid = new boolean [n][n];
          tempGrid = new boolean [n][n];
          
          for(int i = 0; i < this.getSize(); i++)
          {
               for(int j = 0; j < this.getSize(); j++)
               {
                    currentGrid[i][j] = false;
                    tempGrid[i][j] = false;
               }
          }          
     }
     
     public Grid(int x, int y)
     {
          currentGrid = new boolean [y][x];
          tempGrid = new boolean [y][x];
          
          for(int i = 0; i < currentGrid.length; i++)
          {
               for(int j = 0; j < currentGrid[i].length; j++)
               {
                    currentGrid[i][j] = false;
                    tempGrid[i][j] = false;
               }
          }          
     }
               
     public void click(int row, int column)
     {          
          changeState(row, column);
          
          //o.k. to check north
          if(row != 0)
               changeState(row - 1, column);
          //o.k. to check south
          if (row != (currentGrid.length - 1))
               changeState(row + 1, column);
          //o.k. to check west
          if(column != 0)
               changeState(row, column - 1);
          //o.k. to check east
          if (column != (currentGrid[0].length - 1))
               changeState(row, column + 1);
     }
     
     public int getSize()
     {
          return currentGrid.length;
     }
     
     public boolean isOccupied(int row, int column)
     {
          return currentGrid[row][column];
     }
     
     public void changeState(int column, int row)
     {
          if(currentGrid[row][column])
               currentGrid[row][column] = false;
          else if (!currentGrid[row][column])
               currentGrid[row][column] = true;
     }
     
     public void reset(int n)
     {
          currentGrid = new boolean [n][n];
          tempGrid = new boolean [n][n];
          
          for(int i = 0; i < currentGrid.length; i++)
          {
               for(int j = 0; j < currentGrid[i].length; j++)
               {
                    currentGrid[i][j] = true;
                    tempGrid[i][j] = true;
               }
          } 
          
     }
     
     public void redefine(int n)
     {
          int limitR = currentGrid.length;
          int limitC = currentGrid[0].length;
          
          for(int row = 0; row < currentGrid.length; row++)
          {
               for(int column = 0; column < currentGrid[row].length; column++)
               {
                    tempGrid[row][column] = currentGrid[row][column];
               }
          }
          
          currentGrid = new boolean [n][n];
          
          for(int row = 0; row < n && row < limitR; row++)
          {
               for(int column = 0; column < n && column < limitC; column++)
               {
                    currentGrid[row][column] = tempGrid[row][column];
               }
          }
          
          tempGrid = new boolean [n][n];
          
          for(int row = 0; row < currentGrid.length; row++)
          {
               for(int column = 0; column < currentGrid[row].length; column++)
               {
                    tempGrid[row][column] = currentGrid[row][column];
               }
          }
     }
     
     public boolean checkWin()
     {
          boolean fullBoard = true;
          
          for(int row = 0; row < currentGrid.length; row++)
          {
               for(int column = 0; column < currentGrid[row].length; column++)
               {
                    if(!this.isOccupied(row, column))
                         fullBoard = false;
               }
          }
          
          return fullBoard;          
     }
}