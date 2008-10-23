package exercise_1;

import java.util.Scanner;

public class FibonacciTester
{
     public static void main (String beans[])
     {
          FibonacciGenerator gen = new FibonacciGenerator();
          Scanner in = new Scanner(System.in);
          
          int limit = 0;
          
          System.out.print("Enter how many Fib's to genreate:");
          limit = in.nextInt();                    
          
          System.out.println("\nCounting up:");
          
          for(int i = 0; i < limit; i++)
               System.out.println(gen.nextInt());
          
          System.out.println("\nCounting down:");
          
          System.out.println(gen.currentInt());
          for(int i = 0; i < limit; i++)
               System.out.println(gen.previousInt());
          
          
          
     }// end main
}// end class
