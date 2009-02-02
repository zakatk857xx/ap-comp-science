/*
 * This class is used to create static variables that can
 * be used in the game of Monopoly.
 * 
 * @author Mr. Kevin Dietzler
 */
class MonopVars
{
   private String version;
   private String currencySymbol;
   private int goAmount;
   private int startingMoneyAmount;
   private int jailBailFee;
   private int numDiceSides;
   private String [] monopolyColors;
   
   /**
    * This default constructor initalizes all the attributes.
    */
   public MonopVars ()
   {
      version = new String();
      currencySymbol = new String();
      goAmount = 0;
      startingMoneyAmount = 0;
      jailBailFee = 0;
      numDiceSides = 0;
      monopolyColors = new String [8];
   }//end default constructor
   
   
   /**
    * This constructor can be used when the original values
    * are known upon initialization.
    * 
    * @param v the name for this version of Monopoly
    * @param cS the currenct symbol
    * @param gA the amount for passing go
    * @param sMA the starting amount of money for a player
    * @param jBF the fee a player must pay to get out of jail
    * @param nDS the number of sides on the dice
    * @param colors the array of Monopoly colors for this game
    */
   public MonopVars (String v, String cS, int gA, int sMA, int jBF, int nDS,
   String [] colors)
   {
      version = new String(v);
      currencySymbol = new String(cS);
      goAmount = gA;
      startingMoneyAmount = sMA;
      jailBailFee = jBF;
      numDiceSides = nDS;
      monopolyColors = (String[])colors.clone ();
   }//end constructor
   
   
   /**
    * This method returns the name of this version of Monopoly.
    * 
    * @return the name of this Monopoly version 
    */
   public String getVersion ()
   {
      return version;
   }//end getVersion
   
   
   /**
    * This method sets the name of this version of Monopoly.
    * 
    * @param v the name of this Monopoly version 
    */
   public void setVersion (String v)
   {
      version = new String (v);
   }//end setVersion
   
   
   /**
    * This method returns the currency symbol used in this
    * version of Monopoly.
    * 
    * @return currency symbol for the current version of Monopoly 
    */
   public String getCurrencySymbol ()
   {
      return currencySymbol;
   }//end getCurrencySymbol
   
   
   /**
    * This method sets the currency symbol used in this
    * version of Monopoly.
    * 
    * @param cS currency symbol for the current version of Monopoly 
    */
   public void setCurrencySymbol (String cS)
   {
      currencySymbol = cS;
   }//end setCurrencySymbol
   
   
   /**
    * This method returns the amount of money received for passing
    * GO in this version of Monopoly.
    * 
    * @return the amount for passing go in this Monopoly version 
    */
   public int getGoAmount ()
   {
      return goAmount;
   }//end getGoAmount
   
   
   /**
    * This method sets the amount of money received for passing
    * GO in this version of Monopoly.
    * 
    * @param gA the amount for passing go in this Monopoly version 
    */
   public void setGoAmount (int gA)
   {
      goAmount = gA;
   }//end setGoAmount
   
   
   /**
    * This method returns the starting amount of money for
    * this version of Monopoly.
    * 
    * @return the amount of money a player starts with for
    * this Monopoly version 
    */
   public int getStartingMoneyAmount ()
   {
      return startingMoneyAmount;
   }//end getStartingMoneyAmount
   
   
   /**
    * This method sets the starting amount of money for
    * this version of Monopoly.
    * 
    * @param sMA the amount of money a player starts with for
    * this Monopoly version 
    */
   public void setStartingMoneyAmount (int sMA)
   {
      startingMoneyAmount = sMA;
   }//end setStartingMoneyAmount
   
   
   /**
    * This method returns the amount of the fee to get out of jail.
    * 
    * @return the jail bail fee for this Monopoly version 
    */
   public int getJailBailFee ()
   {
      return jailBailFee;
   }//end getJailBailFee
   
   
   /**
    * This method sets the amount of the fee to get out of jail.
    * 
    * @param jBF the jail bail fee for this Monopoly version 
    */
   public void setJailBailFee (int jBF)
   {
      jailBailFee = jBF;
   }//end setJailBailFee
   
   
   /**
    * This method returns the number of sides on the dice for this
    * version of Monopoly.
    * 
    * @return the number of sides on the dice for this version of
    * Monopoly
    */
   public int getNumDiceSides ()
   {
      return numDiceSides;
   }//end getNumDiceSides
   
   
   /**
    * This method sets the number of sides on the dice for this
    * version of Monopoly.
    * 
    * @param nDS the number of sides on the dice for this
    * version of Monopoly 
    */
   public void setNumDiceSides (int nDS)
   {
      numDiceSides = nDS;
   }//end setNumDiceSides
   
   
   /**
    * This method returns the Monopoly color specified by the index i.
    * 
    * @param index the index of the color to be obtained
    * @return the color contained at index
    */
   public String getMonopolyColor (int index)
   {
      return monopolyColors[index];
   }//end getMonopolyColor
   
   
   /**
    * This method sets the entire monopolyColors array.
    * 
    * @param colors an array of the Monopoly colors for this version. 
    */
   public void setMonopolyColors (String [] colors)
   {
      monopolyColors = (String[]) colors.clone();
   }//end setMonopolyColor
   
   
   /**
    * Returns a printable version of this MonopVar's attribute status.
    * 
    * @return a printable version of this MonopVar's attrubute status.
    */
   public String toString ()
   {
      String colors = new String ();
      for (int i = 0; i < monopolyColors.length; i++)
         colors += "[monopolyColors[" + i + "]=" + monopolyColors[i] + "]";
      
      return new String (getClass().getName() +
                         "[version=" + getVersion() + "]" +
                         "[currencySymbol=" + getCurrencySymbol() + "]" +
                         "[goAmount=" + getGoAmount() + "]" +
                         "[startingMoneyAmount=" +
                         getStartingMoneyAmount() + "]" +
                         "[jailBailFee=" +
                         getJailBailFee() + "]" +
                         "[numDiceSides=" +
                         getNumDiceSides() + "]" +
                         colors);
      
   }//end toString method
   
}//end MonopVars class