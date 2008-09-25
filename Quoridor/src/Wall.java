/************************************************************************\
 * -----------------------------                                        *
 *  Introduction to Programming                                         *   
 * -----------------------------                                        *
 *          Name: Thomas Zaki                                           *
 * Last Modified: 05/12/08                                              *
 *         Title: Wall.java                                             *
 *   Description: Wall Object.  Many of the methods I use to manipulate *
 *                  the malls in the other classes are from the         *
 *                  superclass Line2D.Double and its superclass Line    *
 *                                                                      *
\************************************************************************/ 

import java.awt.geom.*;

public class Wall extends Line2D.Double
{
     private Point2D.Double pt1, pt2;
     
     public Wall()
     {
          super(0,0,0,0);
          pt1 = new Point2D.Double(0, 0);
          pt2 = new Point2D.Double(0, 0);
          super.setLine(pt1, pt2);
     }
     
     public Wall(int x1, int y1, int x2, int y2)
     {
          super(0,0,0,0);
          pt1 = new Point2D.Double(x1, y1);
          pt2 = new Point2D.Double(x2, y2);
          super.setLine(pt1, pt2);
     }
     
     public Wall(Point2D.Double a, Point2D.Double b)
     {
          super(0,0,0,0);
          pt1 = a;
          pt2 = b;
          super.setLine(pt1, pt2);
     }
     
     public Wall(Line2D.Double l)
     {
          super(0,0,0,0);
          pt1 = new Point2D.Double(l.getX1(), l.getY1());
          pt2 = new Point2D.Double(l.getX2(), l.getY2());
          super.setLine(l);
     }
     
     public Point2D.Double getEndPt1()
     {
          return pt1;
     }
     
     public Point2D.Double getEndPt2()
     {
          return pt2;
     }
     
     public void setEndPt1(Point2D.Double a)
     {
          pt1 = a;
     }
     
     public void setEndPt2(Point2D.Double b)
     {
          pt2 = b;
     }
     
     public Line2D.Double getLine()
     {
          return new Line2D.Double(pt1, pt2);
     }
      
     public Point2D.Double getMidpoint()
     {
          return new Point2D.Double((pt1.getX() + pt2.getX()) / 2, (pt1.getY() + pt2.getY()) / 2);
     }
     
     public String toString()
     {
          return new String ("[(x1: " + this.getEndPt1().getX() 
                                  + ", y1: " + this.getEndPt1().getY() 
                                  + ")<->(x2: " + this.getEndPt2().getX() 
                                  + ", y2: " + this.getEndPt2().getY() + ")]");
     }
     
     
}





