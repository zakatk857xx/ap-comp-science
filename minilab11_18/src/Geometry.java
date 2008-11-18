/**
 * Collection of static methods to perform geometric formulas
 * 
 * @author Thomas Zaki
 * 11/18/2008
 *
 */
public class Geometry
{     
     /**
      * Computes the volume of a sphere
      * 
      * @param r the radius of the sphere
      * @return the volume
      */
     public static double sphereVolume(double r)
     {
          return (4.0 / 3.0) * Math.PI * Math.pow(r, 3);
          
     }//end shpereVolume
     
     /**
      * Computes the surface area of a sphere
      * 
      * @param r the radius of the sphere
      * @return the surface area
      */
     public static double sphereSurface(double r)
     {
          return 4 * Math.PI * Math.pow(r, 2);
          
     }//end shpereVolume
     
     /**
      * Computes the volume of a cylinder
      * 
      * @param r the radius of the cylinder
      * @param h the height of the cylinder
      * @return the volume
      */
     public static double cylinderVolume(double r, double h)
     {
          return Math.PI * Math.pow(r, 2) * h;
          
     }//end cylinderVolume
     
     /**
      * Computes the surface area of a cylinder
      * 
      * @param r the radius of the cylinder
      * @param h the height of the cylinder
      * @return the surface area
      */
     public static double cylinderSurface(double r, double h)
     {
          return (2 * Math.PI * Math.pow(r, 2)) + (2 * r * h);
          
     }//end cylinderVolume
     
     /**
      * Computes the volume of a cone
      * 
      * @param r the radius of the cone
      * @param h the height of the cone
      * @return the volume
      */
     public static double coneVolume(double r, double h)
     {          
          return (1.0 / 3.0) * Math.PI * Math.pow(r, 2) * h;
          
     }//end coneVolume
     
     /**
      * Computes the surface area of a cone
      * 
      * @param r the radius of the cone
      * @param h the height of the cone
      * @return the surface area
      */
     public static double coneSurface(double r, double h)
     {          
          return (Math.PI * r) * (Math.sqrt(Math.pow(r, 2) + Math.pow(h, 2)) + r);
          
     }//end coneVolume
}//end class
