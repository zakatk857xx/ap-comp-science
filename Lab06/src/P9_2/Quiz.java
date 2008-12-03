package P9_2;
public class Quiz implements Measurable
{
     private String letterGrade;
     private double numericalGrade;
     
     public Quiz(double ng)
     {
          numericalGrade = ng;
          this.setLetterGrade();
     }     
     
     public double getNumericalGrade()
     {
          return numericalGrade;
     }
     
     public String getLetterGrade()
     {
          return letterGrade;
     }
     
     private void setLetterGrade()
     {
          if(numericalGrade >= 93)
               letterGrade = "A";
          else if(numericalGrade < 93 && numericalGrade >= 89 )
               letterGrade = "B+";
          else if(numericalGrade < 89 && numericalGrade >= 85 )
               letterGrade = "B";
          else if(numericalGrade < 85 && numericalGrade >= 81 )
               letterGrade = "C+";
          else if(numericalGrade < 81 && numericalGrade >= 77 )
               letterGrade = "C";
          else if(numericalGrade < 77 && numericalGrade >= 73 )
               letterGrade = "D+";
          else if(numericalGrade < 73 && numericalGrade >= 70 )
               letterGrade = "D";
          else if(numericalGrade < 70)
               letterGrade = "F";               
     }
     
     public double getMeasure()
     {
          return this.getNumericalGrade();
     }

}
