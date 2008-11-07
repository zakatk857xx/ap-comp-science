package topicsExamples.Objects.Purse;

import java.util.*;

public class Purse extends ArrayList<Coin>
{
     private static final long serialVersionUID = -4157574132402344220L; // eclipse made me do it...

     /**
      * Creates a general Purse
      */
     public Purse() {}
     
     /**
      * Creates a new purse with an ArrayList of Coins in it
      * @param coins the Coins to start with
      */
     public Purse(ArrayList<Coin> coins)
     {
          for(int i = 0; i < coins.size(); i++)
               this.add(coins.get(i));
     }//end Constructor
     
     public void reverseCoins()
     {          
          for(int i = 0; i < this.size(); i++)
               this.add(i, remove(this.size() - 1));
     }

     public void transferTo(Purse other)
     {
          int constant = this.size();
          
          for(int i = 0; i < constant; i++)
               other.add(this.remove(0));
     }
     
     public void transferFrom(Purse other)
     {
          int constant = other.size();
          
          for(int i = 0; i < constant; i++)
               this.add(other.remove(0));
     }
     
     public boolean sameContents(Purse other)
     {
          boolean result = true;
          if(other.size() != this.size())
               result = false;
          else
               for(int i = 0; i < this.size(); i++)
                    if(other.get(i).equals(this.get(i)));
          
          return result;
     }
     
     @SuppressWarnings("unchecked") //eclipse made me do it...
     public boolean sameCoins(Purse that)
     {
          boolean result = true;
          
          if(that.size() != this.size())
          {
               result = false;
          }
          else
          {
               List<Coin> tempThis = (List<Coin>) this.clone();
               List<Coin> tempThat = (List<Coin>) that.clone();

               Collections.sort(tempThis);
               Collections.sort(tempThat);

               for (int i = 0; i < this.size() && result; i++)
                    if(tempThis.get(i) != tempThat.get(i))
                         result = false;          
          }
          
          return result;
          
     }
}//end Purse class
