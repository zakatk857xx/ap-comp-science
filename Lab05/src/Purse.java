import java.util.*;

/**
 * A <code>Purse</code> stores <code>Coin</code>s
 * 
 * @author Thomas Zaki
 * Nov 10, 2008
 *
 */
public class Purse extends ArrayList<Coin>
{
     private static final long serialVersionUID = -4157574132402344220L; // eclipse made me do it...

     /**
      * Creates a general <code>Purse</code>
      */
     public Purse() {}
     
     /**
      * Creates a new purse with an <code>ArrayList</code> of <code>Coin</code>s in it
      * @param coins the <code>Coin</code>s to start with
      */
     public Purse(ArrayList<Coin> coins)
     {
          for(int i = 0; i < coins.size(); i++)
               this.add(coins.get(i));
     }//end Constructor
     
     /**
      * Reverses the order of the <code>Coin</code>s in the <code>Purse</code>
      */
     public void reverseCoins()
     {          
          for(int i = 0; i < this.size(); i++)
               this.add(i, remove(this.size() - 1));
     }

     /**
      * Transfers <code>Coin</code>s from this <code>Purse</code> to another
      * 
      * @param other the <code>Purse</code> to transfer to
      */
     public void transferTo(Purse other)
     {
          int constant = this.size();
          
          for(int i = 0; i < constant; i++)
               other.add(this.remove(0));
     }
     
     /**
      * Transfers <code>Coin</code>s to this <code>Purse</code> from another
      * 
      * @param other the <code>Purse</code> to transfer from
      */
     public void transferFrom(Purse other)
     {
          int constant = other.size();
          
          for(int i = 0; i < constant; i++)
               this.add(other.remove(0));
     }
     
     /**
      * Receives another <code>Purse</code> and tests if the contents are exactly the same
      *   and in the exact same order
      * 
      * @param that the other <code>Purse</code> to compare to
      * @return true if contents match, otherwise false
      */
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
     
     /**
      * Receives another <code>Purse</code> and tests if the contents are exactly the same
      *   though not necessaily in the same order
      * 
      * @param that the other <code>Purse</code> to compare to
      * @return true if contents match, otherwise false
      */
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

               //uses the handy fact that my Coin object implements comparable to sort and then compare
               Collections.sort(tempThis);
               Collections.sort(tempThat);

               for (int i = 0; i < this.size() && result; i++)
                    if(tempThis.get(i) != tempThat.get(i))
                         result = false;          
          }
          
          return result;
          
     }
}//end Purse class
