package exercise_4;

import java.util.*;

public class GuessingGame
{
     public static void main (String args [])
     {
          Scanner in = new Scanner(System.in);
          Random gen = new Random();
          
          int magicNumber; 
          int guess;
          int numGuesses = 7;
          boolean win = false;
          
          System.out.println(">>>Welcome to the best game ever<<<\n  -number is between 1 and 100-\n");
          
          magicNumber = gen.nextInt(100) + 1;
          
          //test
          //System.out.println(magicNumber);
          
          do
          {
               System.out.print("Enter a guess (" + numGuesses + " left):");
               guess = in.nextInt();
               numGuesses--;
               
               if(guess == magicNumber)
               {
                    win = true;
                    numGuesses = 0;
               }
               else if(guess > 100 || guess < 1)
               {
                    System.out.println("Out of Bounds");
                    numGuesses++;
               }
               else if(guess > magicNumber)
               {
                    System.out.println("Too High...");
               }
               else if(guess < magicNumber)
               {
                    System.out.println("Too Low...");
               }
          }
          while(!win && numGuesses > 0);
          
          if(win)
               System.out.println("YOU WIN!");
          else
               System.out.println("YOU LOSE!");
          
          
     }

}
