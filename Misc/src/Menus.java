/**
 * Simple menu test... or not really.... YAY recursive menus
 * 
 * @author tzaki
 * @version Oct 7, 2008
 *
 */

import java.util.Scanner;

public class Menus
{
     public static void main(String[] args)
     {
          Scanner in = new Scanner(System.in);
          int choice = 0;
          
          menu(in, choice);
     }
     
     public static void menu(Scanner in, int choice)
     {
          do
          {
               System.out.println("Enter 1 to continue and 2 to quit: ");
               choice = in.nextInt();
               
               switch (choice)
               {
                    case 1:
                    {
                         System.out.println("Continuing...");
                         break;
                    }
                    case 2:
                    {
                         System.out.println("Quitting...");
                         break;
                    }
                    default:
                    {
                         System.out.println("Try Again");
                         menu(in, choice);
                    }
               }
               
          }
          while(choice == 1);
          
     }

}
