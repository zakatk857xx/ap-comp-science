package P9_2;
public class QuizTest
{
     public static void main(String[] args)
     {
          DataSet data = new DataSet();
          
          data.add(new Quiz(100));
          data.add(new Quiz(90));
          data.add(new Quiz(80));
          data.add(new Quiz(94));
          data.add(new Quiz(87));
          data.add(new Quiz(34));
          data.add(new Quiz(40));
          data.add(new Quiz(72));
          
          System.out.println("Average: " 
                    + data.getAverage());
          System.out.println("Highest: " 
                    + ((Quiz)data.getMaximum()).getLetterGrade() 
                    + "(" + ((Quiz)data.getMaximum()).getNumericalGrade() + ")");          
          
     }

}
