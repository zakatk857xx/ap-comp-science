import java.awt.Rectangle;

/**
   This program demonstrates the use of an inner class.
*/
public class DataSetTester3
{
   public static void main(String[] args)
   {
      class RectangleMeasurer implements Measurer
      {
         public double measure(Object anObject)
         {
            Rectangle aRectangle = (Rectangle) anObject;
            double area 
                  = aRectangle.getWidth() * aRectangle.getHeight();
            return area;
         }
      }

      Measurer m = new RectangleMeasurer();

      DataSet data = new DataSet(m);

      data.add(new Rectangle(5, 10, 20, 30));
      data.add(new Rectangle(10, 20, 30, 40));
      data.add(new Rectangle(20, 30, 5, 15));

      System.out.println("Average area: " + data.getAverage());
      System.out.println("Expected: 625");

      Rectangle max = (Rectangle) data.getMaximum();
      System.out.println("Maximum area rectangle: " + max);
      System.out.println("Expected: java.awt.Rectangle[x=10,y=20,width=30,height=40]");
   }
}
