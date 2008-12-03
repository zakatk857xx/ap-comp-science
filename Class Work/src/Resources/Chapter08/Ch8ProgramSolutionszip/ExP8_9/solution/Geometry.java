import java.awt.geom.Point2D;
import java.awt.geom.Ellipse2D;

/**
   This class provides  methods that determine if a point is inside an
   ellipse or on the ellipse boundary.
*/
public class Geometry
{
   /**
      Computes if a point is inside an ellipse.
      @param p a point
      @param e an ellipse
      @return true if p is inside e
    */
   public static boolean isInside(Point2D.Double p, Ellipse2D.Double e)
   {
      double a = e.getWidth() / 2;
      double b = e.getHeight() / 2;

      /*
         Note that the center of the ellipse has coordinates
         (e.getX() + a, e.getY() + b)
      */

      double x = (p.getX() - e.getX() - a) / a;
      double y = (p.getY() - e.getY() - b) / b;

      double xySquare = x * x + y * y;

      return xySquare <= 1;
   }

   /**
      Computes if a point is on the boundary of an ellipse.
      @param p a point
      @param e an ellipse
      @return true if p is on the boundary of e
    */
   public static boolean isOnBoundary(Point2D.Double p, Ellipse2D.Double e)
   {
      double a = e.getWidth() / 2;
      double b = e.getHeight() / 2;
      final double EPSILON = 1E-12;

      /*
         Note that the center of the ellipse has coordinates
         (e.getX() + a, e.getY() + b)
      */

      double x = (p.getX() - e.getX() - a) / a;
      double y = (p.getY() - e.getY() - b) / b;

      double xySquare = x * x + y * y;

      return Math.abs(xySquare - 1) < EPSILON ;
   }

}
