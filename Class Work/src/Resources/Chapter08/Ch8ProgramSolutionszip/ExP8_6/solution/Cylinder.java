/**
   This class provides methods to compute the volume and surface area
   of a cylinder.
*/
public class Cylinder
{
   /**
      Constructs a Cylinder object with input: radius and height.
      @param aRadius the radius
      @param aHeight the height
   */
   public Cylinder(double aRadius, double aHeight)
   {
      r = aRadius;
      h = aHeight;
   }

   /**
      Computes the volume of a cylinder.
      @return volume of a cylinder
    */
   public double getVolume()
   {
      return h * Math.PI * r * r;
   }

   /**
      Computes the surface area of a cylinder.
      @return surface area of a cylinder
    */
   public double getSurfaceArea()
   {
      return (2.0 * r * Math.PI * h) + (2.0 * Math.PI * r * r);
   }

   private double r;
   private double h;
}