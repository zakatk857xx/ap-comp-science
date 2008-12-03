import java.awt.geom.Point2D;

/**
   This program tests the methods to compute the slope and
   angle of a line.
*/
public class LineTester
{
   public static void main(String[] args)
   {
      Point2D.Double p = new Point2D.Double(1, 1);
      Point2D.Double q = new Point2D.Double(3, 0);

      System.out.println("Slope: " + Geometry.slope(p, q));
      System.out.println("Expected: -0.5");

      Point2D.Double r = new Point2D.Double(3, -1);

      System.out.println("Angle: " + Geometry.angle(p, r));
      System.out.println("Expected: -45");

   }
}

