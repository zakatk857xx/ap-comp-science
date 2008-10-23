/**
 * 
 * @author tzaki
 * @version Oct 22, 2008
 *
 * a loop that reads 10 strings and inserts them into an array list. 
 * a second loop that prints out the string in the opposite order from which they were entered.
 *
 */

import java.util.*;

public class StringList
{
     public static void main(String beans[])
     {
          ArrayList<String> words = new ArrayList<String> ();
          
          Scanner in = new Scanner(System.in);
          
          for(int i = 0; i < 10; i++)
               words.add(in.nextLine());
          
          for(int i = 9; i >= 0; i--)
               System.out.println(words.remove(i));
     }//end main
}//end class
