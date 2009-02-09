
public class RecursionTest01
{
     public static void main(String [] args)
     {
          for(int i = 1; i <= 10; i++)
          {
               System.out.println(getArea(i));  
               System.out.println(printTriangle(i));
          }
     }
     
     public static int getArea(int n)
     {
          if(n <  1) return 0;
          if(n == 1) return 1;
          else       return n + getArea(n-1);
     }
     
     public static String printTriangle(int n)
     {
          if(n <  1) return "";
          if(n == 1) return "[]";
          else       
          {
               String base = new String(); 
               base = makeBase(n, base);
               
               return printTriangle(n-1) + "\n" + base;
          }
     }
     
     public static String makeBase(int n, String base)
     {
          if(n == 1) return "[]";
          else       return "[]" + makeBase(n-1, base);
     }
}