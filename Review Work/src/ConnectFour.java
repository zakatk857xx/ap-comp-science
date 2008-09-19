import java.util.*;

public class ConnectFour
{
     public static void main(String beans[])
     {
          Scanner in = new Scanner(System.in);
          CFBoard gameBoard = new CFBoard();
          
          ArrayList<String> players = new ArrayList<String>();
          
          int turnNumber = 1;
          boolean isNotOver = true;
          
          System.out.println("Welcome to Connect 4.\n");
                              
          for(int i = 0; i < 2; i++)
          {
               System.out.println("What is player " + (i + 1) + "'s name?");
               //in.next();
               players.add(in.nextLine());
          }
          
          while(isNotOver)
          {
               switch (turnNumber)
               {
                    case 1:
                         System.out.println("It's your turn, " + players.get(0) +
                                   "\nEnter column number:");
                         //in.next();
                         gameBoard.placePieceColumn('x', in.nextInt());
                         turnNumber = 2;
                         break;
                    case 2:
                         System.out.println("It's your turn, " + players.get(1) +
                                   "\nEnter column number:");
                         //in.next();
                         gameBoard.placePieceColumn('o', in.nextInt());
                         turnNumber = 1;
                         break;
                    default:
                         //do nothing;
               }
               
               System.out.println(gameBoard);
          }
          
          //System.out.println(gameBoard);
          
          //gameBoard.placePiece('x', 2, 2);
          //gameBoard.placePieceColumn('x', 2);
          //gameBoard.placePieceColumn('o', 2);
          //gameBoard.placePieceColumn('x', 1);
          //gameBoard.placePieceColumn('o', 1);
          //gameBoard.placePieceColumn('x', 1);
          //gameBoard.placePieceColumn('o', 5);
          
          //System.out.println(gameBoard);
     }
}
