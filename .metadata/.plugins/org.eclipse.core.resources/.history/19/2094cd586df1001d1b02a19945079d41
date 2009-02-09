import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.util.Scanner;


public class P11_2
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
                    lines++;
                    doccument += in.nextLine().trim() + " ";
                    if(doccument.length() > doccument.trim().length() + 1)
                         words--;
                    //chars--;
                    //System.out.println(doccument);
               }
               
               for(int i = 0; i < doccument.length(); i++)
               {
                    if(doccument.charAt(i) == ' ')
                         words++;
                    else
                         chars++;
               }
          }
          catch(FileNotFoundException e)
          {
               System.out.println("LOLFAIL");
               e.printStackTrace();
          }
          finally
          {
               System.out.println("Lines: " + lines + "\nWords: " + words + "\nChars: " + chars);
          }
     }

}
