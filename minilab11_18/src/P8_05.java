/**
 * Uses static methods to compute formulas
 * 
 * @author Thomas Zaki
 *
 */
import java.util.Scanner;

public class P8_05
{
     public static void main(String[] args)
     {
          Scanner in = new Scanner(System.in);
          double r, h;   
          
          System.out.print("Radius: ");
          r = in.nextDouble();
          
          System.out.print("Height: ");
          h = in.nextDouble();
          
          System.out.println(Geometry.coneSurface(r, h));
          System.out.println(Geometry.coneVolume(r, h));
          System.out.println(Geometry.cylinderVolume(r, h));
          System.out.println(Geometry.cylinderVolume(r, h));
          System.out.println(Geometry.sphereSurface(r));
          System.out.println(Geometry.sphereVolume(r));
     }//end main

}
