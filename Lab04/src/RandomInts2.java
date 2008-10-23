/**
 * 
 * @author tzaki
 * @version Oct 22, 2008
 *
 * a for loop that contains 10 DIFFERENT random numbers from 1 to 100.
 *
 */

import java.util.*;

public class RandomInts2
{
     public static void main(String beans[])
     {
          Random gen = new Random();

          final int limit = 30;
          
          int[] nums = new int[limit];
          int temp = 0;
          boolean isUnique;

          for (int i = 0; i < limit; i++)
          {
               do
               {
                    isUnique = true;
                    temp = gen.nextInt(100) + 1;
                    
                    for(int j = 0; j < i; j++)
                         if(temp == nums[j])
                              isUnique = false;
                    
               }while(!isUnique);
               
               //test whether unique test algorithm worked
               //System.out.println("Found Unique Number: " + temp);
               
               nums[i] = temp;
          }
               
          //used to easily check whether a number was repeated or not
          //Arrays.sort(nums);

          for (int i = 0; i < limit; i++)
               System.out.print(nums[i] + " ");

     }
}
