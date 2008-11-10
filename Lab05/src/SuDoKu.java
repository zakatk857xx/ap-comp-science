import java.util.Scanner;

/**
 * Main method of the popular SuDoKu game
 * 
 * @author Thomas Zaki
 * 11/09/08 
 */
public class SuDoKu
{
     public static void main(String[] args)
     {
          Scanner in = new Scanner(System.in);
          
          //Options:
          //
          //int[][][][] g = {{{{0,0,0}, {0,0,0}, {0,0,0}}, {{0,0,0}, {0,0,0}, {0,0,0}}, {{0,0,0}, {0,0,0}, {0,0,0}}},
          //                 {{{0,0,0}, {0,0,0}, {0,0,0}}, {{0,0,0}, {0,0,0}, {0,0,0}}, {{0,0,0}, {0,0,0}, {0,0,0}}},
          //                 {{{0,0,0}, {0,0,0}, {0,0,0}}, {{0,0,0}, {0,0,0}, {0,0,0}}, {{0,0,0}, {0,0,0}, {0,0,0}}}};
          //
          //         Ex: Board sdk = new Board(g); 
          //
          //             see: public Board(int difficulty) {} for more info on how
          //                    to format this user-defined grid
          //
          //empty constructor produces a blank board (all values are 0)
          //
          //         Ex: Board sdk = new Board()
          //
          //and also Board.EASY, Board.MEDIUM, Board.HARD
          
          
          Board sdk = new Board(Board.MEDIUM);          
          
          boolean playing = true;
          int value, row, col;
          
          System.out.println("Welcome to SuDoKu!\n -To exit, enter a negative number for value" + sdk);
          
          //added this part of the loop outside of the loop so that the game exits at the proper time
          System.out.print("Enter value:  ");
          value = in.nextInt();
          if(value < 0)
               playing = false;
          
          while(playing)
          {
               System.out.print("\nEnter row:    ");
               row = in.nextInt();
               System.out.print("\nEnter column: ");
               col = in.nextInt();
               
               //adds the number, checks if possible
               if(!sdk.addNum(value, row, col))
               {
                    //prints errors
                    System.out.println("Invalid Input: " + sdk.getErr() 
                              + "\nPress [Enter] to continue...");
                    
                    //wait for player to read errors.
                    in.nextLine();
                    in.nextLine();
               }
               
               System.out.println("\nCurent Board:" + sdk);               

               System.out.print("Enter value:  ");
               value = in.nextInt();
               if(value < 0)
                    playing = false;               
          }
          
          if(sdk.fullBoard())
               System.out.println("Nice Job! You Completed The Game!");
          else
               System.out.println("Aww! Don't Be A Quitter!");
               
          System.out.println("Thanks for playing");
     }//end main
}//end class