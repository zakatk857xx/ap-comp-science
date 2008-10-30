/**
 * 
 * A <code>Property</code> is used to store information about all of the 
 *   buyable locations on a Monopoly board.
 * 
 * @author Thomas Zaki
 * @version Oct 28, 2008
 *
 */
public class Property
{
     public static final int OTHER    = -1;
     public static final int PROPERTY =  0;
     public static final int UTILITY  =  1;
     public static final int RAILROAD =  2;
     public static final int JAIL     =  3;
     
     
     
     private String name;
     private int owner;
     private int type;
     private String colorGroup;
     private int cost;
     private int rent;
     private int mortgage;
     private int space;
     
     /**
      * Creates a standard <code>Property</code> object with blank or zero initial values
      */
     public Property()
     {
          name       = "UNDEFINED";
          owner      = 0;
          type       = 0;
          colorGroup = "NONE";
          cost       = 0;
          rent       = 0;
          mortgage   = 0;
          space      = 0;
     }
     
     /**
      * Creates a standard <code>Property</code> object with blank or zero initial values,
      *   except for a specified space
      *   
      * @param s the location of the <code>Property</code>
      */
     public Property(int s)
     {
          name       = "UNDEFINED";
          owner      = 0;
          type       = 0;
          colorGroup = "NONE";
          cost       = 0;
          rent       = 0;
          mortgage   = 0;
          space      = s;
     }
     /**
      * Creates a standard <code>Property</code> object with blank or zero initial values,
      *   except for a specified name and space
      *   
      * @param n the name of the <code>Property</code>
      * @param s the space where the <code>Property</code> is located
      */
     public Property(String n, int s)
     {
          name       = n;
          owner      = 0;
          type       = 0;
          colorGroup = "NONE";
          cost       = 0;
          rent       = 0;
          mortgage   = 0;
          space      = s;
     }
     
     /**
      * Creates a new <code>Property</code> object
      * 
      * @param n  the name of the <code>Property</code>
      * @param o  the owner of the <code>Property</code>
      * @param t  the type of the <code>Property</code> (see field values for type options)
      * @param cG the color group of the <code>Property</code> (e.g "Red", "Blue", etc.)
      * @param c  the cost of the <code>Property</code>
      * @param r  the rent of the <code>Property</code> (no houses or hotels)
      * @param m  the mortgage value of the <code>Property</code>
      * @param s  the space where the <code>Property</code> is located
      */
     public Property(String n, int o, int t, String cG, int c, int r, int m, int s)
     {
          name       = n;
          owner      = o;
          type       = t;
          colorGroup = cG;
          cost       = c;
          rent       = r;
          mortgage   = m;
          space      = s;
     }
     
     /**
      * Gets the name of the <code>Property</code>
      * 
      * @return the name of the <code>Property</code>
      */
     public String getName()
     {
          return name;
     }
     
     /**
      * Gets the index of the <code>Player</code> who owns the <code>Property</code>
      * 
      * @return an index
      */
     public int getOwner()
     {
          return owner;
     }
     
     /**
      * Changes the owner of the <code>Property</code>
      * 
      * @param o the index of the new owner
      */
     public void setOwner(int o)
     {
          owner = o;
     }
     
     /**
      * Gets the type of the <code>Property</code>
      * 
      * @return the type
      */
     public int getType()
     {
          return type;
     }
     
     /**
      * Gets the color group of the <code>Property</code>
      * 
      * @return the color group
      */
     public String getColorGroup()
     {
          return colorGroup;
     }
     
     /**
      * Gets the cost of the <code>Property</code>
      * 
      * @return the cost
      */
     public int getCost()
     {
          return cost;
     }
     
     /**Gets the rent of the <code>Property</code>
      * 
      * @return the rent
      */
     public int getRent()
     {
          return rent;
     }
     
     /**
      * Gets the mortgage value of the <code>Property</code>
      * 
      * @return the morgage value
      */
     public int getMortgage()
     {
          return mortgage;
     }
     
     /**
      * Gets the space where the <code>Property</code> is located
      * 
      * @return the space
      */
     public int getSpace()
     {
          return space;
     }
     
     /**
      * Returns all relevant values about a <code>Property</code>
      */
     public String toString()
     {
          return "PROPERTY: <" + name + ">\n" + 
                 " (*)Owner       = "  + owner      + "\n" + 
                 " (*)Type        = "  + type       + "\n" + 
                 " (*)Color Group = "  + colorGroup + "\n" + 
                 " (*)Cost        = $" + cost       + "\n" + 
                 " (*)Rent        = $" + rent       + "\n" + 
                 " (*)Mortgage    = $" + mortgage   + "\n" + 
                 " (*)Space       = "  + space;
     }     
     
}


