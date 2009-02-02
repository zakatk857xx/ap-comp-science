package critters;

import java.util.ArrayList;
import info.gridworld.actor.*;

public class RockHound extends Critter
{
     public void processActors(ArrayList<Actor> actors)
     {
         for (Actor a : actors)
         {
             if (!(a instanceof Critter))
                 a.removeSelfFromGrid();
         }
     }

}
