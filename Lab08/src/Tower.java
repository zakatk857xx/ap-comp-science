/**
 *    The Tower class inherits from Rectangle2D.Double and has extra
 *      features like an ArrayList of Disc objects and a towerIndex.
 *    <br>
 *    Date: 2/6/08
 * 
 *    @author Mr. Dietzler
 *
 */

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Tower extends Rectangle2D.Double
{
   private int towerIndex;
   private ArrayList<Disc> discs;
   
   public Tower (int tI, double x, double y, double w, double h)
   {
      discs = new ArrayList<Disc>();
      towerIndex = tI;
      setRect (x, y, w, h);
   }//end Tower constructor
   
   
   public int getTowerIndex ()
   {
      return towerIndex;
   }//end getTowerIndex method
   
   
   public boolean addDisc (Disc discToAdd)
   {
      discs.add (discToAdd);
      
      return true;
   }//end addDisc method
   
   
   public int getNumDiscs ()
   {
      return discs.size();
   }//end getNumDiscs method
   
   
   public Disc peekDisc (int index)
   {
      return discs.get (index);
   }//end peekDisc method
   
   
   public Disc removeDisc (int index)
   {
      return discs.remove (index);
   }//end removeDisc method
   
}//end Tower class