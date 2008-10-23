/**
 * ISO TRIANGLE CREATOR
 * 
 * @author Tom Zaki
 * @version 1.0
 */

public class ISOTriangle
{
     
     private String symbol;
     private String r;
     private String s;
     private String t;
     private int size;
     private int base;
     
     public ISOTriangle()
     {
          size = 5;
          base = ((2 * size) - 1);
          symbol = "^";
          r = "";
          s = "";
          t = "";
     }
     
     public ISOTriangle(int heightSize, String aSymbol)
     {
          size = heightSize + 1;
          base = ((2 * size) - 1);
          symbol = aSymbol;
          r = "";
          s = "";
          t = "";
     }
     
     public String toString()
     {
          for(int i = 0; i < size; i++)
          {
               r = "";
               for(int j = 0; j < (2 * i) - 1; j++)
               {
                    r += symbol;
               }
               
               s = "";
               for(int k = 1; k <= ((base/2) - i); k++)
               {
                    for(int l = 0; l < symbol.length(); l++)
                    s += " ";
               }
               
               t = t + (s + r + s + "\n");               
          } 
          
          t = t.substring ((base * symbol.length()) - (symbol.length() - 1), t.length()); 
          return t;
     }    
}