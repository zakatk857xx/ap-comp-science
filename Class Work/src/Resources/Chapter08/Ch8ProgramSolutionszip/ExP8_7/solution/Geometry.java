import java.awt.geom.Ellipse2D;

/**
   The standard API for the Ellipse does not provide methods to compute
   the area and perimeter of an Ellipse. Because we cannot add or modify
   library classes, we must provide our own helper class.
   It makes sense to use static methods here because these methods
   do not require an implicit parameter
*/
public class Geometry
{
   /**
      Computes the area of an ellipse.
      @param e the ellipse
      @return area of the ellipse
    */
   public static double area(Ellipse2D.Double e)
   {
      double a = e.getWidth() / 2;
      double b = e.getHeight() / 2;
      return Math.PI * a * b;
   }

   /**
      Computes the perimeter of an ellipse.
      (Note: There is no closed formula for the exact value; see
      http://mathworld.wolfram.com/Ellipse.html. There are several
      formulas for approximations, but they aren't all that good. 
      We compute the value using the Gauss-Kummer series.) 
      @param e the ellipse
      @return the perimeter of the ellipse      
    */
   public static double perimeter(Ellipse2D.Double e)
   {
      double a = e.getWidth() / 2;
      double b = e.getHeight() / 2;
      double EPSILON = 1E-12;

      double h = (a - b)/(a + b);
      h = h * h;
      double sum = 0;      
      double coeff = 1;
      double power = 1;
      double n = 0;
      double term = 1;
      while (term > EPSILON)
      {
         sum = sum + term;
         n++;
         double factor = (0.5 - n + 1) / n;
         coeff = coeff * factor * factor;         
         power = power * h;
         term = coeff * power;
      }

      return Math.PI * (a + b) * sum;
   }
}
