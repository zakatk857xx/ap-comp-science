/**
   This class provides methods to compute the volume and surface area of a cone.
*/
public class Cone
{
   /**
      Constructs a Cone object with input: radius and height.
      @param aRadius the radius
      @param aHeight the height
   */
   public Cone(double aRadius, double aHeight)
   {
      r = aRadius;
      h = aHeight;
   }

   /**
      Computes the volume of a cone.
      @return volume of a cone
    */
   public double getVolume()
   {
      return (1.0 / 3.0) * Math.PI * r * r * h;
   }

   /**
      Computes the surface area of a cone.
      @return surface area of a cone
    */
   public double getSurfaceArea()
   {
      return Math.PI * r * (h + r);
   }

   private double r;
   private double h;
}