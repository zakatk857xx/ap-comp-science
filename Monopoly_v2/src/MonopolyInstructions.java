public class MonopolyInstructions
{
   /**
    * Displays instructions about rolling the dice.
    */
   public static void rollingTheDice ()
   {
      System.out.println ("\nROLLING THE DIE\n\n\t" +
                          "On each turn, you can choose to roll the dice.\n\t" +
                          "You will roll two " + Monopoly.vars.getNumDiceSides() + "-faced die.  Based upon\n\t" +
                          "the sum of the two values rolled, you will move\n\t" +
                          "forward that many spaces on the board.\n\n\t" +
                          "SEE ALSO: Passing GO and Rolling Doubles");
   }//end rollingTheDie method
   
   
   /**
    * Displays instructions about passing GO.
    */
   public static void passingGO ()
   {
      System.out.println ("\nPASSING GO\n\n\t" +
                          "On every full trip around the board, you are rewarded\n\t" +
                          "with " + Monopoly.vars.getCurrencySymbol() + Monopoly.vars.getGoAmount() + " for passing GO (the starting space).  Also,\n\t" +
                          "if you land exactly on GO you will receive a double\n\t" +
                          "reward of " + Monopoly.vars.getCurrencySymbol() + (2 * Monopoly.vars.getGoAmount()) + ".");
   }//end rollingTheDie method
   
   
   /**
    * Displays instructions about rolling doubles.
    */
   public static void rollingDoubles ()
   {
      System.out.println ("\nROLLING DOUBLES\n\n\t" +
                          "Occasionally, when rolling the dice, both die will have\n\t" +
                          "the same face value (e.g. 4 and 4).  This is called \"Doubles\".\n\t" +
                          "Upon rolling Doubles, you receive a free turn.  Be careful\n\t" +
                          "though; if doubles are rolled on three consecutive turns, you must\n\t" +
                          "proceed directly to jail (space 10) without passing GO and collecting\n\t" +
                          Monopoly.vars.getCurrencySymbol() + Monopoly.vars.getGoAmount() + ".\n\n\t" +
                          "SEE ALSO: Rolling the Dice and Going to Jail");
   }//end rollingDoubles method
   
   
   /**
    * Displays instructions about going to jail.
    */
   public static void goingToJail ()
   {
      System.out.println ("\nGOING TO JAIL\n\n\t" +
                          "Currently there are two ways to be sent to jail.  First, is when\n\t" +
                          "you roll Doubles on three consecutive turns.  The second is when\n\t" +
                          "you land on the GO TO JAIL space (space 30).  In both cases, you\n\t" +
                          "must proceed directly to jail (space 10) without passing GO and \n\t" +
                          "collecting " + Monopoly.vars.getCurrencySymbol() + Monopoly.vars.getGoAmount() + ".\n\n\t" +
                          "SEE ALSO: Rolling Doubles, Getting Out of Jail");
   }//end goingToJail method
   
   
   /**
    * Displays instructions about getting out of jail.
    */
   public static void gettingOutOfJail ()
   {
      System.out.println ("\nGETTING OUT OF JAIL\n\n\t" +
                          "Currently there are two ways to get out of jail.  First, you may\n\t" +
                          "choose to roll for doubles.  If doubles is not rolled your turn\n\t" +
                          "is over and you must wait until your next turn to try again.  After\n\t" +
                          "three failed attempts of rolling doubles, you must pay the " +
                          Monopoly.vars.getCurrencySymbol() + Monopoly.vars.getJailBailFee() +"\n\t" +
                          "fee.  The second option is to pay the " +
                          Monopoly.vars.getCurrencySymbol() + Monopoly.vars.getJailBailFee() +
                          " instead of attempting to roll\n\tdoubles on one of your previous turns.\n\t" +
                          "When you are out of jail, you may either move the number of spaces appearing\n\t" +
                          "on the dice when doubles was rolled or roll the dice if the " +
                          Monopoly.vars.getCurrencySymbol() + Monopoly.vars.getJailBailFee() +
                          " was paid.\n\n\t" +
                          "SEE ALSO: Rolling Doubles, Going to Jail");
   }//end goingToJail method
   
   
   /**
    * Displays instructions about buying property.
    */
   public static void buyingProperty ()
   {
      System.out.println ("\nBUYING PROPERTY\n\n\t" +
                          "Whenever you land on an unowned property you may buy that property\n\t" +
                          "from the Bank at its printed price.  You then become the owner of that\n\t" +
                          "property.  You may choose not to buy an unowned property.\n\n\t" +
                          "SEE ALSO: Paying Rent");
   }//end buyingProperty method
   
   
   /**
    * Displays instructions about paying rent.
    */
   public static void payingRent ()
   {
      System.out.println ("\nPAYING RENT\n\n\t" +
                          "When you land on a property that is owned by another player, the\n\t" +
                          "owner collects rent from you in accordance with that property's basic\n\t" +
                          "rent value.\n\n\t" +
                          "SEE ALSO: Buying Property");
   }//end buyingProperty method
   
   
}//end Instructions class