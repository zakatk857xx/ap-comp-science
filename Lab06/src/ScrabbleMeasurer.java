/**
 * Measures Strings by their Scrabble worth
 * 
 * @author Thomas Zaki
 * @version Nov 21, 2008
 *
 */
public class ScrabbleMeasurer implements Measurer
{
     public double measure(Object w)
     {
          String word = (String) w;
          
          double score = 0;
          
          int numLetters = word.length();
          for(int i = 0; i < numLetters; i++)
               switch (word.toUpperCase().charAt(i))
               {
                    case 'E':
                    case 'A':
                    case 'I':
                    case 'O':
                    case 'N':
                    case 'R':
                    case 'T':
                    case 'L':
                    case 'S':
                    case 'U':
                         score += 1;
                         break;
                    case 'D':
                    case 'G':
                         score += 2;
                         break;
                    case 'B':
                    case 'C':
                    case 'M':
                    case 'P':
                         score += 3;
                         break;
                    case 'F':
                    case 'H':
                    case 'V':
                    case 'W':
                    case 'Y':
                         score += 4;
                         break;
                    case 'K':
                         score += 5;
                         break;
                    case 'J':
                    case 'X':
                         score += 8;
                         break;
                    case 'Q':
                    case 'Z':
                         score += 10;
                         break;                         
               }
          
          return score;
     }

}
