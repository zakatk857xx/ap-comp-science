/*
 * The Maze class stores a two-dimensional array of chars.  All '*'s
 * represent walls and empty ' 's represent movable spaces.  The class
 * also contains a Position object for the starting position of the maze
 * and a Position object for the ending position.
 * 
 * @author Mr. Dietzler
 */
import java.util.*;

public class Maze
{
   private char [][] maze;
   private Position start, end;
   
   /**
    * This constructor receives an initial 2-d array for the maze and
    * two Position objects for the start and stop.
    * 
    * @param m the 2-d array of chars storing the maze.
    * @param s the Position object storing the starting position.
    * @param e the Position object storing the ending position.
    */
   public Maze (char[][] m, Position s, Position e)
   {
      maze = m.clone();
      start = s;//.clone();
      end = e;//.clone();
      
      this.getClass().
   }//end constructor
   
   
   
   /**
    * This method returns a clone of the 2-d array of chars storing
    * the maze.
    *
    * @return a clone of the 2-d array.
    */
   public char[][] getMazeArray ()
   {
      return (char[][]) maze.clone ();
   }//end getMazeArray method
   
   
   /**
    * This method returns the starting position of the maze.
    *
    * @return the start Position object.
    */
   public Position getStart ()
   {
      return start;
   }//end getStart method
   
   
   /**
    * This method returns the ending position of the maze.
    *
    * @return the end Position object.
    */
   public Position getEnd ()
   {
      return end;
   }//end getEnd method
   
   
   /**
    * This method returns a clone of the 2-d array of chars storing
    * the maze.
    *
    * @return a clone of the 2-d array.
    */
   public char getContents (int row, int col)
   {
      if ((row < 0 || row >= maze.length) ||
          (col < 0 || col >= maze.length))
         return 'X';
      
      return maze [row][col];
   }//end getContents method
   
   
   /**
    * This method returns a String version of the Maze.
    *
    * @return returns a String version of the Maze object.
    */
   public String toString ()
   {
      String result = new String ();
      
      result += "+";
      
      for (int j = 0; j < maze.length; j++)
         result += "-";
      
      result += "+\n";
      
      for (int i = 0; i < maze.length; i++)
      {
         result += "|";
         for (int j = 0; j < maze[i].length; j++)
         {
            result += maze[i][j];
         }
         result += "|\n";
      }
      
      result += "+";
      
      for (int j = 0; j < maze.length; j++)
         result += "-";
      
      result += "+";
      
      return result;
   }//end toString method
   
}//end class