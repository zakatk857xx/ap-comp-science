/**
 * This class can be used to create buyable Mononpoly
 * properties.  Each property can be distinguished by
 * a specific monopoly color and its rent values.
 * <p>
 * 
 * @author Mr. Kevin Dietzler
 */

public class MonopolyProperty extends BuyableProperty
{
   private int monopolyColorIndex;
   private int basicRent;
   private int oneHouseRent;
   private int twoHouseRent;
   private int threeHouseRent;
   private int fourHouseRent;
   private int hotelRent;
   private int buildingCost;
   
   
   /**
    * This constructor sets the values for
    * all the MonopolyProperty attributes.
    * 
    * @param n the name of the Property
    * @param t an int denoting what type the property
    * is (see the <code>getType</code> method)
    * @param i the index of the Property on the board
    * @param c the cost of the Property
    * @param m the mortgage value of the Property
    * @param color the Monopoly color the Property
    * @param basicR the basic rent of the Property
    * @param oneHR the rent of the Property with one house
    * @param twoHR the rent of the Property with two houses
    * @param threeHR the rent of the Property with three houses
    * @param fourHR the rent of the Property with four houses
    * @param hotelR the rent of the Property with a hotel
    * @param bC the cost to build a house or hotel on this Property
    */
   public MonopolyProperty (String n, int t, int i, int c, int m,
                            int color, int basicR, int oneHR, int twoHR,
                            int threeHR, int fourHR, int hotelR, int bC)
   {
      super (n, t, i, c, m);
      monopolyColorIndex = color;
      basicRent = basicR;
      oneHouseRent = oneHR;
      twoHouseRent = twoHR;
      threeHouseRent = threeHR;
      fourHouseRent = fourHR;
      hotelRent = hotelR;
      buildingCost = bC;
      
   }//end MonopolyProperty constructor
   
   
   /**
    * This method uses the factor parameter to determine how much rent
    * must be payed on this property.
    * <p>
    * If factor =
    * <p>
    * 0: basic rent
    * <p>
    * 1: one house rent
    * <p>
    * 2: two house rent
    * <p>
    * 3: three house rent
    * <p>
    * 4: four house rent
    * <p>
    * 5: hotel rent
    * 
    * @param factor used to determine how much rent must be payed when
    * a player lands on this property
    * @return the rent that must be payed
    */
   public int getRent (int factor)
   {
      switch (factor)
      {
         case 0:
            return getBasicRent();
         case 1:
            return getOneHouseRent();
         case 2:
            return getTwoHouseRent();
         case 3:
            return getThreeHouseRent();
         case 4:
            return getFourHouseRent();
         case 5:
            return getHotelRent();
         default:
            return 0;
      }//end switch
   }//end getRent method
      

   
   /**
    * Returns this property's color.
    * 
    * @return this property's color
    */
   public int getColor ()
   {
      return monopolyColorIndex;
   }//end getColor method
   
   
   /**
    * Returns the basic rent for this Property.
    * 
    * @return this Property's basic rent
    */
   private int getBasicRent ()
   {
      return basicRent;
   }//end getBasicRent method
   
   
   /**
    * Returns the rent for one house for this Property.
    * 
    * @return this Property's rent with one house
    */
   private int getOneHouseRent ()
   {
      return oneHouseRent;
   }//end getOneHouseRent method
   
   
   /**
    * Returns the rent for two houses for this Property.
    * 
    * @return this Property's rent with two houses
    */
   private int getTwoHouseRent ()
   {
      return twoHouseRent;
   }//end getTwoHouseRent method
   
   
   /**
    * Returns the rent for three houses for this Property.
    * 
    * @return this Property's rent with three houses
    */
   private int getThreeHouseRent ()
   {
      return threeHouseRent;
   }//end getThreeHouseRent method
   
   
   /**
    * Returns the rent for four houses for this Property.
    * 
    * @return this Property's rent with four houses
    */
   private int getFourHouseRent ()
   {
      return fourHouseRent;
   }//end getFourHouseRent method
   
   
   /**
    * Returns the rent for a hotel for this Property.
    * 
    * @return this Property's rent with a hotel
    */
   public int getHotelRent ()
   {
      return hotelRent;
   }//end getHotelRent method
   
   
   /**
    * Returns the building cost for this Property.
    * 
    * @return this Property's building cost
    */
   public int getBuildingCost ()
   {
      return buildingCost;
   }//end getBuildingCost method
   
   
   /**
    * Returns a printable version of this property's attribute status.
    * <p>
    * 
    * @return a printable version of this property's attrubute status.
    */
   public String toString ()
   {
      return new String (super.toString () +
                         "[monopolyColorIndex=" + getColor() + "]" +
                         "[basicRent=" + getBasicRent() + "]" +
                         "[oneHouseRent=" + getOneHouseRent() + "]" +
                         "[twoHouseRent=" + getTwoHouseRent() + "]" +
                         "[threeHouseRent=" + getThreeHouseRent() + "]" +
                         "[fourHouseRent=" + getFourHouseRent() + "]" +
                         "[hotelRent=" + getHotelRent() + "]" +
                         "[buildingCost=" + getBuildingCost() + "]");
                         
   }//end toString method
   
}//end MonopolyProperty class