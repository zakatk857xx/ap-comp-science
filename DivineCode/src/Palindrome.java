
public class Palindrome
{
     public static void main(String [] args)
     {
          word = "a man a plan a canal Panama";
          
          System.out.println(isPalindrome(word, 0, word.length() - 1));
     }
     
     public static boolean isPalindrome(String w, int start, int end)
     {
          if(start >= end) return true;
          
          char first = Character.toUpperCase(w.charAt(start));
          char last  = Character.toUpperCase(w.charAt(end));
          
          if(Character.isLetter(first) && Character.isLetter(last))
          {
               if(first == last)
                    return isPalindrome(w, start+1, end-1);
               else
                    return false;
          }
          
          while(!Character.isLetter(first))
          {
               start++;
               first = Character.toUpperCase(w.charAt(start));
          }
          while(!Character.isLetter(last))
          {
               end--;
               last = Character.toUpperCase(w.charAt(end));
          }

          return isPalindrome(w, start+1, end-1);
     }
     
     private static String word;
}
