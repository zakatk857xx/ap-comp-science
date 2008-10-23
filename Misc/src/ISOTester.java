import java.util.Scanner;

public class ISOTester
{
     public static void main (String [] hello) 
     {          
          String block = "";
          int height = 0;
          Scanner in = new Scanner(System.in);
          
          ISOTriangle t1 = new ISOTriangle();
          System.out.println(t1);
                    
          ISOTriangle t2 = new ISOTriangle(5, "+");
          System.out.println(t2);
                             
          block = in.nextLine();
          height = in.nextInt();
          ISOTriangle t3= new ISOTriangle(height, block);
          System.out.println(t3);
          
     }//end main method

}//end class