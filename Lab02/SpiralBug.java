package boxBug;

/**
 * @author tzaki
 * @version 9/30/08
 */

import info.gridworld.actor.Bug;

/**
 * A <code>SpiralBug</code> traces out a spiral.
 */
public class SpiralBug extends Bug
{
    private int steps;
    private int sideLength;

    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     */
    public SpiralBug(int length)
    {
        steps = 0;
        sideLength = length;
    }

    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
        if (steps < sideLength && canMove())
        {
            move();
            steps++;
        }
        else
        {
            turn();
            turn();
            sideLength++;
            steps = 0;
        }
    }
}