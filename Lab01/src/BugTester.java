/**
 * Tester class for the Bug class
 * @author tzaki
 * @version Sep 19, 2008
 *
 */
public class BugTester
{
     public static void main(String beans[])
     {
          Bug b1 = new Bug();
          Bug b2 = new Bug(7, 13);
          Bug b3 = new Bug(4, 5, Bug.SOUTH);
          
          System.out.println("-----------------\nBug #1:\nstart-" + b1.getPosition());
          b1.move();
          System.out.println("moveN-" + b1.getPosition());
          b1.turn();
          System.out.println("turnE-" + b1.getPosition());
          b1.move();
          System.out.println("moveE-" + b1.getPosition());
          b1.turn();
          System.out.println("turnS-" + b1.getPosition());
          b1.turn();
          System.out.println("turnW-" + b1.getPosition());
          b1.move();
          System.out.println("moveW-" + b1.getPosition());
          b1.move();
          System.out.println("moveW-" + b1.getPosition());
          b1.move();
          System.out.println("moveW-" + b1.getPosition());
          
          System.out.println("\n-----------------\nBug #2:\nstart-" + b2.getPosition());
          b2.move();
          System.out.println("moveN-" + b2.getPosition());
          b2.turn();
          System.out.println("turnE-" + b2.getPosition());
          b2.move();
          System.out.println("moveE-" + b2.getPosition());
          b2.turn();
          System.out.println("turnS-" + b2.getPosition());
          b2.turn();
          System.out.println("turnW-" + b2.getPosition());
          b2.move();
          System.out.println("moveW-" + b2.getPosition());
          b2.move();
          System.out.println("moveW-" + b2.getPosition());
          b2.move();
          System.out.println("moveW-" + b2.getPosition());
          
          System.out.println("\n-----------------\nBug #3:\nstart-" + b3.getPosition());
          b3.move();
          System.out.println("moveS-" + b3.getPosition());
          b3.turn();
          System.out.println("turnW-" + b3.getPosition());
          b3.move();
          System.out.println("moveW-" + b3.getPosition());
          b3.turn();
          System.out.println("turnN-" + b3.getPosition());
          b3.turn();
          System.out.println("turnE-" + b3.getPosition());
          b3.move();
          System.out.println("moveE-" + b3.getPosition());
          b3.move();
          System.out.println("moveE-" + b3.getPosition());
          b3.move();
          System.out.println("moveE-" + b3.getPosition());
     }
}
