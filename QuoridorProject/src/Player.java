public class Player
{
     public int x, y, n;
     public String name;
     
     public Player()
     {
          x = 0;
          y = 0;
          n = 1;
          name = new String("Player " + Integer.toString(n));
     }
     
     public Player(int x_pos, int y_pos)
     {
          x = x_pos;
          y = y_pos;
          n = 1;
          name = new String("Player " + Integer.toString(n));
     }
     
     public Player(int x_pos, int y_pos, int nb)
     {
          x = x_pos;
          y = y_pos;
          n = nb;
          name = new String("Player " + Integer.toString(n));
     }
     
     public Player(int x_pos, int y_pos, int nb, String nm)
     {
          x = x_pos;
          y = y_pos;
          n = nb;
          name = nm;
     }
     
     public boolean movePiece(String dir)
     {
          boolean wasMoved = true;
          
          if(dir.equalsIgnoreCase("UP"))
          {
               y--;
               if (y < 0)
               {
                    y++;
                    wasMoved = false;
               }
          }
          else if(dir.equalsIgnoreCase("DOWN"))
          {
               y++;
               if (y > 9)
               {
                    y--;
                    wasMoved = false;
               }
          }
          else if(dir.equalsIgnoreCase("LEFT"))
          {
               x--;
               if (x > 9)
               {
                    x++;
                    wasMoved = false;
               }
          }
          else if(dir.equalsIgnoreCase("RIGHT"))
          {
               x++;
               if (x > 9)
               {
                    x--;
                    wasMoved = false;
               }
          }
          else
               wasMoved = false;
          
          return wasMoved;
     }
     
     public int getX()
     {
          return x;
     }
     
     public int getY()
     {
          return y;
     }
     
     public void setX(int newX)
     {
          x = newX;
     }
     
     public void setY(int newY)
     {
          y = newY;
     }
     
     
     public String toString()
     {
          return name;
     }
     
}








