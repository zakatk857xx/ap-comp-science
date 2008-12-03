import java.util.Scanner;
import java.awt.geom.Point2D;
import java.awt.geom.Ellipse2D;

/**
   This is a test driver for the ellipse containment methods.
*/
public class EllipseTester
{
   public static void main(String[] args)
   {
      Ellipse2D.Double e = new Ellipse2D.Double(100, 100, 200, 300);
      Point2D.Double p = new Point2D.Double(200, 100);
      System.out.println(Geometry.isOnBoundary(p, e));
      System.out.println("Expected: true");
      Point2D.Double q = new Point2D.Double(0, 0);
      System.out.println(Geometry.isInside(q, e));
      System.out.println("Expected: false");
   }
}
