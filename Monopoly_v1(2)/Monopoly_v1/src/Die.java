import java.util.Random;

/**
 * A <code>Die</code> is simply an extended version of a
 *   <code>Random</code> object with a specified limit that
 *   can be used to simulate rolling a die.
 * 
 * @author Thomas Zaki
 *
 */
public class Die
{
     
     private int numSides;
     private Random gen;
     
     /**
      * Creates a standard <code>Die</code> object with 6 sides
      */
     public Die() 
     {
          numSides = 6;
          gen = new Random();
     }
     
     /**
      * Creates a <code>Die</code> object with a specified number of sides
      * 
      * @param n the number of sides of the die
      */
     public Die(int n)
     {
          numSides = n;
          gen = new Random();          
     }
     
     /**
      * Gets the number of sides of the <code>Die</code>
      * 
      * @return the number of sides
      */
     public int getNumSides()
     {
          return numSides;
     }
     
     /**
      * Changes the number of sides of the <code>Die</code>
      * 
      * @param n the new number of sides
      */
     public void setNumSides(int n)
     {
          numSides = n;
     }
     
     /**
      * Simulates rolling the <code>Die</code>
      * 
      * @return the result of the roll
      */
     public int nextRoll()
     {
          return gen.nextInt(numSides) + 1;
     }
     
     /**
      * Returns all relevant information about a <code>Die</code>
      * 
      * @return the current number of sides
      */
     public String toString()
     {
          return "Number of Sides" + numSides;
     }

}

