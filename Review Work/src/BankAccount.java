/*
 * The layout for writing an object class
 */

public class BankAccount
{
     // Instance Fields (and public static variables - constants)
     private double balance;

     /*
      * Default Constructor
      */
     public BankAccount()
     {
          balance = 0;
     }

     /*
      * Constructor for balance with initial deposit
      */
     public BankAccount(double b)
     {
          balance = b;
     }
     
     //Methods
     public double getBalance()
     {
          return balance;
     }
     
     public void deposit(double amt)
     {
          balance += amt;
     }
     
     public double withdraw(double amt)
     {
          balance -= amt;
          return amt;
     }
}
