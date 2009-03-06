/**
   A class for executing binary searches through an array.
*/
public class BinarySearcher2
{  
   /**
      Constructs a BinarySearcher.
      @param anArray a sorted array of integers
   */
   public BinarySearcher2(int[] anArray)
   {
      a = anArray;
   }
   
   /**
      Finds a value in a sorted array, using the binary
      search algorithm.
      @param v the value to search
      @return the index at which the value occurs, or -1
      if it does not occur in the array
   */
   public int search(int v)
   {  
      int low = 0;
      int high = a.length - 1;
      
      return search(v, low, high);
   }
   
   public int search(int v, int l, int h)
   {  
        int mid = (l + h) / 2;
        int diff = a[mid] - v;
        
        if(l > h)          return -1;
        
        if (diff == 0)      return mid;
        else if (diff < 0)  l = mid + 1;
        else                h = mid - 1;
        
        
        
        return search(v, l,  h);
   }

   private int[] a;
}

