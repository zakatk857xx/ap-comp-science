/************************************************************************
  * 
  *       Introduction to Programming
  *       Name: Mr. Dietzler
  *       Date: 2-6-07
  *       Title: TicTacToeTester.java
  *       Description: Simulates the game of tic-tac-toe using a 
  *                        2-d array as the board.
  *       Input: chars
  *       Output: whether a player won or lost.
  * 
  *************************************************************************/

import java.util.Random;
import java.util.Scanner;

class TicTacToeTester
{
     public static void main (String args[])
     {
          Scanner in = new Scanner (System.in);
          
          //initialize the board
          TicTacToe game = new TicTacToe();
          
          // These two ints will help determine who will go first.
          int headTail, goFirst = -1;
          
          // These String handle the game playing process.
          String winner, turn = "-", playAgain = "-";
          
          boolean whoseTurn; //true means it is player 1's turn
          // and false means player 2
          
          boolean stillPlay = true; //controls when to leave the
          // game
          
          // Random number generator to determine who goes first.
          Random gen = new Random ();
          
          
          // Here's where the game begins.  Loop until the player
          // chooses to leave the game.
          while (stillPlay)
          {
               TwoPlayers players = new TwoPlayers ();
               
               // Set the welcome message on the board.
               game.setWelcomeBoard ();
               
               // Print the welcome board.
               System.out.println ("\n\n\n Welcome to\n" + game);
               
               // Reinitialize the board to be blank.
               game.initializeBoard ();
               
               // Get the players' names.
               System.out.print ("Player 1 please enter your first name: ");
               players.setP1Name (in.next());
               
               System.out.print ("Player 2 please enter your first name: ");
               players.setP2Name (in.next());
               
               
               // Determine who will go first.
               System.out.print ("\n\nWe will flip a binary-coin to see who will " +
                                 "go first.\n" + players.getP1Name () + ", enter 0 " +
                                 "for heads or 1 for tails: ");
               headTail = gen.nextInt (2);
               
               
               goFirst = -1;
               while (goFirst < 0 || goFirst > 1)
               {
                    goFirst = in.nextInt ();
                    
                    if (goFirst < 0 || goFirst > 1)
                         System.out.print ("Invalid entry.\n" + players.getP1Name () + ", enter 0" +
                                           " for heads or 1 for tails: ");
               }
               
               System.out.println (getHeadsOrTails (headTail) +
                                   " was flipped. ");
               if (goFirst == headTail)
               {
                    System.out.println (players.getP1Name () + " will go first and " +
                                        "will be " + TicTacToe.X + "s.");
                    players.setP1Piece ();
                    whoseTurn = true;
               }
               else
               {
                    System.out.println (players.getP2Name () + " will go first and " +
                                        "will be " + TicTacToe.X + "s");
                    players.setP2Piece ();
                    whoseTurn = false;
               }
               
               //loop until a player wins
               do 
               {
                    System.out.println ("Please hit enter to continue...");
                    in.nextLine();
                    
                    if (whoseTurn)
                    {
                         //call the takeTurn method based on whose turn it is.
                         takeTurn (players.getP1Name(), players.getP1Piece(), game);
                         whoseTurn = false;
                    }
                    else
                    {
                         takeTurn (players.getP2Name(), players.getP2Piece(), game);
                         whoseTurn = true;
                    }
                    
                    System.out.println ("\n\nHere is how the board currently looks:\n" + game);
                    
                    
                    winner = game.checkBoard();
               }//end do to keep entering pieces
               while (winner.equals("N"));
               
               if (winner.equals(players.getP1Piece()))
                    System.out.println (players.getP1Name () + " is the winner");
               else if (winner.equals(players.getP2Piece()))
                    System.out.println (players.getP2Name() + " is the winner");
               else
                    System.out.println ("A draw has occured and there is no winner.");
               
               playAgain = "-";
               while (!playAgain.equals("y") && !playAgain.equals("n"))
               {
                    System.out.print ("Would you like to play again? (y or n):");
                    playAgain = in.next().toLowerCase ();
                    
                    if (!playAgain.equals("y") && !playAgain.equals("n"))
                         System.out.println ("Invalid input.  Please try again");
               } // end while
               
               if (playAgain.equals("y"))
                    stillPlay = true;
               else
                    stillPlay = false;
               
          }//end do
          while (stillPlay);
          
     } //end main method
     
     
     public static void takeTurn (String name, String piece, TicTacToe game)
     {
          Scanner in = new Scanner (System.in);
          
          int row = -1, column = -1;
          boolean spaceAvailable = true;
          
          //Loop until the player chooses a valid space on the board
          do
          {
               row = -1;
               column = -1;
               System.out.println ("\n\n" + name + ", it is your turn.");
               System.out.println ("What row would you like to place your " + piece +
                                   " in?");
               
               while (row < 1 || row > 3)
               {
                    System.out.print (game.getBoardOutputRows () + 
                                      "\n\nRow: ");
                    row = in.nextInt();
                    if (row < 1 || row > 3)
                         System.out.println ("You have entered an invalid number of rows." + 
                                             " Please enter again.");
               }
               
               while (column < 1 || column > 3)
               {
                    System.out.print (game.getBoardOutputColumns () + 
                                      "\n\nColumn: ");
                    column = in.nextInt ();
                    if (column < 1 || column > 3)
                         System.out.println ("You have entered an invalid number of columns." + 
                                             " Please enter again.");
               }
               
               spaceAvailable = game.setPiece (piece, row, column);
               
               if (!spaceAvailable)
                    System.out.println ("That space is taken.  Please try again.");
          } // end do
          while (!spaceAvailable);
          
     } // end takeTurn method
     
     
     
     public static String getHeadsOrTails (int ht)
     {
          if (ht == 0)
          {
               return "Heads";
          }
          else
          {
               return "Tails";
          }
     } // end getHeadsOrTails method
     
} // end TicTacToe method