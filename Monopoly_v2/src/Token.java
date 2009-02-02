/**
 * This class is used to keep track of the tokens in the Monopoly
 * game.
 * <p>
 * This version of the stores the names of all the tokens in an
 * array and gives access to which token a player has based on
 * the index.
 * 
 * @author Mr. Kevin Dietzler
 */

import java.util.*;

public class Token
{
   private String tokens [];
   
   /**
    * This default constructor initializes the tokens array to 2 elements.
    */
   public Token ()
   {
      tokens = new String [2];
   }//end default constructor
   
   
   /**
    * This constructor receives an array of Strings which are
    * the names of the tokens.
    * 
    * @param names stores the names of all the tokens.
    */
   public Token (String [] names)
   {
      tokens = new String [names.length];
      
      for (int i = 0; i < names.length; i++)
         tokens [i] = names [i];
   }//end constructor
   
   
   /**
    * This method returns the name of the token specified by
    * index.
    * 
    * @param index the index of the token for which you want the
    * name.
    * @return the name of the specified token.
    */
   public String getTokenName (int index)
   {
      return tokens [index];
   }//end getTokenName method
   
   
   /**
    * This method returns the number of tokens.
    * 
    * @return the number of tokens.
    */
   public int getNumTokens ()
   {
      return tokens.length;
   }//end getNumToken method
   
   
   /**
    * This methods sets the Tokens if they haven't already been set.
    * 
    * @param toks the array of Tokens to be set.
    */
   public void setTokens (String [] toks)
   {
      tokens = (String []) toks.clone();
   }//end setTokens method
   
   
   /**
    * Returns a printable version of this Token's attribute status.
    * 
    * @return a printable version of this Token's attrubute status.
    */
   public String toString ()
   {
      String toks = new String ();
      for (int i = 0; i < tokens.length; i++)
         toks += "[tokens[" + i + "]=" + tokens[i] + "]";
      
      return new String (getClass().getName() + toks);
   }//end toString method

}//end class