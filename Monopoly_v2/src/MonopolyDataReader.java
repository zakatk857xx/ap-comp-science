/**
 * Reads a data for a Monopoly game from a file
 *
 * @author Mr. Kevin Dietzler
 */

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class MonopolyDataReader
{
   /**
    * A Monopoly data file should be separated into three sections:
    * <p>
    * 1: Monopoly variable data<br>
    * 2: Monopoly token data<br>
    * 3: Monopoly property data<br>
    * 
    * @param filename the name of the file holding the data
    * @param vars the MonopVars object for the game
    * @param tokens the Token object for the game
    * @param properties the ArrayList to which properties should be added
    */
   public void readMonopolyFile (String filename, MonopVars vars, Token tokens,
                         ArrayList<Property> properties) 
      throws IOException, BadDataException
   {
      FileReader reader = new FileReader (filename);
      try
      {
         Scanner in = new Scanner(reader);
         readVarsData(in, vars);
         in.nextLine();
         readTokenData(in, tokens);
         in.nextLine();
         readPropertyData(in, properties);

         if (in.hasNext())
            throw new BadDataException ("End of file expected");
      }
      finally
      {
         reader.close();
      }
      
   }//end readMonopolyFile method
   
   
   /**
    * Reads the set of data for the MonopVars object<br>
    * <p>
    * Format for a MonopVars data should appear as follows:<br>
    * *game name* - String<br>
    * *currency symbol* - String<br>
    * (All the following ints appear on the same line)<br>
    * *go amount* *starting money amount* *jail bail fee* *number of dice sides* - all ints<br>
    * *monopoly color #1* - String<br>
    * *monopoly color #2* - String<br>
    * ...<br>
    * *monopoly color #8* - String
    * 
    * @param in the scanner that scans the data
    * @param vars the MonopVars object
    */
   public void readVarsData (Scanner in, MonopVars vars)
      throws BadDataException
   {
      String version, curSymbol;
      int goAmount, startAmount, jailBailFee, numDiceSides;
      String [] colors = new String [8];
      
      if (!in.hasNextLine())
         throw new BadDataException("Missing version name");
      else
         version = in.nextLine();
      
      vars.setVersion (version);
      
      if (!in.hasNextLine())
         throw new BadDataException("Missing currency symbol");
      else
         curSymbol = in.nextLine();
      
      vars.setCurrencySymbol (curSymbol);
      
      if(!in.hasNextInt())
         throw new BadDataException("Missing the amount for passing go.");
      else
         goAmount = in.nextInt();
      
      vars.setGoAmount (goAmount);
      
      if(!in.hasNextInt())
         throw new BadDataException("Missing the amount of money a player starts with.");
      else
         startAmount = in.nextInt();
      
      vars.setStartingMoneyAmount (startAmount);
      
      if(!in.hasNextInt())
         throw new BadDataException("Missing the amount for the fee to get out of jail.");
      else
         jailBailFee = in.nextInt();
      
      vars.setJailBailFee (jailBailFee);
      
      if(!in.hasNextInt())
         throw new BadDataException("Missing the number of sides for the dice.");
      else
         numDiceSides = in.nextInt();
      
      vars.setNumDiceSides (numDiceSides);
      
      in.nextLine();
      
      for (int i = 0; i < colors.length; i++)
      {
         if(!in.hasNextLine())
            throw new BadDataException("Missing the " + (i + 1) + "" +
                                       Monopoly.getSuffix(i + 1) + " Monopoly color.");
         else
            colors[i] = new String (in.nextLine());
      }//end for
   
      vars.setMonopolyColors (colors);

   }//end readVarsData method
   
   
   /**
    * Reads the set of data for the Tokens object.
    * <p>
    * Token information should be in the following format:<br>
    * *number of tokens (min. 2)* - int<br>
    * *token #1* - String<br>
    * *token #2* - String<br>
    * ...<br>
    * *token #n* - String
    * 
    * @param in the scanner that scans the data
    * @param tokens the Token object.
    */
   public void readTokenData (Scanner in, Token tokens)
      throws BadDataException
   {
      int numTokens;
      String [] toks;
      
      if (!in.hasNextInt())
         throw new BadDataException("Number of tokens expected");
      else
         numTokens = in.nextInt();
      
      in.nextLine();
      
      toks = new String [numTokens];
      
      for (int i = 0; i < toks.length; i++)
      {
         if (!in.hasNextLine())
            throw new BadDataException("Missing the " + (i+1) + "" +
                                                     Monopoly.getSuffix(i+1) +
                                                     " token.");
         else
            toks[i] = in.nextLine();
      }//end for
      
      tokens.setTokens (toks);
      
   }//end readTokensData method
   
   
   /**
    * Reads the set of Property data for the
    * properties ArrayList.
    * <p>
    * See the getType() method of the Property class 
    * 
    * @param in the scanner that scans the data
    * @param properties the ArrayList of Property objects.
    */
   public void readPropertyData (Scanner in,
                               ArrayList<Property> properties)
      throws BadDataException
   {
      int type;
      Property nextProperty;
      
      //There are ALWAYS 40 spaces on a Monopoly board
      for (int index = 0; index < 40; index++)
      {
         if (!in.hasNext())
            throw new BadDataException("Missing property number " +
                                       (index + 1));
         else if (!in.hasNextInt())
            throw new BadDataException("Property type expected");
         else
         {
            type = in.nextInt();
            in.nextLine();
         }
         
         //Determine which property type this is
         //(see the getType() method of the Property class)
         //A Monopoly property
         if (type == 1)
            nextProperty = readMonopolyProperty (in, type, index);
         //A Railroad Property
         else if (type == 2)
            nextProperty = readRailroadProperty (in, type, index);
         //A Utility Property
         else if (type == 3)
            nextProperty = readUtilityProperty (in, type, index);
         else if (type > 3 && type < 12)
            nextProperty = readProperty (in, type, index);
         else
            throw new BadDataException ("Invalid property type.");
         
         properties.add (nextProperty);
      }//end for

   }//end readPropertyData method
   
   
   /**
    * Reads the set of Property data for a Property of
    * type MonopolyProperty.
    * <p>
    * Monopoly properties should appear in this format:<br>
    * *property type* - int (see Property class)<br>
    * *property name* - String<br>
    * (all on same line in this order separated by spaces)
    * *cost* *mortgage* *index of Monopoly color* *basic rent* *rent w/1 house* *rent w/2houses* *rent w/3houses* *rent w/4houses* *rent w/hotel* *building cost* - all ints
    * 
    * @param in the scanner that scans the data
    * @param type the type of Property this is.
    * @param index the index of this Property on the board.
    */
   public Property readMonopolyProperty (Scanner in, int type, int index)
      throws BadDataException
   {
      String name;
      int cost, mortgage, colorIndex, basicRent, oneHouseRent, twoHouseRent,
          threeHouseRent, fourHouseRent, hotelRent, buildingCost;
      
      //Check for and receive the property name
      if (!in.hasNextLine())
         throw new BadDataException("Missing property name");
      else
         name = in.nextLine();
      
      //Check for and receive the cost
      if (!in.hasNextInt())
         throw new BadDataException("Missing property cost");
      else
         cost = in.nextInt();
      
      //Check for and receive the mortgage
      if (!in.hasNextInt())
         throw new BadDataException("Missing property mortgage");
      else
         mortgage = in.nextInt();
      
      //Check for and receive the index of the Monopoly color
      if (!in.hasNextInt())
         throw new BadDataException("Missing index (0 - 7) of the property's color");
      else
         colorIndex = in.nextInt();
      
      //Check for and receive the basic rent
      if (!in.hasNextInt())
         throw new BadDataException("Missing basic rent");
      else
         basicRent = in.nextInt();
      
      //Check for and receive the rent with one house
      if (!in.hasNextInt())
         throw new BadDataException("Missing rent with one house amount");
      else
         oneHouseRent = in.nextInt();
      
      //Check for and receive the rent with two houses
      if (!in.hasNextInt())
         throw new BadDataException("Missing rent with two houses amount");
      else
         twoHouseRent = in.nextInt();
      
      //Check for and receive the rent with three houses
      if (!in.hasNextInt())
         throw new BadDataException("Missing rent with three houses amount");
      else
         threeHouseRent = in.nextInt();
      
      //Check for and receive the rent with four houses
      if (!in.hasNextInt())
         throw new BadDataException("Missing rent with four houses amount");
      else
         fourHouseRent = in.nextInt();
      
      //Check for and receive the rent with a hotel
      if (!in.hasNextInt())
         throw new BadDataException("Missing rent with one a hotel amount");
      else
         hotelRent = in.nextInt();
      
      //Check for and receive the building cost
      if (!in.hasNextInt())
         throw new BadDataException("Missing building cost amount");
      else
         buildingCost = in.nextInt();
      
      
      return new MonopolyProperty (name, type, index, cost, mortgage,
                                   colorIndex, basicRent, oneHouseRent,
                                   twoHouseRent, threeHouseRent,
                                   fourHouseRent, hotelRent, buildingCost);

   }//end readMonopolyPropertyData method
   
   
   /**
    * Reads the set of Property data for a Property of
    * type RailroadProperty.
    * <p>
    * Railroads & Utilities should appear in this format:<br>
    * *property type* - int (see Property class)<br>
    * *name of railroad/utility* - String<br>
    * (both variables below are on the same line)<br>
    * *cost* *mortgage* - both ints
    * 
    * @param in the scanner that scans the data
    * @param type the type of Property this is.
    * @param index the index of this Property on the board.
    */
   public Property readRailroadProperty (Scanner in, int type, int index)
      throws BadDataException
   {
      String name;
      int cost, mortgage;
      
      //Check for and receive the property name
      if (!in.hasNextLine())
         throw new BadDataException("Missing property name");
      else
         name = in.nextLine();
      
      //Check for and receive the cost
      if (!in.hasNextInt())
         throw new BadDataException("Missing property cost");
      else
         cost = in.nextInt();
      
      //Check for and receive the mortgage
      if (!in.hasNextInt())
         throw new BadDataException("Missing property mortgage");
      else
         mortgage = in.nextInt();
      
      System.out.println("HERE!!");
      
      return new RailroadProperty (name, type, index, cost, mortgage);
   }//end readRailroadPropertyData method
   
   
   /**
    * Reads the set of Property data for a Property of
    * type UtilityProperty.
    * <p>
    * Railroads & Utilities should appear in this format:<br>
    * *property type* - int (see Property class)<br>
    * *name of railroad/utility* - String<br>
    * (both variables below are on the same line)<br>
    * *cost* *mortgage* - both ints
    * 
    * @param in the scanner that scans the data
    * @param type the type of Property this is.
    * @param index the index of this Property on the board.
    */
   public Property readUtilityProperty (Scanner in, int type, int index)
      throws BadDataException
   {
      String name;
      int cost, mortgage;
      
      //Check for and receive the property name
      if (!in.hasNextLine())
         throw new BadDataException("Missing property name");
      else
         name = in.nextLine();
      
      //Check for and receive the cost
      if (!in.hasNextInt())
         throw new BadDataException("Missing property cost");
      else
         cost = in.nextInt();
      
      //Check for and receive the mortgage
      if (!in.hasNextInt())
         throw new BadDataException("Missing property mortgage");
      else
         mortgage = in.nextInt();
      
      
      System.out.println("HERE!!");
      
      return new UtilityProperty (name, type, index, cost, mortgage);
   }//end readUtilityPropertyData method
   
   
   /**
    * Reads the set of Property data for a regular Property.
    * <p>
    * All other properties should appear in this format:<br>
    * *property type* - int (see Property class)<br>
    * *property name* - String
    * 
    * @param in the scanner that scans the data
    * @param type the type of Property this is.
    * @param index the index of this Property on the board.
    */
   public Property readProperty (Scanner in, int type, int index)
      throws BadDataException
   {
      String name;
      
      //Check for and receive the property name
      if (!in.hasNextLine())
         throw new BadDataException("Missing property name");
      else
         name = in.nextLine();
      
      System.out.println("HERE!!");
      
      return new Property (name, type, index);
   }//end readRegularProperty method
   
   
   
}//end MonopolyDataReader class