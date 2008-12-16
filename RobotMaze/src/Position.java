/*
 * The Position class stores a row coordinate and column coordinate
 * pertaining to the position in a 2-d array.
 * 
 * @author Mr. Dietzler
 */
import java.util.*;

public class Position
{
   private int row, col;
   
   /**
    * This default constructor sets the initial position to (0,0).
    */
   public Position ()
   {
      row = 0;
      col = 0;
   }//end default constructor
   
   
   /**
    * This constructor sets the initial position to (r,c).
    * 
    * @param r the initial row.
    * @param c the initial column.
    */
   public Position (int r, int c)
   {
      row = r;
      col = c;
   }//end constructor
   
   
   /**
    * This method returns the row.
    *
    * @return the row the Position represents.
    */
   public int getRow ()
   {
      return row;
   }//end getRow method
   
   
   /**
    * This method changes the row.
    *
    * @param r the new row.
    */
   public void setRow (int r)
   {
      row = r;
   }//end setRow method
   
   /**
    * This method modifies one Position object with another
    * 
    * @param k the new Position object
    */
   public void setPosition (Position k)
   {
     row = k.getRow();
     col = k.getColumn();
   }//end setPosition method
   
   /**
    * This method returns the column.
    *
    * @return the column the Position represents.
    */
   public int getColumn ()
   {
      return col;
   }//end getCol method
   
   
   /**
    * This method changes the column.
    *
    * @param c the new column.
    */
   public void setColumn (int c)
   {
      col = c;
   }//end setColumn method
   
   
   /**
    * This method compares two Position objects.
    *
    * @return true is they are equal, false if they are not.
    */
   public boolean equals (Object o)
   {
      Position other = (Position) o;
      
      //the following is valid because other is a Postiion object.
      if (other.row == row && other.col == col)
         return true;
      else
         return false;
   }//end equals method
   
   public Position clone (Position p)
   {
     Position pNew = new Position (p.getRow(), p.getColumn());
     return pNew;
   }
   /**
    * This method returns a String version of the Position.
    *
    * @return returns a String version of the Position object.
    */
   public String toString ()
   {
      return new String ("(" + row + "," + col + ")");
   }//end toString method
   
}//end class