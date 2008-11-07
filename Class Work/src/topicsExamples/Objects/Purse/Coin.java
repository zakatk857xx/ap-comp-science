package topicsExamples.Objects.Purse;

/**
 * Simulates a coin
 * 
 * @author tzaki 
 * 11/05/08
 */

public class Coin implements Comparable<Coin>
{
     
     private String name;
     private double value;
     
     /**
      * Creates a new coin with a specified name and value
      * 
      * @param n a name
      * @param v a value
      */
     public Coin(String n, double v)
     {
          name = n;
          value = v;
     }//end Constructor
     
     /**
      * Returns the name of the coin
      * 
      * @return the name
      */
     public String getName()
     {
          return name;    
     }//end getName
     
     /**
      * Returns the value of the coin
      * 
      * @return the value
      */
     public double getValue()
     {
          return value;
     }//end getValue
     
     /**
      * returns the name of the Coin
      */
     public String toString()
     {
          return this.getName();
     }
     
     public boolean equals(Coin other)
     {
          boolean result = false;
          if(other.getName().equals(this.getName()) 
                    && other.getValue() == this.getValue())
               result = true;
          
          return result;
     }
     
     public int compareTo(Coin that)
     {
          int result = 0;
          
          if(this.value > that.value)
               result = 1;
          else if(this.value < that.value)
               result = -1;
          else if(this.name.compareTo(that.name) == 1)
               result = 1;
          else if(this.name.compareTo(that.name) == -1)
               result = -1;
                         
          return result;
     }

}//end Coin class
