/**
 * Uses static methods to compute stuff
 * 
 * @author Thomas Zaki
 * 11/18/08
 *
 */
import java.util.Scanner;

public class Input
{
     /**
      * Reads an <code>int</code>, continues to re-prompt until the <code>int</code> is between
      *   a specified minimum and maximum
      *   
      *   Note: this method couples like an intro2cs student
      * 
      * @param in     the <code>Scanner</code> to read the <code>int</code>
      * @param prompt the <code>String</code> to display as a prompt for the <code>int</code>
      * @param error  the <code>String</code> to display as an error message when the input
      *                 is not in range 
      * @param min the maximum of the range (not inclusive)
      * @param max the minimum of the range (not inclusive)
      * 
      * @return successful input (first <code>int</code> read within the specified range)
      */
     public static int readInt(Scanner in, String prompt, String error, int min, int max)
     {
          int temp;
          
          System.out.println(prompt);
          temp = in.nextInt();
          while(temp >= max || temp <= min)
          {
               System.out.println(error);
               System.out.println(prompt);
               temp = in.nextInt();
          }          
          return temp;
     }//end readInt
}//end class
