/************************************************************************
* 
*       Introduction to Programming
*       Name: Mr. Dietzler
*       Date: 2/6/07
*       Title: TwoPlayers.java
*       Description: Stores information for two player names in
*                     addition to a String version of a piece or
*                     color.
*       This class is ideal for Tic-Tac-Toe, Checkers and Chess.
* 
*************************************************************************/

public class TwoPlayers
{
    private String player1Name;
    private String player2Name;
    private String player1Piece;
    private String player2Piece;
    
    TwoPlayers ()
    {
        player1Name = new String ("Player 1");
        player2Name = new String ("Player 2");
    }//end default constructor
    
    
    TwoPlayers (String n1, String n2)
    {
        player1Name = n1;
        player2Name = n2;
    }//end constructor
    
    
    public void setP1Name (String n)
    {
        if (n.equals (""))
            player1Name = "Player 1";
        else
            player1Name = n;
        
        return;
    }//end setP1Name method
    
    
    public String getP1Name ()
    {
        return player1Name;
    }//end getP1Name method
        
    
    public void setP2Name (String n)
    {
        if (n.equals (""))
            player2Name = "Player 2";
        else
            player2Name = n;
        
        return;
    }//end setP2Name
    
    
    public String getP2Name ()
    {
        return player2Name;
    }//end getP2Name
        
    /*
     * If this method is called, it means that player 1
     * chose to be X's.
     */
    public void setP1Piece ()
    {
        player1Piece = TicTacToe.X;
        player2Piece = TicTacToe.O;
        
        return;
    }//end setP1Piece method
    
    
    public String getP1Piece ()
    {
        return player1Piece;
    }//end getP1Piece method
        
    
    public void setP2Piece ()
    {
        player2Piece = TicTacToe.X;
        player1Piece = TicTacToe.O;
        
        return;
    }//end setP2Piece method
    
    
    public String getP2Piece ()
    {
        return player2Piece;
    }//end getP2Piece method

    
    public String toString()
    {
         return new String (
                            "Player 1:\n" +
                            "\tName: " + player1Name +
                            "\nPiece: " + player1Piece +
                            "Player 2:\n" +
                            "\tName: " + player2Name +
                            "\nPiece: " + player2Piece);
    }//end toString method
}
    