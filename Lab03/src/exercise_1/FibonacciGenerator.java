package exercise_1;
/**
 * The Fibonacci Generator can be used to print a list of fibonacci numbers
 * @author tzaki
 * @version Oct 8, 2008
 *
 */

public class FibonacciGenerator
{
     private int oldFib;
     private int newFib;
     
     /**
      * Creates a new FibonacciGenerator object
      */
     public FibonacciGenerator()
     {
          oldFib = 0;
          newFib = 1;
     }//end Constructor
     
     /**
      * Evaluates and returns the next value in the sequence
      * 
      * @return the next number in the sequence
      */
     public int nextInt()
     {
          int temp = newFib;
          newFib = oldFib + newFib;
          oldFib = temp;
          
          return newFib;
     }//end nextInt
     
     /**
      * Returns the current value in the sequence
      * 
      * @return the current number in the sequence
      */
     public int currentInt()
     {
          return newFib;
     }//end nextInt
     
     /**
      * Evaluates and returns the previous value in the sequence
      * 
      * @return the previous number in the sequence
      */
     public int previousInt()
     {
          int temp = newFib;
          oldFib = newFib - oldFib;
          newFib = temp - oldFib;
          
          return newFib;
     }//end previousInt()
     

}//end class
