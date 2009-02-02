/**
 * This abstract class can be used to create buyable Mononpoly
 * properties.
 * <p>
 * Inherits from the Property superclass
 * 
 * @author Mr. Kevin Dietzler
 */

public abstract class BuyableProperty extends Property
{
   private int ownerIndex;
   //all buyable properties have a cost and a mortgage.
   private int cost;
   private int mortgage;
   
   
   /**
    * This constructor sets the values for
    * all the BuyableProperty attributes.
    * 
    * @param n the name of the Property
    * @param t an int denoting what type the property
    * is (see the <code>getType</code> method)
    * @param c the cost of the Property
    * @param m the mortgage value of the Property
    * @param i the index of the Property on the board
    */
   public BuyableProperty (String n, int t, int i, int c, int m)
   {
      super (n, t, i);
      ownerIndex = -1;
      cost = c;
      mortgage = m;
   }//end BuyableProperty constructor
   
   
   /**
    * Must be implemented in any superclass of BuyableProperty
    * 
    * @param factor the factor that must be taken into account.
    * @return the rent
    */
   public abstract int getRent (int factor);
   
   
   /**
    * Returns the index of the player who owns this property.
    * <p>
    * NOTE: a value of -1 denotes that this property is unowned.
    * 
    * @return the index of the player owning this property
    */
   public int getOwner ()
   {
      return ownerIndex;
   }//end getOwner method
   
   
   /**
    * Sets the index of the player who is buying this property.
    * 
    * @param o the index of the player buying this property
    */
   public void setOwner (int o)
   {
      ownerIndex = o;
   }//end setOwner method
   
   
   /**
    * Returns the cost of this Property.
    * 
    * @return this Property's cost
    */
   public int getCost ()
   {
      return cost;
   }//end getCost method
   
   
   /**
    * Returns the mortgage value of this Property.
    * 
    * @return this Property's mortgage value
    */
   public int getMortgage ()
   {
      return mortgage;
   }//end getMortgageValue method
   
   
   /**
    * Returns a printable version of this property's attribute status.
    * <p>
    * 
    * @return a printable version of this property's attrubute status.
    */
   public String toString ()
   {
      return new String (super.toString () +
                         "[ownerIndex=" + getOwner() + "]" +
                         "[cost=" + getCost() + "]" +
                         "[mortgage=" + getMortgage() + "]");
                         
   }//end toString method
   
}//end BuyableProperty class