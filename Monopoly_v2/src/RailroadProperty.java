/**
 * This class can be used to create Railroad properties.
 * 
 * @author Mr. Kevin Dietzler
 */

public class RailroadProperty extends BuyableProperty
{
   
   /**
    * This constructor sets the values for
    * all the RailroadProperty attributes.
    * 
    * @param n the name of the Property
    * @param t an int denoting what type the property
    * is (see the <code>getType</code> method)
    * @param i the index of the Property on the board
    * @param c the cost of the Property
    * @param m the mortgage value of the Property
    */
   public RailroadProperty (String n, int t, int i, int c, int m)
   {
      super (n, t, i, c, m);
   }//end RailroadProperty constructor
   
   
   /**
    * This method uses the factor parameter to determine how much rent
    * must based on the number of railroads a player owns.
    * 
    * @param factor used to determine how much rent must be payed when
    * a player lands on this property
    * @return the rent that must be payed
    */
   public int getRent (int factor)
   {
      switch (factor)
      {
         case 1:
            return (getCost()/8);
         case 2:
            return (getCost()/4);
         case 3:
            return (getCost()/2);
         case 4:
            return getCost();
         default:
            return 0;
      }//end switch
   }//end getRent method
      
   public String toString ()
   {
      return new String (super.toString ());
                         
   }//end toString method
   
}//end RailroadProperty class