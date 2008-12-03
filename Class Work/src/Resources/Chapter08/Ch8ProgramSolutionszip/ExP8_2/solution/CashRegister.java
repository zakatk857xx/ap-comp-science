/**
   A cash register totals up sales and computes change due.
*/
public class CashRegister
{
   /**
      Constructs a cash register with no money in it.
   */
   public CashRegister()
   {
      purchase = 0;
      payment = 0;
   }

   /**
      Records the sale of an item.
      @param amount the price of the item
   */
   public void recordPurchase(double amount)
   {
      double newTotal = purchase + amount;
      purchase = newTotal;
   }

   /**
      Enters the payment received from the customer.
      @param amount the amount of the payment
   */
   public void enterPayment(double amount)
   {
      payment = amount;
   }

   /**
      Computes the change due.
      @param coinType the type of coins to use when giving change
      @return the number of coins of the given type in the change
   */
   public int giveChange(Coin coinType)
   {
      if (payment <= purchase)
         return 0;

      int change = (int) ((payment - purchase) / coinType.getValue());

      payment = payment - change * coinType.getValue();

      if (payment == purchase)
      {
         payment = 0;
         purchase = 0;
      }

      return change;
   }

   private double purchase;
   private double payment;    
}
