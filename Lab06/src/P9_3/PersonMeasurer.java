package P9_3;

public class PersonMeasurer implements Measurer
{
     public double measure(Object anObject)
     {          
          return ((Person) anObject).getHeight();
     }

}
