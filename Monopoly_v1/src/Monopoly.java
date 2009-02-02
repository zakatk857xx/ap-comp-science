import java.util.*;

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
     /**
      * The main method body... nothing special here
      * 
      * @param beans an array of strings received at the command line (useless here)
      */
     public static void main(String beans[])
     {
          //to receive input 
          Scanner in = new Scanner(System.in);
          
          //create a die to simulate rolling a die
          Die d6 = new Die(6);
          
          //create an ArrayList of players and add one for now:
          ArrayList<Player> players = new ArrayList<Player>();      
          //Player bank    = new Player("Bank", -1);
          Player player1 = new Player("Player 1", Player.SACK_OF_MONEY);players.add(player1);
          Player player2 = new Player("Player 2", Player.BATTLESHIP);players.add(player2);
          Player player3 = new Player("Player 3", Player.SCOTTISH_TERRIER);players.add(player3);         
          
          welcome();
          setPlayerNames(players, in);    
          
          //create an ArrayList of properties and then store all of the properties in it:
          ArrayList<Property> properties = new ArrayList<Property>();          
          createProperties(properties);
          
          boolean gameOver = false; //keeps track of whether the game is still going or not
          int counter = 0; //to tell whose turn it is
          
          do
          {
               in.nextLine();
               gameOver = takeTurn(players.get(counter), d6, properties, gameOver, in);
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
      * Assigns initial values to all of the <code>Property</code> 
      *   objects on a Monopoly board and then adds them to an
      *   <code>ArrayList</code> defined and accessible in the main
      *   method
      *   
      * @param properties an <code>ArrayList</code> of <code>Property</code> objects
      *                     to which the properties will be added to
      */
     public static void createProperties(ArrayList<Property> properties)
     {
          //I admit that this was not necessary at all, but I really, REALLY wanted to so...
          Property mediterraAve = new Property("Mediterranean Avenue",  0, 0, "Brown",       60,  2,  30,  1); 
          Property balticAve    = new Property("Baltic Avenue",         0, 0, "Brown",       60,  4,  30,  3); 
          Property readingRR    = new Property("Reading Railroad",      0, 2, "Railroad",   200,  0, 100,  5); 
          Property orientalAve  = new Property("Oriental Avenue",       0, 0, "Light Blue", 100,  6,  50,  6); 
          Property vermontAve   = new Property("Vermont Avenue",        0, 0, "Light Blue", 100,  6,  50,  8);  
          Property connectAve   = new Property("Connecticut Avenue",    0, 0, "Light Blue", 120,  8,  60,  9); 
          Property stCharelsPlc = new Property("St. Charles Place",     0, 0, "Magenta",    140, 10,  70, 11); 
          Property electricCo   = new Property("Electric Company",      0, 1, "Utility",    150,  0,  75, 12); 
          Property statesAve    = new Property("States Avenue",         0, 0, "Magenta",    140, 10,  70, 13); 
          Property virginiaAve  = new Property("Virginia Avenue",       0, 0, "Magenta",    160, 12,  80, 14); 
          Property pennsylRR    = new Property("Pennsylvania Railroad", 0, 2, "Railroad",   200,  0, 100, 15); 
          Property stJamesPlc   = new Property("St. James Place",       0, 0, "Orange",     180, 14,  90, 16); 
          Property tennesseeAve = new Property("Tennessee Avenue",      0, 0, "Orange",     180, 14,  90, 18); 
          Property newYorkAve   = new Property("New York Avenue",       0, 0, "Orange",     200, 16, 100, 19); 
          Property kentuckyAve  = new Property("Kentucky Avenue",       0, 0, "Red",        220, 18, 110, 21); 
          Property indianaAve   = new Property("Indiana Avenue",        0, 0, "Red",        220, 18, 110, 23); 
          Property illinoisAve  = new Property("Illinois Avenue",       0, 0, "Red",        240, 20, 120, 24); 
          Property shortLnRR    = new Property("Short Line Railroad",   0, 2, "Railroad",   200,  0, 100, 25); 
          Property atlanticAve  = new Property("Atlantic Avenue",       0, 0, "Yellow",     260, 22, 130, 26); 
          Property ventorAve    = new Property("Ventnor Avenue",        0, 0, "Yellow",     260, 22, 130, 27); 
          Property waterWorks   = new Property("Water Works",           0, 1, "Utility",    150,  0,  75, 28); 
          Property marvinGarden = new Property("Marvin Gardens",        0, 0, "Yellow",     280, 24, 140, 29); 
          Property pacificAve   = new Property("Pacific Avenue",        0, 0, "Green",      300, 26, 150, 31); 
          Property northCarAve  = new Property("North Carolina Avenue", 0, 0, "Green",      300, 26, 150, 32); 
          Property pennAve      = new Property("Pennsylvania Avenue",   0, 0, "Green",      320, 28, 160, 34); 
          Property bAndORR      = new Property("B&O Railroad",          0, 2, "Railroad",   200,  0, 100, 35); 
          Property parkPlace    = new Property("Park Place",            0, 0, "Dark Blue",  350, 35, 175, 37); 
          Property boardwalk    = new Property("Boardwalk",             0, 0, "Dark Blue",  400, 50, 200, 39); 
                    
          properties.add(new Property("Go", 0));
          properties.add(mediterraAve); 
          properties.add(new Property("Community Chest", 2));
          properties.add(balticAve);    
          properties.add(new Property("Income Tax",  4));
          properties.add(readingRR);
          properties.add(orientalAve);           
          properties.add(vermontAve);
          properties.add(new Property("Chance", 7));
          properties.add(connectAve);   
          properties.add(new Property("Jail", 10));
          properties.add(stCharelsPlc);
          properties.add(electricCo);
          properties.add(statesAve);
          properties.add(virginiaAve);
          properties.add(pennsylRR);
          properties.add(stJamesPlc);   
          properties.add(tennesseeAve);
          properties.add(newYorkAve);   
          properties.add(new Property("Free Parking", 20));
          properties.add(new Property("Community Chest", 17));
          properties.add(kentuckyAve);  
          properties.add(new Property("Chance", 22));
          properties.add(indianaAve);
          properties.add(illinoisAve);
          properties.add(shortLnRR);
          properties.add(atlanticAve);
          properties.add(ventorAve);
          properties.add(waterWorks);
          properties.add(marvinGarden); 
          properties.add(new Property("Go To Jail", 30));
          properties.add(pacificAve);
          properties.add(northCarAve);  
          properties.add(new Property("Community Chest", 33));
          properties.add(pennAve);
          properties.add(bAndORR);      
          properties.add(new Property("Chance", 36));
          properties.add(parkPlace);    
          properties.add(new Property("Luxury Tax", 38));
          properties.add(boardwalk);
                    
     }
     
     /**
      * This method handles all of the actions a <code>Player</code> can carry out 
      *   during his turn (as defined by this version of Monopoly)
      *   
      * @param p the player taking the turn
      * @param d6 a six-sided <code>Die</code> 
      * @param properties the <code>ArrayList</code> of <code>Property</code> objects
      *                     that store all of the spaces on the Monopoly board
      * @param gameOver an initial value (false) for gameOver
      * @param in a <code>Scanner</code> object to receive user input
      * @return the resulting value of gameOver
      */
     public static boolean takeTurn(Player p, Die d6, ArrayList<Property> properties, boolean gameOver, Scanner in)
     {
          //declare local variables to handle the roll values
          int roll1, roll2, rollSum;
          
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
                         
                         //
                         while(roll1 == roll2 && !p.isInJail())
                         {
                              System.out.println("Doubles! Roll again.");
                              
                              p.addDoubles();                          
                              
                              if(p.getDoubles() == 3)
                              {
                                   System.out.println("\nRolled doubles three times... GO TO JAIL!");
                                   p.setSpace(10);
                                   p.setInJail(true);
                              } 
                              else
                              {
                                   roll1 = d6.nextRoll();
                                   System.out.println("Rolled a " + roll1);
                                   roll2 = d6.nextRoll();
                                   System.out.println("Rolled a " + roll2);         
                                   
                                   rollSum += roll1 + roll2;
                              }
                         }    
                         p.resetDoubles();
                         
                         //
                         if(!p.isInJail())
                         {                         
                              int move = p.getSpace() + rollSum;

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

                              if (p.getSpace() == 30)
                              {
                                   System.out.println("\nLanded on \"GO TO JAIL!\"");
                                   p.setSpace(10);
                                   p.setInJail(true);
                              }

                              System.out.println("\n" + p.getName()
                                        + " landed on: \n"
                                        + properties.get(p.getSpace()));
                         }
                         break;
                    case 2:
                         gameOver = true;
                         break;
                    default:
                         break;
               }
          }
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

                              if (roll1 == roll2)
                              {
                                   System.out.println("\nGot out of jail!");
                                   p.setInJail(false);
                              }
                              break;
                         case 2:
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

}