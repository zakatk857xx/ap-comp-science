import java.util.*;

/**
   This program demonstrates the selection sort algorithm by
   sorting an array that is filled with random numbers.
*/
public class SelectionSortDemo
{  
   public static void main(String[] args)
   {  
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

      SelectionSorter sorter = new SelectionSorter(a);
      sorter.sort('a');
      System.out.println(a);
      sorter.sort('D');
      System.out.println(a);
   }
}

   
