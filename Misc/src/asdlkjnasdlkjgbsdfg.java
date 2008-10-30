public class asdlkjnasdlkjgbsdfg
{
     public static void main(String[] args)
     {
          
     }
     
     public static int countMatches(int[] ger, int val)
     {
          int counter = 0;

          for (int e : ger)//epic win
               if (val == e)
                    counter++;
          
          return counter;
     }
     
     public static int containsValue(int[] ger, int val)
     {
          for (int e : ger)//epic win, again
               if (val == e)
                    return 1;
          
          return -1;
     }
     
     public static int getMaxOrMin(int[] ger, int maxOrMin)
     {
          int value = 0;
          
          if(maxOrMin >= 0)
          {
               for(int i = 0; i < ger.length; i++)
                    if(ger[i] > value)
                         value = ger[i];
          }
          else if(maxOrMin < 0)
          {
               for(int i = 0; i < ger.length; i++)
                    if(ger[i] < value)
                         value = ger[i];
          }
          
          return value;
               
     }
}
