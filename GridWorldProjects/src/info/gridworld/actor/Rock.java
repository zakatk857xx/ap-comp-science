/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 */

package info.gridworld.actor;

import java.awt.Color;
import java.util.Random;

/**
 * A <code>Rock</code> is an actor that does nothing. It is commonly used to
 * block other actors from moving. <br />
 * The API of this class is testable on the AP CS A and AB exams.
 */

public class Rock extends Actor
{

     private static final Color DEFAULT_COLOR = Color.BLACK;
     private Random             gen;

     /**
      * Constructs a black rock.
      */
     public Rock()
     {
          gen = new Random();
          setColor(new Color(gen.nextInt(255), gen.nextInt(255), gen.nextInt(255)));
     }

     /**
      * Constructs a rock of a given color.
      * 
      * @param rockColor
      *             the color of this rock
      */
     public Rock(Color rockColor)
     {
          setColor(rockColor);
     }

     /**
      * Overrides the <code>act</code> method in the <code>Actor</code>
      * class to do nothing.
      */
     public void act()
     {}
}
