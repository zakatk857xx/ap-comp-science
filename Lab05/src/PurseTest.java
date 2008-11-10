import java.util.ArrayList;

/**
 * Tests the <code>Purse</code> object and its methods
 * 
 * @author Thomas Zaki
 * Nov 10, 2008
 *
 */
public class PurseTest
{     
     public static void main(String[] args)
     {
          ArrayList<Coin> initCoins = new ArrayList<Coin>();
          initCoins.add(new Coin("QUARTER", .25));
          initCoins.add(new Coin("DIME",    .10));
          initCoins.add(new Coin("NICKEL",  .05));
          initCoins.add(new Coin("QUARTER", .25));
          initCoins.add(new Coin("QUARTER", .25));
          initCoins.add(new Coin("PENNY",   .01));
          initCoins.add(new Coin("QUARTER", .25));
          initCoins.add(new Coin("PENNY",   .01));
          initCoins.add(new Coin("DIME",    .10));
          
          Purse p1 = new Purse(initCoins);
          Purse p2 = new Purse(initCoins);
          
          System.out.println(p1);
          System.out.println(p2 + "\n");
          
          System.out.println("Same Contents: " + p1.sameContents(p2));
          System.out.println("Same Order:    " + p1.sameCoins(p2) + "\n");
          
          p1.reverseCoins();
          System.out.println(p1);
          System.out.println(p2 + "\n");
          
          System.out.println("Same Contents: " + p1.sameContents(p2));
          System.out.println("Same Order:    " + p1.sameCoins(p2) + "\n");
          
          p2.transferTo(p1);
          System.out.println(p1);
          System.out.println(p2 + "\n");
          
          System.out.println("Same Contents: " + p1.sameContents(p2));
          System.out.println("Same Order:    " + p1.sameCoins(p2) + "\n");
          
          p2.transferFrom(p1);          
          System.out.println(p1);
          System.out.println(p2 + "\n");
          
          System.out.println("Same Contents: " + p1.sameContents(p2));
          System.out.println("Same Order:    " + p1.sameCoins(p2) + "\n");
          
     }//end main

}//end Tester class
