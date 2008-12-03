/**
   A bank account has a balance that can be changed by deposits and withdrawals.
 */
 public class BankAccount
 {
   /**
      Constructs a bank account with a zero balance.
   */
   public BankAccount()
   {
      balance = 0;
   }

   /**
      Constructs a bank account with a given balance.
      @param initialBalance the initial balance
      (Precondition: initialBalance >= 0)
   */
   public BankAccount(double initialBalance)
   {
      assert initialBalance > 0;
      balance = initialBalance;
   }

   /**
      Deposits money into the bank account.
      @param amount the amount to deposit
      (Precondition: amount >= 0)
   */
   public void deposit(double amount)
   {
      assert amount >= 0;
      double newBalance = balance + amount;
      balance = newBalance;
   }

   /**
      Withdraws money from the bank account.
      @param amount the amount to withdraw
      (Precondition: amount <= getBalance())
   */
   public void withdraw(double amount)
   {
      assert 0 <= amount && amount <= balance;
      double newBalance = balance - amount;
      balance = newBalance;
   }

   /**
      Gets the current balance of the bank account.
      @return the current balance
   */
   public double getBalance()
   {
      return balance;
   }

   private double balance;
}
