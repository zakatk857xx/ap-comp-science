/**
 * Uses static methods to compute stuff
 * 
 * @author Thomas Zaki
 *
 */

import java.util.Scanner;

public class P8_10
{
     public static void main(String[] args)
     {
          Scanner in = new Scanner(System.in);
          
          int min = 0;
          int max = 100;
          
          String prompt = new String("Enter a number between " + min + " and " + max + ": ");
          String error  = new String("Entered a number that is not between " + min + " and " + max 
                    + ". Please re-enter your number.");
          
          System.out.println(Input.readInt(in, prompt, error, min, max));
     }

}