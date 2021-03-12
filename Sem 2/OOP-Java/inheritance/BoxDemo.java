/**
 *  This program demonstrates the Box class, which 
 *  inherits from the Rectangle class.  
 */
public class BoxDemo
{
   public static void main(String[] args)
   {
      // Create a Box object.
      Box room = new Box();

      // Set values in Box object.
      room.setBox(12.5, 10.5, 9.5);
      
      // Display the volume.
      System.out.println("Volume is " + room.getVolume());
   }
}