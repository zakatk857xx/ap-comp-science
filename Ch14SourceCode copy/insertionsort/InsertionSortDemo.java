import java.util.ArrayList;
import java.util.Arrays;

/**
   This program demonstrates the heap sort algorithm.
*/
public class InsertionSortDemo
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

      InsertionSorter sorter = new InsertionSorter(a);
      sorter.sortA();
      System.out.println(a);

      sorter.sortD();
      System.out.println(a);
   }
}
