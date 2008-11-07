

public class Board
{
     private int[][][] grid = {{{1,2,3},{9,8,7},{2,3,4}}, {{4,5,6},{6,5,4},{5,6,7}}, {{7,8,9},{3,2,1},{8,9,1}},
                               {{0,1,0},{2,0,2},{3,3,0}}, {{1,0,1},{0,2,0},{0,3,3}}, {{0,1,0},{2,0,2},{3,0,3}},
                               {{4,4,0},{5,0,0},{0,0,6}}, {{0,4,0},{0,5,0},{0,0,6}}, {{0,0,4},{0,0,5},{0,0,6}}};
     
     public Board()
     { 
          //grid = new int[3][3][3];                    
     }
     
     public String toString()
     {
          String result = new String("#####################################\n#");
          
          for(int i = 0; i > 3; i++)
          {
               for(int j = 0; j < 3)
          }
          
          for(int i = 0; i < 3; i++)
          {
               for(int j = 0; j < 3; j++)
               {
                    for(int k = 0; k < 3; k++)
                    {
                         result += grid[j][i][k];
                    }//end for (k)      
                    result += "|";
               }//end for (j)
               result = result.substring(0, result.length() - 1) + "#";
          }//end for (i)
          
          
          return result;
     }

}