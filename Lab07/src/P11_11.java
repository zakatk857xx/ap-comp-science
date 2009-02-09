import java.util.*;
public class P11_11
{
     public static void main(String [] beans)
     {
          Scanner in = new Scanner(System.in);
          boolean isSumming = true;
          float sum = 0.0f;
          
          do
          {
               try
               {
                    System.out.println("Enter a number: ");
                    sum += getNextNumber(in);
               }
               catch(NotANumberException e0)
               {
                    System.out.println("Try again... ");
                    try
                    {
                         System.out.println("Enter a number: ");
                         in.next();
                         sum += getNextNumber(in);
                    }
                    catch(NotANumberException e1)
                    {
                         System.out.println("Done...");
                         isSumming = false;
                    }
               }
               finally
               {
                    System.out.println("Sum: " + sum);
               }
               
          }while(isSumming);
     }
     
     public static float getNextNumber(Scanner in) throws NotANumberException
     {
          if(!in.hasNextFloat())
               throw new NotANumberException("Not a number");
          else
               return in.nextFloat();
     }
}