//Daniel R
//CS3
//Assignment 10
//Vulture

import java.awt.*;
public class Vulture extends Bird
{
   /*
   * initialized willEat: used to determine whether the Vulture will eat or not.
   */
   private boolean willEat;

   /*
   * The constructor, initializes the willEat variable
   */
   public Vulture()
   {
      this.willEat=true;
   }
   
   /*
   * gets the color of the vulture, which is always black
   * @return the color black
   */
   @Override
   public Color getColor()
   {
      return Color.BLACK;
   }  
   
   /*
   * the eat method, overwrites the critter eat and makes it so the vulture will eat food once (and when it fights)
   * @return true if willEat is true, false otherwise
   */
   @Override
   public boolean eat()
   { 
      if (willEat)
      {
         willEat=false;
         return true;
      }
      return false;
   }
   
   /*
   * The attack method, resets the eat boolean, as well as using the Bird
   * attack method.
   * @param the string of the opponent (found by its toString)
   * @return the bird fight method Attack
   */
   @Override
   public Attack fight(String opponent)
   {
      willEat=true;
      return super.fight(opponent);
   }
}