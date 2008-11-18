/**
 * Prints the alternating sum of the integers entered at the command line
 *   separated by spaces
 * 
 * @author Thomas Zaki
 * Nov 10, 2008
 *
 */
public class AlternatingSum
{
     public static void main(String[] args)
     {
          //receive numbers at command line
          int[] nums = new int[args.length];
          
          for(int i = 0; i < nums.length; i++)
               nums[i] = Integer.parseInt(args[i]);
          
          int sum = 0;
          for(int i = 0; i < nums.length; i++)
               if(i % 2 == 0)
                    sum += nums[i];
               else
                    sum -=nums[i];
          
          System.out.println(sum);
     }//end main
}//end class
