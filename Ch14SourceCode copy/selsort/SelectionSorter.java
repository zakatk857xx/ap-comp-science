/**
   This class sorts an array, using the selection sort 
   algorithm
 */

import java.util.*;

public class SelectionSorter
{
     /**
      * Constructs a selection sorter.
      * 
      * @param anArray
      *             the array to sort
      */
     public SelectionSorter(ArrayList<Comparable> aList)
     {
          a = aList;
     }

     /**
      * Sorts the array managed by this selection sorter.
      */
     public void sort(char dir)
     {  
          int minPos = 0;
          
             for (int i = 0; i < a.size() - 1; i++)
             {  
                  switch(Character.toUpperCase(dir))
                  {
                       case 'A':
                       case 'U':
                       case '^':
                            minPos = minimumPositionA(i);
                            break;
                       case 'D':
                       case 'V':
                            minPos = minimumPositionD(i);
                            break;
                  }
                       
                  swap(minPos, i);
             }
        
     }
     
     public void sort(String dir) { sort(dir.charAt(0)); }
     

     /**
      * Finds the smallest element in a tail range of the array.
      * 
      * @param from
      *             the first position in a to compare
      * @return the position of the smallest element in the range a[from] . . .
      *         a[a.length - 1]
      */
     private int minimumPositionA(int from)
     {
          int minPos = from;
          for (int i = from + 1; i < a.size(); i++)
               if (a.get(i).compareTo(a.get(minPos)) < 0)
                    minPos = i;
          return minPos;
     }
     
     /**
      * Finds the smallest element in a tail range of the array.
      * 
      * @param from
      *             the first position in a to compare
      * @return the position of the smallest element in the range a[from] . . .
      *         a[a.length - 1]
      */
     private int minimumPositionD(int from)
     {
          int minPos = from;
          for (int i = from + 1; i < a.size(); i++)
               if (a.get(i).compareTo(a.get(minPos)) > 0)
                    minPos = i;
          return minPos;
     }
     
     /**
      * Swaps two entries of the array.
      * 
      * @param i
      *             the first position to swap
      * @param j
      *             the second position to swap
      */
     private void swap(int i, int j)
     {
          a.set(j, a.set(i, a.get(j)));
     }

     private ArrayList<Comparable> a;
}
