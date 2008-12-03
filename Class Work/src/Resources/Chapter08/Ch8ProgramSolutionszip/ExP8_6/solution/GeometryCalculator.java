import java.util.Scanner;

/**
   This is a test driver for the Sphere, Cylinder, and Cone class
   This approach is more object-oriented than the previous one because
   it clearly separates the duties of each class.
*/
public class GeometryCalculator
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      
      System.out.println("Please enter the radius: ");
      double r = in.nextDouble();
      
      System.out.println("Please enter the height: ");
      double h = in.nextDouble();

      Sphere sp = new Sphere(r);
      double v = sp.getVolume();
      double s = sp.getSurfaceArea();

      System.out.println("The volume of the sphere is: " + v);
      System.out.println("The surface area of the sphere is: " + s);

      Cylinder cy = new Cylinder(r, h);
      v = cy.getVolume();
      s = cy.getSurfaceArea();

      System.out.println("The volume of the cylinder is: " + v);
      System.out.println("The surface area of the cylinder is: " + s);

      Cone co = new Cone(r, h);
      v = co.getVolume();
      s = co.getSurfaceArea();

      System.out.println("The volume of the cone is: " + v);
      System.out.println("The surface area of the cone is: " + s);
   }
}
