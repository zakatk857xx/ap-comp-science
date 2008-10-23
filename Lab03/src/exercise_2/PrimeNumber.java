package exercise_2;

public class PrimeNumber
{
     static boolean isPrime;

     /**
      * Tests to see if a given number is prime
      * 
      * @param arg the number to test
      */
     public PrimeNumber()
     {}

     static boolean testIsPrime(int value)
     {
          isPrime = true;

          if (value < 2)
               isPrime = false;
          
          else
          {
               int half = value / 2;
               
               for (int i = 1; i <= half && isPrime; i++)
                    if (value % i == 0 && i != 1)
                         isPrime = false;
          }

          return isPrime;
     }

}
