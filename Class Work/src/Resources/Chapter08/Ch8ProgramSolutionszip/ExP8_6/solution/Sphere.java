/**
   This class provides methods to compute the volume and surface area of a sphere.
*/
public class Sphere
{
   /**
      Constructs a Sphere object with input: radius and height.
      @param aRadius the radius
      @param aHeight the height
   */
   public Sphere(double aRadius)
   {
      r = aRadius;
   }

   /**
      Computes the volume of a sphere.
      @return volume of sphere
    */
   public double getVolume()
   {
      return (4.0 / 3.0) * Math.PI * r * r * r;
   }

   /**
      Computes the surface area of a sphere.
      @return surface area of a sphere
    */
   public double getSurfaceArea()
   {
      return 4.0 * Math.PI * r * r;
   }

   private double r;
}