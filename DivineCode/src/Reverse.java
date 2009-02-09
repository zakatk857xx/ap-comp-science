public class Reverse
{
     public static void main(String [] args)
     {
          System.out.println(reverse1("Hello!"));
          System.out.println(reverse2("Hello!"));          
          System.out.println(reverse2(reverse1("Hello!")));
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
}