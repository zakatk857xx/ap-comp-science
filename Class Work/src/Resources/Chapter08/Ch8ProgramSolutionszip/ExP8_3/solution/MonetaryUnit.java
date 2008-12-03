/**
   A monetary payment unit with a monetary value.
*/
public class MonetaryUnit
{
   /**
      Constructs a MonetaryUnit.
      @param aValue the monetary value of the unit.
      @param aName the name of the unit
   */
   public MonetaryUnit(double aValue, String aName) 
   { 
      value = aValue; 
      name = aName;
   }

   /**
      Gets the value.
      @return the value
   */
   public double getValue() 
   {
      return value;
   }

   /**
      Gets the name.
      @return the name
   */
   public String getName() 
   {
      return name;
   }

   private double value;
   private String name;
}
