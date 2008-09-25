/**
 * Car class
 * @author tzaki
 * @version Sep 19, 2008
 */
public class Car
{
     private double efficency, tankSize, gas;
     
     /**
      * Creates a new Car with an empty 40 gallon fuel 
      *   tank and a specified fuel efficiency
      * @param milesPerGalllon
      */
     public Car(double milesPerGalllon)
     {
          efficency = milesPerGalllon;
          tankSize = 40;
          gas = 0;
     }
     
     /**
      * Creates a new Car with an empty fuel tank of a 
      *   specified size and a specified fuel efficiency
      * @param milesPerGalllon
      * @param size the size of the tank
      */
     public Car(double milesPerGalllon, double size)
     {
          efficency = milesPerGalllon;
          tankSize = size;
          gas = 0;
     }
     
     /**
      * Adds enough gas to fill the gas tank
      */
     public void fillTank()
     {
          gas = tankSize;
     }
     
     /**
      * Fills the tank with specified amount of gas
      * @param gallons number of gallons to add to the tank
      */
     public void addGas(double gallons)
     {
          gas += gallons;
          
          if(gas > tankSize)
               gas = tankSize;
     }
     
     /**
      * Simulates driving the car
      * @param miles number of miles to drive the car
      */
     public void drive(double miles)
     {
          double maxDrive = gas * efficency;
          if(miles > maxDrive)
               gas = 0;
          else
               gas -= miles / efficency;
     }
     
     /**
      * Checks amount of gas left in the tank
      * @return the amount of gas in tank
      */
     public double gasInTank()
     {
          return gas;
     }
}