public class CFBoard
{
     private String[][] values;
     private String     board;
     private int[]      level;

     public CFBoard()
     {
          values = new String[6][7];
          board  = new String();
          level  = new int[7];
          
          for(int i = 0; i < 7; i++)
               level[i] = 0;

          for (int i = 0; i < values.length; i++)
          {
               for (int j = 0; j < values[i].length; j++)
               {
                    values[i][j] = "_";
               }
          }

          for (int i = values.length - 1; i >= 0; i--)
          {
               for (int j = 0; j < values[i].length; j++)
               {
                    board += "|" + values[i][j];
               }

               board += "|\n";
          }
     }

     private void redraw()
     {
          board = new String();

          for (int i = values.length - 1; i >= 0; i--)
          {
               for (int j = 0; j < values[i].length; j++)
               {
                    board += "|" + values[i][j];
               }

               board += "|\n";
          }
     }

     public void placePiece(char p, int x, int y)
     {
          switch (p)
          {
               case 'x':
                    values[y - 1][x - 1] = "x";
                    break;
               case 'o':
                    values[y - 1][x - 1] = "o";
                    break;
               default:
                    break;
          }

          redraw();
     }
     
     public boolean placePieceColumn(char p, int c)
     {
          if (c > 0 && c < 8)
          {
               switch (p)
               {
                    case 'x':
                         values[level[c-1]][c - 1] = "x";
                         break;
                    case 'o':
                         values[level[c-1]][c - 1] = "o";
                         break;
                    default:
                         break;
               }
               
               level[c-1] = level[c-1] + 1;

               redraw();
               
               return true;
          }
          else
               return false;
          
     }

     public String toString()
     {
          return board;
     }
}