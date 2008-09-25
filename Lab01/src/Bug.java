/**
 * Bug class
 * @author tzaki
 * @version Sep 19, 2008
 *
 */
public class Bug
{
     private int xPos, yPos, direction;
     public static final int NORTH = 0,
                             EAST  = 1,
                             SOUTH = 2,
                             WEST  = 3;                             
     
     /**
      * Creates a new general Bug at the origin facing north
      */
     public Bug()
     {
          xPos = 0;
          yPos = 0;
          direction = 0;
     }
     
     /**
      * Creates a new Bug with a specified initial
      *   position facing north
      * @param x the initial x-coordinate
      * @param y the initial y-coordinate
      */
     public Bug(int x, int y)
     {
          xPos = x;
          yPos = y;
          direction = NORTH;
     }
     
     /**
      * Creates a new Bug with a specified initial
      *   position and direction
      * @param x   the initial x-coordinate
      * @param y   the initial x-coordinate
      * @param dir the initial direction the bug is facing
      */
     public Bug(int x, int y, int dir)
     {
          xPos = x;
          yPos = y;
          direction = dir;
     }
     
     /**
      * Turns the Bug clockwise 90 degrees 
      */
     public void turn()
     {
          if(direction < 3)
               direction++;
          else
               direction = 0;
     }
     
     /**
      * Moves the Bug forward one unit in the direction of travel
      */
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
     
     /**
      * Checks the location of the Bug
      * @return the coordinate location of the Bug in (x, y) form
      */
     public String getPosition()
     {
          return new String("(" + xPos + ", " + yPos + ")");
     }
     
}
