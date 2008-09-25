/**
 * Tester class for the Car class
 * @author tzaki
 * @version Sep 19, 2008
 *
 */
public class CarTester
{
     public static void main(String beans[])
     {
          Car c1 = new Car(17);
          Car c2 = new Car(35, 20);
          Car c3 = new Car(100, 5);
          
          c1.fillTank();
          c2.fillTank();
          c3.addGas(50);
          
          c1.drive(80);
          c2.drive(45);
          c3.drive(200);
          
          System.out.println("c1: " + c1.gasInTank() + 
                             "\nc2: " + c2.gasInTank() +
                             "\nc3: " + c3.gasInTank());
     }
}
