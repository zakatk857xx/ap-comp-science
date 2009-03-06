A.

import java.awt.Color;
import java.util.ArrayList;

public class Car
{
     private int model;
     private Color extColor;
     private Color intColor;
     private ArrayList<String> features;
     
     public static final int COUPE = 0;
     public static final int SEDAN = 1;
     public static final int WAGON = 2;
     
     public Car()
     {
          model = 0;
          extColor = Color.RED;
          intColor = Color.GRAY;
          features = new ArrayList<String>();
     }
     
     public Car(int m, Color exterior, Color interior, ArrayList<String> f)
     {
          model = m;
          extColor = exterior;
          intColor = interior;
          features = f;
     }
     
     public int getModel() {...}
     public Color getExteriorColor() {...}
     public Color getInteriorColor() {...}
     public ArrayList<String> getFeatures() 
     {
          return features;
     }
     
     public void setModel(int m) {...}
     public void setExteriorColor(Color c) {...}
     public void setInteriorColor(Color c) {...}
     public void setFeatures(ArrayList<String> f) {...}

     public void addFeatures(ArrayList<String> f) {...}
     public void removeFeatures(ArrayList<String> f) {...}
     public void removeFeatures(int[] f) {...}
     

}

B.

public int carsProducedWith(String feature)
{
     int num = 0;
     
     for(Car c : carsProduced)
          for(String f : c.getFeatures())
               if(f.equals(feature)) num++;
     
     return num;
}
