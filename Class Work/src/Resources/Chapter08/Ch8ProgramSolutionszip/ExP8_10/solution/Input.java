import java.util.Scanner;

/**
   This class provides a helper method for reading input.
*/
public class Input
{
   /**
      Reads an integer between a given minimum and the maximum.
      @param in the scanner to read from
      @param prompt the user prompt
      @param error the message to print when the user makes an error.
      @param min the number minimum
      @param max the number maximum
      @return the number that the user has provided
   */
   public static int readInt(Scanner in, String prompt, 
      String error, int min, int max)
   {
      while (true)
      {
         System.out.println(prompt);
         int num = in.nextInt();

         if (num >= min && num <= max)
            return num;         
         System.out.println(error);
      }
   }
}
