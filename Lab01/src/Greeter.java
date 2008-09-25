/**
 * Greeter class
 * @author tzaki
 * @version Sep 19, 2008
 */
public class Greeter
{
     private String name;
     
     /**
      * Creates a new general Greeter with an
      *   empty name value
      */
     public Greeter()
     {
          name = new String("<no_name>");
     }
     
     /**
      * Creates a new Greeter with a specified name
      * @param n a name
      */
     public Greeter(String n)
     {
          name = new String(n);
     }
      
     /**
      * Says hello to the user
      * @return a greeting
      */
     public String sayHello()
     {
          return "Hello, " + name + ".";
     }
          
     /**
      * Says goodbye to the user
      * @return a parting phrase
      */
     public String sayGoodbye()
     {
          return "Goodbye, " + name + ".";
     }
          
     /**
      * Refuses to help the user
      * @return a refusal
      */
     public String refuseHelp()
     {
          return "I am sorry, " + name +". I am afraid I cannot do that.";
     }
}
