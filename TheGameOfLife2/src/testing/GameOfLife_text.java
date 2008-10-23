/**
 * Output of the game of Life
 * 
 * @author Thomas Zaki
 * @version 10/11/08
 */

package testing;

import gameElements.Grid;
import java.util.Scanner;

public class GameOfLife_text
{
     public static void main(String[] args)
     {
          Scanner in = new Scanner(System.in);
          
          System.out.println("Enter side dimension:");
          Grid g = new Grid(in.nextInt());
          
          g.changeState(2, 1);
          g.changeState(3, 2);
          g.changeState(3, 3);
          g.changeState(2, 3);
          g.changeState(1, 3);
          
          /*
           int x;
           int y;
           int choice = 0;
           
           do
           {
           System.out.println("Enter point coords (x,y):");
           x = in.nextInt();
           y = in.nextInt();
           g.changeState(x, y);
           
           System.out.println("Add another? (1 -> y, 2 -> n):");
           choice = in.nextInt();
           }
           while(choice != 2); 
           */
          
          
          
          for(int i = 0; i < 30; i++)
          {
               System.out.println(g.getTextGrid());
               g.nextGeneration();
               in.nextLine();
          }
          
          
     }
     
}
