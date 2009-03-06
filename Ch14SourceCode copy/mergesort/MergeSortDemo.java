import java.util.ArrayList;
import java.util.Arrays;

/**
   This program demonstrates the merge sort algorithm by
   sorting an array that is filled with random numbers.
*/
public class MergeSortDemo
{  
   public static void main(String[] args)
   {  
        StopWatch w = new StopWatch();
        
        ArrayList<Comparable> a = new ArrayList<Comparable>();

        a.add("asdfgasf");
        a.add("sdfgsdfg");
        a.add("gsdfg");
        a.add("sdfgdfsh");
        a.add("dfgh");
        a.add("h");
        a.add("ytuityi");
        a.add("tyuytuii");
        a.add("piuopuio");
        
        System.out.println(a);

      MergeSorter sorter = new MergeSorter(a);
      w.start();
      sorter.sort();
      w.stop();
      
      System.out.println(a);
      System.out.println(w.getElapsedTime());
   }
}



