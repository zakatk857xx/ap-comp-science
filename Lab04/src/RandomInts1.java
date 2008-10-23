/**
 * 
 * @author tzaki
 * @version Oct 22, 2008
 *
 * a loop that fills an array of ints with 10 random numbers between 1 and 100.
 */

import java.util.*;

public class RandomInts1
{
     public static void main(String beans[])
     {
          Random gen = new Random();
          
          int[] nums = new int[10];
          
          for(int i = 0; i < 10; i++)
               nums[i] = gen.nextInt(100) + 1;
          
          for(int i = 0; i < 10; i++)
               System.out.print(nums[i] + " ");

     }

}
