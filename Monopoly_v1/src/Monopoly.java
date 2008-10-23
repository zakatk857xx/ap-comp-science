/**
 * 
 * @author tzaki
 * @version Oct 21, 2008
 *
 */

import java.util.*;
import java.awt.Color;

public class Monopoly
{
     public static void main(String beans[])
     {
          Scanner in = new Scanner(System.in);
          
          ArrayList<Player> players = new ArrayList<Player>();      
          Player bank    = new Player("Bank", 0);
          Player player1 = new Player("Player 1", 0);
          
          players.add(player1);
          
          welcome();
          setPlayerNames(players, in);          
          
          ArrayList<Player> properties = new ArrayList<Player>(); 
          
          Property medeterAve   = new Property("Mediterranean Avenue",   1, 0, "Brown",       60, 250, 500,  1);
          Property balticAve    = new Property("Baltic Avenue",          3, 0, "Brown",       60, 250, 500,  3);
          Property orientalAve  = new Property("Oriental Avenue",        6, 0, "Light Blue", 100, 250, 500,  6);
          Property vermontAve   = new Property("Vermont Avenue",         8, 0, "Light Blue", 100, 250, 500,  8);
          Property connAve      = new Property("Connecticut Avenue",     9, 0, "Light Blue", 120, 250, 500,  9);
          Property stCharelsPlc = new Property("St. Charles Place",     11, 0, "Magenta",    140, 250, 500, 11); 
          Property statesAve    = new Property("States Avenue",         13, 0, "Magenta",    140, 250, 500, 13);
          Property virginAve    = new Property("Virginia Avenue",       14, 0, "Magenta",    160, 250, 500, 14);
          Property stJamesPlc   = new Property("St. James Place",       16, 0, "Orange",     180, 250, 500, 16);
          Property tennAve      = new Property("Tennessee Avenue",      18, 0, "Orange",     180, 250, 500, 18);
          Property newYorkAve   = new Property("New York Avenue",       19, 0, "Orange",     200, 250, 500, 19);
          Property kentuckyAve  = new Property("Kentucky Avenue",       21, 0, "Red",        220, 250, 500, 21);
          Property indianaAve   = new Property("Indiana Avenue",        23, 0, "Red",        220, 250, 500, 23);
          Property illinoisAve  = new Property("Illinois Avenue",       24, 0, "Red",        240, 250, 500, 24);
          Property atlanticAve  = new Property("Atlantic Avenue",       26, 0, "Yellow",     260, 250, 500, 26);
          Property ventorAve    = new Property("Ventnor Avenue",        27, 0, "Yellow",     260, 250, 500, 27);
          Property marvinGard   = new Property("Marvin Gardens",        29, 0, "Yellow",     280, 250, 500, 29);
          Property pacificAve   = new Property("Pacific Avenue",        31, 0, "Green",      300, 250, 500, 31);
          Property northCrAve   = new Property("North Carolina Avenue", 32, 0, "Green",      300, 250, 500, 32);
          Property pennAve      = new Property("Pennsylvania Avenue",   34, 0, "Green",      320, 250, 500, 34);
          Property parkPlace    = new Property("Park Place",            37, 0, "Dark Blue",  350, 250, 500, 37);
          Property boardwalk    = new Property("Boardwalk",             39, 0, "Dark Blue",  400, 250, 500, 39);
          
          Property waterWorks   = new Property("Water Works",            3, 0, "Utility",    1000, 250, 500, 28);
          Property electricCo   = new Property("Electric Company",       3, 0, "Utility",    1000, 250, 500, 12); 
          
          Property readingRR    = new Property("Reading Railroad",       5, 2, "Railroad",   1000, 250, 500,  5);
          Property pennsylRR    = new Property("Pennsylvania Railroad", 15, 2, "Railroad",   1000, 250, 500, 15);
          Property shortLnRR    = new Property("Short Line Railroad",   35, 2, "Railroad",   1000, 250, 500, 25);
          Property BandORR      = new Property("B&O Railroad",          25, 2, "Railroad",   1000, 250, 500, 35);
          
          System.out.println(player0 + "\n\n" + boardwalk);
          
          do
          {
               
               
               
          }while(true);
          
          
     }

     public static void welcome()
     {
          System.out.println("Welcome to Monoploy");
     }

     public static void setPlayerNames(ArrayList<Player> players, Scanner in)
     {
          for (Player p : players)
          {
               System.out.print("Enter a name for " + p.getName() + ": ");
               p.setName(in.nextLine());
          }
     }

}