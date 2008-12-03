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
      Enters the payment received from the customer; should be called once
      for each monetary unit type
      @param unitCount the number of monetary units
      @param unitType the type of the monetary units in the payment
   */
   public void enterPayment(int unitCount, MonetaryUnit unitType)
   {
      payment  = payment + unitCount * unitType.getValue();
   }

   /**
      Computes the change due and resets the machine for the next customer.
      @return the change due to the customer
   */
   public double giveChange()
   {
      double change = payment - purchase;
      purchase = 0;
      payment = 0;
      return change;
   }    

   private double purchase;
   private double payment;    
}
