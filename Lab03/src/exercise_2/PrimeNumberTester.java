package exercise_2;

import java.util.Scanner;

public class PrimeNumberTester
{
     public static void main (String beans[])
     {
          Scanner in = new Scanner(System.in);
          
          int limit = 0;
          int counter = 0;
          
          System.out.print("Generate primes up to:");
          limit = in.nextInt();
          
          for(int i = 0; i < limit; i++)
          {
               if(PrimeNumber.testIsPrime(i))
               {
                    System.out.println(i);
                    counter++;
               }
          }
          
          System.out.println("There are " + counter + " prime numbers between 0 and " + limit);
          
     }

}
