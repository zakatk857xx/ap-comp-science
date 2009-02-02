
import java.io.*;
import java.util.*;

public class FileIO
{
     public static void main(String args[])
     {

          Scanner console = new Scanner(System.in);
          System.out.print("Input File: ");
          String inputFileName = console.next();
          //System.out.print("Output File: ");
          //String outputFileName = console.next();
          
          int chars = 0;
          int words = 0;
          int lines = 0;
          
          String doccument = new String("");
          
          
          try
          {               
               FileReader reader = new FileReader(inputFileName);
               Scanner in = new Scanner(reader);
               
               while(in.hasNextLine())
               {
                    doccument += in.nextLine() + " ";
                    chars--;
                    System.out.println(doccument);
               }
          }
          catch(FileNotFoundException e)
          {
               System.out.println("LOLFAIL");
               e.printStackTrace();
          }
     }

}
