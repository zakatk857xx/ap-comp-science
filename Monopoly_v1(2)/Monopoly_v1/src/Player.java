/**
 * A <code>Player</code> can be used to store information
 *  about and simulate the actions of a Monopoly player.
 *  
 * @author Thomas Zaki
 *
 */
public class Player
{     
     //these are essentially useless, but care fun to have
     public static final int WHEELBARROW      = 0;
     public static final int BATTLESHIP       = 1;
     public static final int SACK_OF_MONEY    = 2;
     public static final int HORSE_AND_RIDER  = 3;
     public static final int CAR              = 4;
     public static final int TRAIN            = 5;
     public static final int THIMBLE          = 6;
     public static final int CANNON           = 5;
     public static final int BOOT             = 8;
     public static final int SCOTTISH_TERRIER = 9;
     public static final int IRON             = 10;
     public static final int TOP_HAT          = 11;
     
     
     private String name;
     private int whichPiece;
     private int space;
     private int money;
     private int doubles;
     private boolean inJail;
     private int timeInJail;
     
     /**
      * Creates a standard </code>Player</code> object with the following default instance field values: <br />
      *   name: "UNKNOWN"<br />
      *   piece: 0<br />
      *   space: 0 (Go)<br />
      *   money: $1500<br />
      *   doubles: 0 (never rolled doubles)<br />
      *   inJail: false (not in jail)<br />
      *   timeInJail: 0 (has not spet a turn in jail)
      */
     public Player() 
     {
          name       = new String("UNKNOWN");
          whichPiece = 0;
          space      = 0;
          money      = 1500;
          doubles    = 0;
          inJail     = false;
          timeInJail = 0;
          
     }
     
     /**
      * Creates a standard </code>Player</code> object with a specified name:
      *   @see Player() Default Instance Field Values
      */
     public Player(String n)
     {
          name       = n;
          whichPiece = 0;
          space      = 0;
          money      = 1500;
          doubles    = 0;
          inJail     = false; 
          timeInJail = 0;         
     }
     
     /**
      * Creates a standard <code>Player</code> object with a specified name and piece: <br />
      *   (see field values for piece options)
      *   @see Player() Default Instance Field Values
      */
     public Player(String n, int piece)
     {
          name       = n;
          whichPiece = piece;
          space      = 0;
          money      = 1500;
          doubles    = 0;
          inJail     = false;
          timeInJail = 0;
     }
     
     /**
      * Gets the mane of the <code>Player</code>
      * 
      * @return the name of the <code>Player</code>
      */
     public String getName()
     {
          return name;
     }
     
     /**
      * Changes the name of the <code>Player</code>
      * 
      * @param n the new name of the <code>Player</code>
      */
     public void setName(String n)
     {
          name = n;
     }
     
     /**
      * Gets the current space of the <code>Player</code>
      * 
      * @return the current space of the <code>Player</code>
      */
     public int getSpace()
     {
          return space;
     }
     
     /**
      * Sets the current space of the <code>Player</code>
      * 
      * @param location the new space of the <code>Player</code>
      */
     public void setSpace(int location)
     {
          space = location;
     }
     
     /**
      * Moves the <code>Player</code> piece forward a specified amount
      * 
      * @param amt the number of spaces to move
      */
     public void movePiece(int amt)
     {
          space += amt;
     }
     
     /**
      * Adds 1 to the number of times the <code>Player</code> has rolled doubles
      */
     public void addDoubles()
     {
          doubles++;
     }
     
     /**
      * Gets the number of times the <code>Player</code> has rolled doubles
      * 
      * @return the number of doubles
      */
     public int getDoubles()
     {
          return doubles;
     }
     
     /**
      * Resets a the number of times a <code>Player</code> 
      *   has rolled doubles to 0
      */
     public void resetDoubles()
     {
          doubles = 0;
     }
     
     /**
      * Gets whether the <code>Player</code> is in jail or not
      * 
      * @return the jail status of the <code>Player</code>
      */
     public boolean isInJail()
     {
          return inJail;
     }
     
     /**
      * Sets whether the <code>Player</code> is in jail or not
      * 
      * @param status whether the <code>Player</code> is in jail or not
      */
     public void setInJail(boolean status)
     {
          inJail = status;
     }
     
     /**
      * Gets the integer value of the <code>Player</code>'s piece
      * 
      * @return the piece
      */
     public int getPiece()
     {
          return whichPiece;
     }
     
     /**
      * Changes a <code>Player</code>'s piece
      * 
      * @param piece the new piece
      * @see static variables for piece options
      */
     public void setPiece(int piece)
     {
          whichPiece = piece;
     }
     
     /**
      * Gets the amount of money a <code>Player</code> has
      * 
      * @return the amount of money
      */
     public int getMoney()
     {
          return money;
     }
     
     /**
      * Can either add or subtract from a <code>Player</code>'s amount
      *   of money (a positive number adds, a negative subtracts)
      *   
      * @param value how much money to add or subtract
      */
     public void setMoney(int value)
     {
          money += value;
     }
     
     /**
      * Sets a <code>Player</code>'s time in jail to zero
      */
     public void resetTimeInJail()
     {
          timeInJail = 0;
     }
     
     /**
      * Counts one turn's worth of Jail time for the <code>Player</code>
      */
     public void addJailTime()
     {
          timeInJail++;
     }
     
     /**
      * Gets how long (in turns) a <code>Player</code> has been in jail
      * 
      * @return the time the <code>Player</code> has spent in jail
      */
     public int getTimeInJail()
     {
          return timeInJail;
     }
     
     /**
      * Returns all relevant information about a <code>Player</code>
      */
     public String toString()
     {
          String toReturn = 
          "PLAYER: <" + name + ">\n" + 
          " (*)Piece      = "  + whichPiece   + "\n" + 
          " (*)Money      = $" + money        + "\n" + 
          " (*)Doubles    = "  + doubles      + "\n" + 
          " (*)In jail?   = "  + inJail       + "\n";
          
          //if the player is in jail, print out how long it's been too
          if(inJail)
               toReturn += "    -How long? = "  + timeInJail   + "\n";
          
          toReturn += " (*)Space      = "  + space;
          
          return toReturn;
     }
     
     
     

}