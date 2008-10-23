package exercise_3;

public class Card
{
     private String suit;
     private String value;

     public Card()
     {}

     public Card(String n)
     {
          if(n.length() > 3)
               if (!Character.isDigit(n.charAt(1)))
                    n = n.substring(0, 2);
               else
                    n = n.substring(0, 3);              
          
          this.readValue(n);
          this.readSuit(n);
     }

     private void readValue(String n)
     {
          //finds number of card (if is number) or letter (if is letter)
          if (Character.isDigit(n.charAt(0)))
          {
               if (Character.isDigit(n.charAt(1)) && Integer.parseInt(n.substring(0, 2)) == 10)
                    value = n.substring(0, 2);
               else if (Integer.parseInt(n.substring(0, 1))  >= 2 && Integer.parseInt(n.substring(0, 1))  <= 9)
                    value = n.substring(0, 1);
               else
                    value = "unknown";
          }
          else
          {
               switch (Character.toUpperCase(n.charAt(0)))
               {
                    case 'J':
                         value = "Jack";
                         break;
                    case 'Q':
                         value = "Queen";
                         break;
                    case 'K':
                         value = "King";
                         break;
                    case 'A':
                         value = "Ace";
                         break;
                    default:
                         value = "unknown";
               }// end switch

          }// end else

     }// end readValue

     private void readSuit(String n)
     {
          switch (Character.toUpperCase(n.charAt(n.length() - 1)))//reads the last character of the input
          {
               case 'D':
                    suit = "Diamond";
                    break;
               case 'H':
                    suit = "Heart";
                    break;
               case 'S':
                    suit = "Spade";
                    break;
               case 'C':
                    suit = "Club";
                    break;
               default:
                    suit = "unknown";
          }
     }
     
     public String toString()
     {
          return value + " of " + suit + "s";
     }

}
