public class mys
{
     public static void main(String [] args)
     {
          mystery(3);
     }
     
     public static void mystery(int n)
     {
          System.out.print("M(" + n + ") -> ");
          
          if(n > 0)
          {
               System.out.print("((M1 called))");
               mystery(n - 1);
               System.out.println(n);
               System.out.print("((M2 called))");
               mystery(n - 1);
          }          
     }
}
