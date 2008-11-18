/**
 * Uses static methods to compute formulas
 * 
 * @author Thomas Zaki
 *
 */
public class P8_11
{
     public static void main(String [] args)
     {
          int x, n;
          
          x = 2;
          
          for(int i = -5; i <= 5; i++)
          {
               n = i;
               System.out.println(Numeric.intPower(x, n));
          }
     }//end main
}//end class
