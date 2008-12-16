/**
 * 
 * @author tzaki
 * @version Dec 10, 2008
 *
 */
public class Robot implements Moveable
{     
     private Position pos;   
     private int diretion;
     
     public static final int UP   = 0;
     public static final int RIGHT= 1;
     public static final int DOWN = 2;
     public static final int LEFT = 3;
     
     /**
      * 
      * @param row
      * @param col
      */
     public Robot(int row, int col)
     {
          pos = new Position(row, col);
     }
     
     /**
      * 
      * @return
      */
     public Position getPosition()
     {
          return pos;
     }
     
     /**
      * 
      * @param anObject
      * @return
      */
     public boolean move(Object anObject)
     {
          if(!anObject.getClass().getName().equals("Maze"))
               return false;
          else
               return true;
     }     
}
