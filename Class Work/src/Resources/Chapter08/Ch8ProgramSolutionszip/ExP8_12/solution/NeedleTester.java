import java.lang.reflect.*;

public class NeedleTester
{
   public static void main(String[] args)
   {
      for (Field f : Needle.class.getDeclaredFields())
      {
         if (Modifier.isStatic(f.getModifiers()))
            System.out.println("static field: " + f.getType());
      }
      System.out.println("Expected: class java.util.Random");
   }
}
