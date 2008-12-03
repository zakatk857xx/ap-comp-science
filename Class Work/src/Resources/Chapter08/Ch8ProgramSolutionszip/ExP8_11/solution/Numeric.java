/**
   This class computes the value x raised to the nth power.
*/
public class Numeric
{
   /**
      Computes the value x raised to the nth power
      @param x the base value
      @param n the exponent value
    */
   public static double intPower(double x, int n)
   {
      double result = 0;

      if (n < 0)
         return 1 / intPower(x, -n);
      else if (n == 0)
         return  1;
      else
      {
         if ((n % 2) == 0)
         {
            double r = intPower(x, n / 2);
            return r * r;
         }
         else
            return intPower(x, n - 1) * x;
      }
   }
}
