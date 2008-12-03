import java.util.Scanner;

/**
   This program calculate the volume
   and surface area of a sphere, a cylinder, and a cone.
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

      System.out.println("The volume of the sphere is: "
            + Geometry.sphereVolume(r));
      System.out.println("The surface area of the sphere is: "
            + Geometry.sphereSurface(r));
      System.out.println("The volume of the cylinder is: "
            + Geometry.cylinderVolume(r, h));
      System.out.println("The surface area of the cylinder is: "
            + Geometry.cylinderSurface(r, h));
      System.out.println("The volume of the cone is: "
            + Geometry.coneVolume(r, h));
      System.out.println("The surface area of the cone is: "
            + Geometry.coneSurface(r, h));
   }
}
