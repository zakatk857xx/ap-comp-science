/**
 * This class reports bad input data
 */
public class BadDataException extends Exception
{
   public BadDataException () {}
   public BadDataException (String message)
   {
      super (message);
   }
}//end BadDataException class