/**
 *    The DiscMove class simply stores two ints that represent the
 *     Tower to move from and the Tower to move to.
 *    <br>
 *    Date: 2/6/08
 * 
 *    @author Mr. Dietzler
 *
 */

public class DiscMove
{
   private int towerFrom, towerTo;
   
   public DiscMove (int from, int to)
   {
      towerFrom = from;
      towerTo = to;
   }//end DiscMove constructor
   
   
   public int getTowerFrom ()
   {
      return towerFrom;
   }//end getTowerFrom
   
   
   public int getTowerTo ()
   {
      return towerTo;
   }//end getTowerTo
   
   public String toString()
   {
        return "From: " + towerFrom + "| To: " + towerTo;
   }
   
}//end DiscMove class