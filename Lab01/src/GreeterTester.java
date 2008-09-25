/**
 * Tester class for the Greeter class
 * @author tzaki
 * @version Sep 19, 2008
 *
 */
public class GreeterTester
{
     public static void main(String beans[])
     {
          Greeter g1 = new Greeter();
          Greeter g2 = new Greeter("world");
          Greeter g3 = new Greeter("Dave");
          
          System.out.println(g1.sayHello() + "\n" + g1.sayGoodbye() + "\n" + g1.refuseHelp() + "\n\n" + 
                             g2.sayHello() + "\n" + g2.sayGoodbye() + "\n" + g2.refuseHelp() + "\n\n" +
                             g3.sayHello() + "\n" + g3.sayGoodbye() + "\n" + g3.refuseHelp());
          
     }
}
