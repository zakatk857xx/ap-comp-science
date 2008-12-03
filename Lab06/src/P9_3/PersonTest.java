package P9_3;

public class PersonTest
{
     public static void main(String[] args)
     {
          PersonMeasurer measurer = new PersonMeasurer();
          DataSet data = new DataSet(measurer);
          
          //2.54cm = 1 inch (the definition of an inch - ANSI)          
          data.add(new Person("Tom   ", 2.54 * 72));
          data.add(new Person("Bob   ", 2.54 * 80));
          data.add(new Person("Jim   ", 2.54 * 70));
          data.add(new Person("Ann   ", 2.54 * 69));
          data.add(new Person("Sally ", 2.54 * 65));
          data.add(new Person("Beth  ", 2.54 * 66));
          data.add(new Person("Mike  ", 2.54 * 73));
          data.add(new Person("Sue   ", 2.54 * 67));
          data.add(new Person("John  ", 2.54 * 71));
          data.add(new Person("Paul  ", 2.54 * 69));
          data.add(new Person("Ringo ", 2.54 * 68));
          data.add(new Person("George", 2.54 * 72));
          
          System.out.println("Average Height: " 
                    + Math.round(data.getAverage() * 100) / 100.0 + "cm");
          System.out.println("Tallest:  " 
                    + ((Person)data.getMaximum()).getName() 
                    + " (" + ((Person)data.getMaximum()).getHeight() + ")");
          System.out.println("Shortest: " 
                    + ((Person)data.getMinimum()).getName() 
                    + " (" + ((Person)data.getMinimum()).getHeight() + ")");
          
          System.out.println(((Person)data.getMaximum()).getName().trim() 
                    + " is taller than " 
                    + ((Person)data.getMinimum()).getName().trim());          
     }
}
