public class Car
{
     private double efficency, tankSize, gas;
     
     public Car(double e)
     {
          efficency = e;
          tankSize = 40;
          gas = 0;
     }
     
     public Car(double e, double s)
     {
          efficency = e;
          tankSize = s;
          gas = 0;
     }
     
     public void fillTank()
     {
          gas = tankSize;
     }
     
     public void addGas(double gal)
     {
          gas += gal;
          
          if(gas > tankSize)
               gas = tankSize;
     }
     
     public void drive(double miles)
     {
          double maxDrive = gas * efficency;
          if(miles > maxDrive)
               gas = 0;
          else
               gas -= miles / efficency;
     }
     
     public double gasInTank()
     {
          return gas;
     }
}
