/**
   This class has methods to calculate the volume and surface area of 
   geometric shapes.
*/
public class Geometry
{
   /**
      Computes the volume of a sphere.
      @param r the radius
      @return volume of sphere
    */
   public static double sphereVolume(double r)
   {
      return 4.0 * Math.PI * r * r * r / 3.0;
   }

   /**
      Computes the surface area of a sphere.
      @param r the radius
      @return surface area of a sphere
    */
   public static double sphereSurface(double r)
   {
      return 4.0 * Math.PI * r * r;
   }

   /**
      Computes the volume of a cylinder.
      @param r the radius
      @param h the height
      @return volume of a cylinder
    */
   public static double cylinderVolume(double r, double h)
   {
      return Math.PI * r * r * h;
   }

   /**
      Computes the surface area of a cylinder.
      @param r the radius
      @param h the height
      @return surface area of a cylinder
    */
   public static double cylinderSurface(double r, double h)
   {
      return 2.0 * r * Math.PI * (r + h);
   }

   /**
      Computes the volume of a cone.
      @param r the radius
      @param h the height
      @return volume of a cone
    */
   public static double coneVolume(double r, double h)
   {
      return Math.PI * r * r * h / 3.0;
   }

   /**
      Computes the surface area of a cone.
      @param r the radius
      @param h the height
      @return surface area of a cone
    */
   public static double coneSurface(double r, double h)
   {
      return Math.PI * r * (r + h);
   }
}
