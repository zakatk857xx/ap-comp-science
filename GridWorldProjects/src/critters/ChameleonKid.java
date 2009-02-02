package critters;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.util.ArrayList;

/**
 * A <code>ChameleonCritter</code> takes on the color of neighboring actors as
 * it moves through the grid. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class ChameleonKid extends ChameleonCritter2
{
     /**
      * Randomly selects a neighbor and changes this critter's color to be the
      * same as that neighbor's. If there are no neighbors, no action is taken.
      */
     public void processActors(ArrayList<Actor> actors)
     {
          Actor aN = null;
          Actor aS = null;
          
          for(Actor e: actors)
          {
               if(e.getLocation().equals(this.getLocation().getAdjacentLocation(this.getDirection() + Location.AHEAD)))
                    aN = e;
               if(e.getLocation().equals(this.getLocation().getAdjacentLocation(this.getDirection() + Location.HALF_CIRCLE)))
                    aS = e;
          }                    
          if (aN == null || aS == null)
          {
               darkenColor();
               return;
          }
          else
          {
               //System.out.println("Got here! (0)"); 
               
               switch((int)(Math.random() * 2))
               {
                    case 0: setColor(aN.getColor()); break; //System.out.println("Got here! (1)"); break;
                    case 1: setColor(aS.getColor()); break; //System.out.println("Got here! (2)"); break;
               }
          }
                
     }
}
