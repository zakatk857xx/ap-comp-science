import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;

/**
 * 
 * This version of <code>Monopoly</code> uses <code>Player</code>, 
 *   <code>Property</code>, and <code>Die</code> to 
 *   simulate playing a game of Monopoly using text based
 *   input and output (game is played at the command line).
 * 
 * @author Thomas Zaki
 * @version 1.0.9
 *
 */
public class Monopoly
{
     
     public static ArrayList<Player> players;
     public static ArrayList<Property> properties;
     public static Die d6;
     public static Token tokens;
     public static MonopVars vars;
     public static Scanner in;
     
     /**
      * The main method body... nothing special here
      * 
      * @param beans an array of strings received at the command line (useless here)
      * @throws BadDataException 
      * @throws IOException 
      */
     public static void main(String beans[]) throws IOException, BadDataException
     {
          initializeData();
          
          Player player1 = new Player("Player 1", Player.SACK_OF_MONEY);players.add(player1);
          Player player2 = new Player("Player 2", Player.BATTLESHIP);players.add(player2);
          Player player3 = new Player("Player 3", Player.SCOTTISH_TERRIER);players.add(player3);         
          
          welcome();
          
          setPlayerNames(players, in);    
          
          boolean gameOver = false; //keeps track of whether the game is still going or not
          int counter = 0; //to tell whose turn it is
          
          //continuously loops through players (even though in this version there is only one)
          // and has each of them take their turn
          do
          {
               in.nextLine();
               gameOver = takeTurn(players.get(counter), d6, properties, in);
               in.nextLine();
               counter++;
               if(counter > players.size() - 1)
                    counter = 0;               
          }while(!gameOver);
          
          
     }

     /**
      * Prints a welcome message before the game begins
      */
     public static void welcome()
     {
         System.out.println(                   
         "                                  -+ooo:       ++//++                                    \n" +
         "                               -sy+-`dMN-     :+y++so                                    \n" +
         "                             -hN:    -NMd`    +:y.                                       \n" +
         "                            oNMMN:   .sNdy`   .y:y:                                      \n" +
         "                           +mMMMMN+++-`-mMh.-h+`o++s`                                    \n" +
         "                           +s+NMMhs. `.-+ydmm-   -s:s:                                   \n" +
         "                   -:       :homshmysy+/:-`.ss`   `/o+s`                                 \n" +
         "                  osh        :dsdso+:o+`    `:y     `s+sos+-                             \n" +
         "              ./syh`h`       .d++y-  - `    :/o/      oy+s:/o`                           \n" +
         "           .+ys:.`o :mo+/.   h/sh//   -s  `/  -y`.   `y-so` :+                           \n" +
         "          oso++   ` +osMMNh+`d:Ny:.      `.do+/ds+    s`o:o/`o                           \n" +
         "         .y-/o++oooy+yMMMMMMNddm:   `  -o/``  .-y-   :yh+yysyy+                          \n" +
         "          `soo/-`` `:dMMMMMMMMMNhy+o`so++  `o/:+s-   .md+hss/.yyy.                       \n" +
         "                    `./smMMMMMMMNdMd:++//os/.y/    :mMMNooh`  /yy+                       \n" +
         "                         -yMMMMMMMMMhs+-.`.+mdo++smMMMMMMNo    `oys-                     \n" +
         "                           -dMMMMMMMd ++++:ohMMMMMMMMMMMMh.      -yy+`                   \n" +
         "                            `dMMMMMMM/sssosodMMMMMMMMMMm/         `+ys-                  \n" +
         "                             :MMMMMMMN/`  `:MMMMMMMMMd+`            .s:                  \n" +
         "                             /MNhdhdMM/    sMMMMMNho-                                    \n" +                        
         "   Y8b Y8b Y888P 888'Y88 888       e88'Y88   e88 88e       e   e     888'Y88             \n" +
         "    Y8b Y8b Y8P  888 ,'Y 888      d888  'Y  d888 888b     d8b d8b    888 ,'Y             \n" +
         "     Y8b Y8b Y   888C8   888     C8888     C8888 8888D   e Y8b Y8b   888C8               \n" +
         "      Y8b Y8b    888 \",d 888  ,d  Y888  ,d  Y888 888P   d8b Y8b Y8b  888 \",d           \n" +
         "       Y8P Y     888,d88 888,d88   \"88,d88   \"88 88\"   d888b Y8b Y8b 888,d88          \n" +
         "                                                                                         \n" +
         "                               88P'888'Y88   e88 88e                                     \n" +
         "                               P'  888  'Y  d888 888b                                    \n" +
         "                                   888     C8888 8888D                                   \n" +
         "                                   888      Y888 888P                                    \n" +
         "                                   888       \"88 88\"                                   \n" +
         "                                                                                         \n" +
         "    e   e       e88 88e   Y88b Y88   e88 88e   888 88e    e88 88e   888     Y88b Y8P     \n" + 
         "   d8b d8b     d888 888b   Y88b Y8  d888 888b  888 888D  d888 888b  888      Y88b Y      \n" + 
         "  e Y8b Y8b   C8888 8888D b Y88b Y C8888 8888D 888 88\"  C8888 8888D 888       Y88b      \n" + 
         " d8b Y8b Y8b   Y888 888P  8b Y88b   Y888 888P  888       Y888 888P  888  ,d    888       \n" + 
         "d888b Y8b Y8b   \"88 88\"   88b Y88b   \"88 88\"   888        \"88 88\"   888,d88    888 \n");
         //credit to http://www.text-image.com/convert/ascii/
         //  and http://www.network-science.de/ascii/
         //  for the text and image conversions
       
         
     }

     /**
      * Assigns names to all of the players in the current game 
      * 
      * @param players an <code>ArrayList</code> of <code>Player</code> objects
      * @param in a <code>Scanner</code> object to receive user input
      */
     public static void setPlayerNames(ArrayList<Player> players, Scanner in)
     {
          //iterates through all of the players and asks for their names from the user(s)
          for (Player p : players)
          {
               System.out.print("Enter a name for " + p.getName() + ": ");
               p.setName(in.nextLine());
          }
          
          //my best solution for dealing with the in.nextLine() and in.next() functions
          System.out.println("\nPress <Enter> to begin the game");
     }
          
     /**
      * This method handles all of the actions a <code>Player</code> can carry out 
      *   during his turn (as defined by this version of Monopoly)
      *   
      * @param p the player taking the turn
      * @param d6 a six-sided <code>Die</code> 
      * @param properties the <code>ArrayList</code> of <code>Property</code> objects
      *                     that store all of the spaces on the Monopoly board
      * @param in a <code>Scanner</code> object to receive user input
      * 
      * @return the resulting value of gameOver
      */
     public static boolean takeTurn(Player p, Die d6, ArrayList<Property> properties, Scanner in)
     {
          //declare local variables to handle the roll values and the gameOver value at then end
          int roll1, roll2, rollSum;
          boolean gameOver = false;
          
          //there are two potential cases in a turn: in Jail or not, so
          //  first, if the player is not in jail, do this:
          if(!p.isInJail())
          {
               //print out the player stats (for the current player taking the turn)
               //  and the two options they have on their turn: roll or quit
               System.out.print("+-------------------+\n" +
                                "|     NEXT TURN     |\n" +
                                "+-------------------+\n" +
                                p                  + "\n" +
                                "_____________________\n" + 
                                p.getName() + "'s turn: What do you want to do?\n" + 
                                " (1) Roll Die\n" + 
                                " (2) Exit\n>");
               
               //options depending on user input
               switch(in.nextInt())
               {
                    case 1:
                         //roll twice, add 'em up
                         roll1 = d6.nextRoll();
                         System.out.println("Rolled a " + roll1);
                         roll2 = d6.nextRoll();
                         System.out.println("Rolled a " + roll2);
                         
                         rollSum = roll1 + roll2;
                         
                         //while doubles have been rolled and the player has not been sent to jail
                         while(roll1 == roll2 && !p.isInJail())
                         {
                              System.out.println("Doubles! Roll again.");
                              
                              //essentially a counter of doubles added to player
                              p.addDoubles();                          
                              
                              //once 3 doubles have been rolled, send to jail and set in jail to true
                              if(p.getDoubles() == 3)
                              {
                                   System.out.println("\nRolled doubles three times... GO TO JAIL!");
                                   p.setSpace(10);
                                   p.setInJail(true);
                              } 
                              else //if player hasn't rolled 3 doubles, let them roll again
                              {
                                   roll1 = d6.nextRoll();
                                   System.out.println("Rolled a " + roll1);
                                   roll2 = d6.nextRoll();
                                   System.out.println("Rolled a " + roll2);         
                                   
                                   rollSum += roll1 + roll2;
                              }
                         }    
                         p.resetDoubles();// once the rolling is over, sets the doubles to zero again
                         
                         //the second turn segment (movement), if the player is not in jail
                         if(!p.isInJail())
                         {                         
                              int move = p.getSpace() + rollSum;

                              //handles passing and/or landing on go
                              if (move > 39)
                              {
                                   p.setSpace(move - 40);
                                   if (p.getSpace() != 0)
                                        System.out.println("You Passed Go! Collect $200.");
                                   else
                                        System.out.println("You Landed on Go! Collect $200.");
                                   p.setMoney(200);
                              }
                              else
                                   p.movePiece(rollSum);

                              //handles the Go to Jail space
                              if (p.getSpace() == 30)
                              {
                                   System.out.println("\nLanded on \"GO TO JAIL!\"");
                                   p.setSpace(10);
                                   p.setInJail(true);
                              }

                              //tells the player where they landed
                              System.out.println("\n" + p.getName()
                                        + " landed on: \n"
                                        + properties.get(p.getSpace()).getName() + "(" + p.getSpace() + ")");
                         }                         
                         break;
                    case 2:
                         gameOver = true; 
                         break;
                    default:
                         break;
               }
          }
          //handles the jail turns
          else if(p.isInJail())
          {               
               if(p.getTimeInJail() < 3)
               {
                    System.out.print(
                                "+-------------------+\n"
                              + "|     NEXT TURN     |\n"
                              + "+-------------------+\n" + p + "\n"
                              + "_____________________\n" + p.getName()
                              + "'s turn: What do you want to do?\n"
                              + " (1) Roll Die\n" + " (2) Pay $50 to get out\n"
                              + " (3) Exit\n>");
                    switch (in.nextInt())
                    {
                         case 1:
                              roll1 = d6.nextRoll();
                              System.out.println("Rolled a " + roll1);
                              roll2 = d6.nextRoll();
                              System.out.println("Rolled a " + roll2);

                              //if doubles are rolled, get out of jail
                              if (roll1 == roll2)
                              {
                                   System.out.println("\nGot out of jail!");
                                   p.setInJail(false);
                              }
                              break;
                         case 2:
                              //pay $50 to get out
                              System.out.println("\nGot out of jail!");
                              p.setInJail(false);
                              p.setMoney(-50);
                              System.out.println(p.getName() + " has $"
                                        + p.getMoney());
                              break;
                         case 3:
                              gameOver = true;
                              break;
                         default:
                              break;
                    }
                    p.addJailTime();
               }
               //if they've been in for 3 turns, they have to pay $50 or lose the game
               else if(p.getTimeInJail() == 3)
               {
                    System.out.print(
                                "+-------------------+\n"
                              + "|     NEXT TURN     |\n"
                              + "+-------------------+\n" + p + "\n"
                              + "_____________________\n" + p.getName()
                              + "'s turn: TIME TO PAY UP!\n"
                              + " (1) Pay $50 to get out\n"
                              + " (2) Exit\n>");
                    switch (in.nextInt())
                    {
                         case 1:
                              System.out.println("\nGot out of jail!");
                              p.setInJail(false);
                              p.setMoney(-50);
                              System.out.println(p.getName() + " has $"
                                        + p.getMoney());
                              break;
                         case 2:
                              gameOver = true;
                              break;
                         default:
                              break;
                    }
               }
          }
          
          return gameOver;
               
     }
     

     /**
      * This method returns the suffix of the given number.
      * 
      * @param number the number to find the suffix for
      * @return returns the suffix of the number as a String.
      */
     public static String getSuffix (int number)
     {
        if ((number % 10) == 1 && ((number / 10) % 10) != 1)
           return new String ("st");
        else if ((number % 10) == 2 && ((number / 10) % 10) != 2)
           return new String ("nd");
        else if ((number % 10) == 3 && ((number / 10) % 10) != 3)
           return new String ("rd");
        else
           return new String ("th");
        
     }//end getSuffix method
     
     public static void initializeData() throws IOException, BadDataException
     {
        boolean fileFound = false;
        
        //Initialize the objects
        in = new Scanner (System.in);
        players = new ArrayList<Player>();
        properties = new ArrayList<Property>();
        tokens = new Token();
        vars = new MonopVars();
        MonopolyDataReader reader = new MonopolyDataReader();
        
        do
        {
           //try to obtain a valid file
           try
           {
              reader.readMonopolyFile (chooseFile(), vars, tokens, properties);
              //reader.readMonopolyFile ("C:\\Documents and Settings\\Thomas Zaki\\Desktop\\workspace\\Monopoly_v2\\src\\MonopolyData.txt", vars, tokens, properties);
              fileFound = true;
           }//end try
           catch (FileNotFoundException e)
           {
              System.out.println ("\n\nFile not found.  Please try again.");
           }//end catch
        }//end do
        while (!fileFound);
        
        d6 = new Die (vars.getNumDiceSides());
           
     }// end of initializeData method
     
     
     /*
       * This method uses a JFileChooser to locate the data file
       * to be used in this version of Monopoly.
       * 
       * @return the name of the file to be used for this game
       */

     public static String chooseFile ()
     {
        String filename = new String();
        boolean fileChosen = false;
        
        //This window is the parent for the JFileChooser
        JWindow window = new JWindow();
        
        //YOU CAN CHANGE THE INITIAL PATH FOR THE JFileChooser TO LOOK IN!
        //Perhaps the Desktop?
        JFileChooser chooser = new JFileChooser ("/Users/tzaki/java/monopoly_v2/src/MonopolyData.txt");
        
        do
        {
           try
           {
              //Opens the JFileChooser
              chooser.showOpenDialog(window);
              
              //Returns the name of the file that was chosen.
              filename = chooser.getName (chooser.getSelectedFile());
              fileChosen = true;
           }//end try
           catch (NullPointerException e)
           {
              System.out.println ("Please choose a file before continuing.");
           }//end catch
        }
        while (!fileChosen);
        
        return filename;
     }// end of chooseFile method


}