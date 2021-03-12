/**
 * Rectangle class using as super class.
 */
public class Rectangle
{
   private double length;  //To hold length
   private double width;   //To hold width

   /**
    * Sets length and width of rectangle
    */
   public void setRectangle(double length, double width)
   {
      this.length = length;
      this.width  = width;
   }
 
   /**
    * Returns area of rectangle
    */
   public double getArea()
   {
      return length * width;
   }
}



