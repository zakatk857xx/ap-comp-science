/**
 * Uses static methods to compute stuff
 * 
 * @author Thomas Zaki
 * 11/18/08
 *
 */
public class Numeric
{
     /**
      * Computes x^n in an absurd way
      * 
      * @param x the base
      * @param n the exponent
      * @return the result
      */
     public static double intPower(double x, double n)
     {
          double result;
          
          if(n < 0)
          {
               result = 1 / Math.pow(x, -1 * n);
          }
          else
          {
               if(n % 2 == 0)
               {
                    result = Math.pow(Math.pow(x, n / 2), 2);
               }
               else
               {
                    result = Math.pow(x, n - 1) * x;
               }
          }
          
          return result;          
     }//end intPower    
}//end class
