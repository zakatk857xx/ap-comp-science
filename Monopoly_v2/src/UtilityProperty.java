/**
 * This class can be used to create Utility properties.
 * 
 * @author Mr. Kevin Dietzler
 */

public class UtilityProperty extends BuyableProperty
{
   
   /**
    * This constructor sets the values for
    * all the UtilityProperty attributes.
    * 
    * @param n the name of the Property
    * @param t an int denoting what type the property
    * is (see the <code>getType</code> method)
    * @param i the index of the Property on the board
    * @param c the cost of the Property
    * @param m the mortgage value of the Property
    */
   public UtilityProperty (String n, int t, int i, int c, int m)
   {
      super (n, t, i, c, m);
   }//end UtilityProperty constructor
   
   
   /**
    * This method uses the factor parameter to determine how much rent
    * must based on the number of utilities a player owns.
    * <p>
    * It returns the factor the dice total will be multiplied by.
    * 
    * @param factor used to determine how much rent must be payed when
    * a player lands on this property
    * @return the factor to multiply the dice total by
    */
   public int getRent (int factor)
   {
      switch (factor)
      {
         case 1:
            return 4;
         case 2:
            return 8;
         default:
            return 0;
      }//end switch
   }//end getRent method
      
   
   /**
    * This method uses the numUtilities and diceTotal parameters
    * to determine how much rent must payed when a player lands on
    * this property and it is owned by a different player.
    * 
    * @param numUtilities the number of utilities the player who owns
    * this property has.
    * @param diceTotal the amount shown on the dice when this utility
    * was landed on.
    * @return the rent
    */
   public int getUtilityRent (int numUtilities, int diceTotal)
   {
      return getRent(numUtilities) * diceTotal;
   }//end getUtilityRent method
      
   
   public String toString ()
   {
      return new String (super.toString ());
                         
   }//end toString method
   
}//end UtilityProperty class