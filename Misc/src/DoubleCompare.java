
/*
 * must override compare to and equals methods
 */

public class DoubleCompare
{

     public static void main(String args [])
     {
          double root = Math.sqrt(2);
          double result = Math.pow(root, 2) - 2;
          
          final double EPSILON = 1E-14;
          
          if(Math.abs(result - 0) <= EPSILON)
          {

               System.out.println(result + " = 0");
          }
          else
          {
               System.out.println(result + " != 0");
          }
          
          /*
          if(result == 0)
          {
               System.out.println(result + " = 0");
          }
          else
          {
               System.out.println(result + " != 0");
          }
          */
     }
     
}
