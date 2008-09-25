public class Bug
{
     private int xPos, yPos, direction;
     public static final int NORTH = 0,
                             EAST  = 1,
                             SOUTH = 2,
                             WEST  = 3;                             
     
     public Bug()
     {
          xPos = 0;
          yPos = 0;
          direction = 0;
     }
     
     public Bug(int x, int y)
     {
          xPos = x;
          yPos = y;
          direction = NORTH;
     }
     
     public Bug(int x, int y, int d)
     {
          xPos = x;
          yPos = y;
          direction = d;
     }
     
     public void turn()
     {
          if(direction < 3)
               direction++;
          else
               direction = 0;
     }
     
     public void move()
     {
          switch(direction)
          {
               case NORTH:
                    yPos++;
                    break;
               case SOUTH:
                    yPos--;
                    break;
               case EAST:
                    xPos++;
                    break;
               case WEST:
                    xPos--;
                    break;                 
          }
     }
     
     public String getPosition()
     {
          return new String("(" + xPos + ", " + yPos + ")");
     }
     
}
