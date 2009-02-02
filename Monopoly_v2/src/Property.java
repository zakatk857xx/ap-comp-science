/**
 * This class is used to create a basic property in the game Monopoly.
 * You can inherit from this object to create specific Property objects.
 * <p>
 * This version of the Property object stores basic information
 * about the player including name, current space, money, how
 * many doubles the player rolled.
 * 
 * @author Mr. Kevin Dietzler
 */

import java.util.*;

public class Property
{
   private String name;
   private int type;
   private int index;
   
   
   /**
    * This constructor sets the values for
    * all the basic Property attributes.
    * 
    * @param n the name of the Property
    * @param t an int denoting what type the property
    * is (see the <code>getType</code> method)
    * @param i the index of the Property on the board
    */
   public Property (String n, int t, int i)
   {
      name = new String (n);
      type = t;
      index = i;
   }//end Property constructor
   
   
   /**
    * Returns the property's name.
    * 
    * @return the property's name
    */
   public String getName ()
   {
      return name;
   }//end getName method
   
   
   /**
    * Returns the property's type.  A Property can be:
    * <p>
    * 1: MonopolyProperty - a property that can be purchased as part of a Monopoly;
    * <p>
    * 2: RailroadProperty - one of the 4 railroads;
    * <p>
    * 3: UtilityProperty: one of the 2 utilities;
    * <p>
    * 4: CommunityChest - a Community Chest space (can be named differently
    * based on version;
    * <p>
    * 5: Chance - a Chance space (can be named differently based on version;
    * <p>
    * 6: GO - The starting space and space that players pass or land on for a
    * bonus;
    * <p>
    * 7: JailJustVisiting - the space on the board where a player is while
    * in Jail;
    * <p>
    * 8: FreeParking - the halfway point on the board;
    * <p>
    * 9: GoToJail - the space that sends the player to jail;
    * <p>
    * 10: IncomeTax - charges the player a fixed amount or percentage
    * of their total money;
    * <p>
    * 11: LuxuryTax - charges the player a fixed amount when landed on.
    * 
    * @return the type of this property based on the descriptions above.
    */
   public int getType ()
   {
      return type;
   }//end getType method
   
   
   /**
    * Returns the property's index on the board.
    * 
    * @return the property's index
    */
   public int getIndex ()
   {
      return index;
   }//end getIndex method
   
   
   /**
    * Returns a printable version of this property's attribute status.
    * <p>
    * 
    * @return a printable version of this property's attrubute status.
    */
   public String toString ()
   {
      return new String (getClass().getName() +
                         "[name=" + getName() + "]" +
                         "[type=" + getType() + "]" +
                         "[index=" + getIndex() + "]");
                         
   }//end toString method
   
}//end Property class