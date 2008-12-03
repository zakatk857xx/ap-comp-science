import java.awt.geom.Point2D;

/**
   This class supplies a method to compute the angle between the x-axis and the line
   given by two points. 

   It makes sense to use a static method here because we cannot add an angle method 
   to the Point2D library class. 
*/
public class Geometry
{
   /**
      Computes the angle between the x-axis and the line given by two points
      @param p the first point
      @param q the second point
      @return the angle between the x-axis and the line joining p and q
      (in degrees, between -180 and 180)
      (Precondition: p and q are different points)
    */
   public static double angle(Point2D.Double p, Point2D.Double q)
   {
      assert !p.equals(q);
      double dx = q.getX() - p.getX();
      double dy = q.getY() - p.getY();

      return Math.toDegrees(Math.atan2(dy, dx));
   }

   /**
      Computes the slope of the line given by two points
      @param p the first point
      @param q the second point
      @return the slope of the line joining p and q
      (Precondition: the line is not vertical.)
    */
   public static double slope(Point2D.Double p, Point2D.Double q)
   {
      double dx = q.getX() - p.getX();
      double dy = q.getY() - p.getY();
      assert dx != 0;

      return dy / dx;
   }
}
