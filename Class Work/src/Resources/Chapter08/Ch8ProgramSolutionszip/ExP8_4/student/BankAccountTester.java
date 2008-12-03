public class BankAccountTester
{
   public static void main(String[] args)
   {
      try
      {
         BankAccount a = new BankAccount(-1000);
         System.out.println("No assertion error");
      }
      catch (AssertionError e)
      {
         System.out.println("Assertion error");
      }
      System.out.println("Expected: Assertion error");
      
      try
      {
         BankAccount b = new BankAccount(1000);
         b.deposit(-1000);
         System.out.println("No assertion error");
      }
      catch (AssertionError e)
      {
         System.out.println("Assertion error");
      }
      System.out.println("Expected: Assertion error");

      try
      {
         BankAccount c = new BankAccount(1000);
         c.withdraw(2000);
         System.out.println("No assertion error");
      }
      catch (AssertionError e)
      {
         System.out.println("Assertion error");
      }
      System.out.println("Expected: Assertion error");

      try
      {
         BankAccount d = new BankAccount(1000);
         d.deposit(1000);
         d.withdraw(2000);         
         System.out.println("No assertion error");
      }
      catch (AssertionError e)
      {
         System.out.println("Assertion error");
      }
      System.out.println("Expected: No assertion error");
   }
}
