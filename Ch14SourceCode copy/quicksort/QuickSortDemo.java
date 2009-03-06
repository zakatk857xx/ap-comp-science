import java.util.ArrayList;
import java.util.Arrays;

public class QuickSortDemo
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

      QuickSorter sorter = new QuickSorter(a);
      sorter.sort();
      System.out.println(a);
   }
}

