
public class Loop
{
     public static void main(String args[])
     {
          double [] a1 = {0.0};
          double [] a2 = {-30.0, 25.0};
          double [] a3 = {-1.5, -1.6, -1.7};
          double [] a4 = {30.5, 100.0, 15.75, 300.0};
          
          try
          {
               addStuff(a1);
          }
          catch(ArrayIndexOutOfBoundsException e)
          {
               System.out.println("Question 1 was not fair!");
          }          
          
          addStuff(a1);
          addStuff(a2);
          addStuff(a3);
          addStuff(a4);
          
          
     }
     
     public static double addStuff(double [] a)
     {
          double balance = 0;
          
          for(int j = 0; j < 3; j++)
          {
               balance += a[j];
          }
          
          return balance;
     }
}