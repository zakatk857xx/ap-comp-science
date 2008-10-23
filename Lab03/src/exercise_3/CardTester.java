package exercise_3;

import java.util.Scanner;

public class CardTester
{
     public static void main (String beans[])
     {
          Scanner in = new Scanner(System.in);
          
          Card c1 = new Card("10D");
          Card c2 = new Card("AH");
          Card c3 = new Card("9S");
          
          System.out.print(c1 + "\n" + c2 + "\n" + c3 + "\n\nEnter your own choice:");
          
          Card c4 = new Card(in.nextLine());
          
         
          System.out.println(c4);
     }

}
