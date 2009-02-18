import java.util.*;

public class Reverse
{
     public static void main(String [] args)
     {
          System.out.println(reverse1("Hello!"));
          System.out.println(reverse2("Hello!"));          
          System.out.println(reverse2(reverse1("Hello!")));
          
          int s, e;
          String w = new String();
          
          Scanner in = new Scanner(System.in);
          System.out.print("Enter a string: ");
          w = in.nextLine();
          System.out.print("Enter start index: ");
          s = in.nextInt();
          System.out.print("Enter end index: ");
          e = in.nextInt();
          System.out.println(reverse3(w, s, e));
          
          
     }     
     public static String reverse1(String s)
     {
          if(s.length() == 1) return s;
          return reverse1(s.substring(1)) + s.charAt(0);
     }       
     public static String reverse2(String s)
     {
          String sN = new String();
          
          for(int i = 0; i < s.length(); i++)
               sN = s.charAt(i) + sN;
          
          return sN;
     }    
     public static String reverse3(String s, int start, int end)
     {
          return s.substring(0, start) + reverse1(s.substring(start, end)) + s.substring(end);
     } 
}