import java.util.Arrays;
import java.util.Scanner;

/**
   This program demonstrates the binary search algorithm.
*/
public class BinarySearchDemo
{  
   public static void main(String[] args)
   {  
      // Construct random array
   
        StopWatch w = new StopWatch();
        
        
      int[] a = ArrayUtil.randomIntArray(200000, 100);
      Arrays.sort(a);
      //System.out.println(Arrays.toString(a));
      BinarySearcher2 searcher = new BinarySearcher2(a);
      Scanner in = new Scanner(System.in);

      boolean done = false;
      while (!done)
      {
         System.out.print
               ("Enter number to search for, -1 to quit:");
         int n = in.nextInt();
         if (n == -1) 
            done = true;
         else
         {
              w.start();
            int pos = searcher.search(n);
            w.stop();
            System.out.println("Found in position " + pos + ". Search took " + w.getElapsedTime() + " ns.");
            w.reset();
         }
      }
   }
}
